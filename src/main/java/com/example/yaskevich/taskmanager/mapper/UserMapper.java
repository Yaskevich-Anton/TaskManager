package com.example.yaskevich.taskmanager.mapper;

import com.example.yaskevich.taskmanager.dto.UserDto;
import com.example.yaskevich.taskmanager.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {

    public static final UserMapper INSTANCE = new UserMapper();
    // MapStruct
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .build();
    }
    public static UserMapper getInstance(){
        return INSTANCE;
    }
}
