package com.example.yaskevich.taskmanager.service;

import com.example.yaskevich.taskmanager.dao.UserDao;
import com.example.yaskevich.taskmanager.dto.CreateUserDto;
import com.example.yaskevich.taskmanager.dto.UserDto;
import com.example.yaskevich.taskmanager.exception.ValidationException;
import com.example.yaskevich.taskmanager.mapper.CreateUserMapper;
import com.example.yaskevich.taskmanager.mapper.UserMapper;
import com.example.yaskevich.taskmanager.validator.CreateUserValidator;

import java.util.Optional;

public class UserService {
    public static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    private final UserMapper userMapper = UserMapper.getInstance();

    public Optional<UserDto> login(String email, String password){
        return userDao.findByLoginAndPassword(email,password)
                .map(userMapper::mapFrom);
    }
    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
