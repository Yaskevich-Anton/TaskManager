package com.example.yaskevich.taskmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long id;
    private String taskName;
    private LocalDateTime deadLine;
    private Status status;
}
