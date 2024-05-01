package com.example.yaskevich.taskmanager.service;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import com.example.yaskevich.taskmanager.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TaskService {
    private static final TaskService INSTANCE = new TaskService();
    private final TaskDao taskDao = TaskDao.getInstance();
    private TaskService(){
    }
    public List<TaskDto> findAll(){
return taskDao.findAll().stream().
        map(task -> new TaskDto(
                task.getId(),
                """
                 %s
                 """.formatted(task.getStatus())
        ))
        .collect(toList());
    }
    public static TaskService getInstance(){
        return INSTANCE;
    }
}
