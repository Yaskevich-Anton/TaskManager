package com.example.yaskevich.taskmanager.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

   private Long id;
   private String taskName;
   private LocalDateTime deadLine;
   private Status status;
}
