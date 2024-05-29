package com.example.yaskevich.taskmanager.dto;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import com.example.yaskevich.taskmanager.entity.Status;
import lombok.*;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskDto {
    Long id;
    String description;
}
