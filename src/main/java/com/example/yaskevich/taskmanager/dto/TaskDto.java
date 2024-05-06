package com.example.yaskevich.taskmanager.dto;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import lombok.*;

@Value
@Builder
public class TaskDto {
    Long id;
    String description;
}
