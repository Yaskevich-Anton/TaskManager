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
        map(task -> TaskDto.builder().id(task.getId()).description(
                """
                 %s
                 """.formatted(task.getStatus())).build()
        )
        .collect(toList());
    }
    public static TaskService getInstance(){
        return INSTANCE;
    }
}
