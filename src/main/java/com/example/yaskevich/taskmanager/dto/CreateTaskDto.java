package com.example.yaskevich.taskmanager.dto;

import com.example.yaskevich.taskmanager.entity.Status;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class CreateTaskDto {
  String taskName;
  String deadLine;
  String status;

}