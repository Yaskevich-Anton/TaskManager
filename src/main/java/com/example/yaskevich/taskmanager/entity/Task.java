package com.example.yaskevich.taskmanager.entity;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    Long id;
    String taskName;
    LocalDateTime deadLine;
    Status status;
}
