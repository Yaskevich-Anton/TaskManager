package com.example.yaskevich.taskmanager.service;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import com.example.yaskevich.taskmanager.dto.CreateTaskDto;
import com.example.yaskevich.taskmanager.dto.TaskDto;
import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.mapper.CreateTaskMapper;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class TaskService {
    private static final TaskService INSTANCE = new TaskService();
    private final TaskDao taskDao = TaskDao.getInstance();

    private final CreateTaskMapper createTaskMapper = CreateTaskMapper.getInstance();

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
        Optional<Task> taskOptional = taskDao.findById(id);
        return taskOptional.map(task -> TaskDto.builder()
                .id(task.getId())
                .description(String.format("%s - %s - %s",
                        task.getTaskName(),
                        task.getStatus(),
                        task.getDeadLine()))
                .build());
//        return taskDao.findById(id).map(task -> TaskDto.builder()
//                .id(task.getId())
//                .description(String.format("%s - %s - %s",
//                        task.getTaskName(),
//                        task.getStatus(),
//                        task.getDeadLine()))
//                .build());
    }
    public Long save(CreateTaskDto taskDto) {
        var taskEntity = createTaskMapper.mapFrom(taskDto);
        taskDao.save(taskEntity);
        return taskEntity.getId();
    }

    public static TaskService getInstance() {
        return INSTANCE;
    }
}
