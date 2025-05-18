package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.TaskRequestDto;
import com.example.taskmanagerapp.dto.TaskResponseDto;
import com.example.taskmanagerapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors/{authorId}")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody TaskRequestDto taskRequestDto){
        taskService.signUp(taskRequestDto);
        return new ResponseEntity<>("일정을 추가했습니다.", HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> findAllTasks(@PathVariable String authorId){
        List<TaskResponseDto> taskList = taskService.findAllTasks();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
/*
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskResponseDto> readTask(){

    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<String> updateTask(){

    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(){

    }

 */
}
