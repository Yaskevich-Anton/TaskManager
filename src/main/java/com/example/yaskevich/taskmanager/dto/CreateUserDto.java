package com.example.yaskevich.taskmanager.dto;

import com.example.yaskevich.taskmanager.entity.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;

}
