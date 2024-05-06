package com.example.yaskevich.taskmanager.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class UserDto {
    Long id;
    String username;
}
