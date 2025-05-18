package com.example.taskmanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskRequestDto {
    private final String taskTitle;
    private final String taskContent;
}
