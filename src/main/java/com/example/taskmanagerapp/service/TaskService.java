package com.example.taskmanagerapp.service;

import com.example.taskmanagerapp.dto.TaskRequestDto;
import com.example.taskmanagerapp.dto.TaskResponseDto;
import com.example.taskmanagerapp.entity.Task;
import com.example.taskmanagerapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void signUp(TaskRequestDto taskRequestDto) {
        Task requestTask = new Task(taskRequestDto);
        taskRepository.save(requestTask);
    }

    public List<TaskResponseDto> findAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskResponseDto> responseTaskList = taskList.stream().map(task -> new TaskResponseDto(task)).collect(Collectors.toList());
        return responseTaskList;
    }
}
