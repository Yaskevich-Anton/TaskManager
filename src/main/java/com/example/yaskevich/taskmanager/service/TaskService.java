package com.example.yaskevich.taskmanager.service;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import com.example.yaskevich.taskmanager.dto.TaskDto;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class TaskService {
    private static final TaskService INSTANCE = new TaskService();
    private final TaskDao taskDao = TaskDao.getInstance();

    private TaskService() {
    }

    public List<TaskDto> findAll() {
        return taskDao.findAll().stream().
                map(task -> TaskDto.builder().id(task.getId()).description(
                                """
                                        %s - %s - %s
                                        """.formatted(task.getStatus(),
                                        task.getDeadLine(),
                                        task.getTaskName())).
                        build()
                )
                .collect(toList());
    }

    public Optional<TaskDto> findById(Long id) {
        return taskDao.findById(id).map(task -> TaskDto.builder()
                .id(task.getId())
                .description(String.format("%s - %s - %s",
                        task.getTaskName(),
                        task.getStatus(),
                        task.getDeadLine()))
                .build());
    }


    public static TaskService getInstance() {
        return INSTANCE;
    }
}
