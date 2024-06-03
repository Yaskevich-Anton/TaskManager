package com.example.yaskevich.taskmanager.mapper;

import com.example.yaskevich.taskmanager.dto.CreateTaskDto;
import com.example.yaskevich.taskmanager.dto.TaskDto;
import com.example.yaskevich.taskmanager.entity.Role;
import com.example.yaskevich.taskmanager.entity.Status;
import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.entity.User;
import com.example.yaskevich.taskmanager.util.LocalDateFormatter;

import java.time.LocalDateTime;

public class CreateTaskMapper implements Mapper<CreateTaskDto, Task>{

    public static final CreateTaskMapper INSTANCE  = new CreateTaskMapper();

    public static CreateTaskMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public Task mapFrom(CreateTaskDto object) {
        return Task.builder()
                .taskName(object.getTaskName())
                .status(Status.valueOf(object.getStatus()))
                .deadLine(LocalDateTime.parse(object.getDeadLine()))
                .build();
    }
}
