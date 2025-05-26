package com.example.taskmanagerapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskRequestDto {
    @NotBlank
    private final String taskTitle;

    @NotBlank
    private final String taskContent;
}
