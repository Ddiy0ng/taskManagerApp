package com.example.taskmanagerapp.dto;

import com.example.taskmanagerapp.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
    private final String taskTitle;
    private final String taskContent;
    private final Timestamp postDate;
    private final Timestamp updateDate;

    public TaskResponseDto(Task task){
        this.taskTitle = task.getTaskTitle();
        this.taskContent = task.getTaskContent();
        this.postDate = task.getPostDate();
        this.updateDate = task.getUpdateDate();
    }
}


