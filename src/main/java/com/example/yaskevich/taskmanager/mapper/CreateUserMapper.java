package com.example.yaskevich.taskmanager.mapper;

import com.example.yaskevich.taskmanager.dto.CreateUserDto;
import com.example.yaskevich.taskmanager.entity.Role;
import com.example.yaskevich.taskmanager.entity.User;
import com.example.yaskevich.taskmanager.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    public static final CreateUserMapper INSTANCE  = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .build();
    }
    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
