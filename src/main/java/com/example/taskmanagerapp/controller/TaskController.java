package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.TaskRequestDto;
import com.example.taskmanagerapp.dto.TaskResponseDto;
import com.example.taskmanagerapp.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/post")
    public ResponseEntity<String> createTask(@RequestBody TaskRequestDto taskRequestDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        taskService.createTask(taskRequestDto, authorId);
        return new ResponseEntity<>("일정을 추가했습니다.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> findTaskList(@RequestParam(defaultValue = "0") int pageNumber, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        List<TaskResponseDto> taskDtoList = taskService.findTaskList(pageNumber, authorId);
        return new ResponseEntity<>(taskDtoList, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> findTask(@PathVariable Long taskId, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        TaskResponseDto taskResponseDto = taskService.findTask(authorId, taskId);
        return new ResponseEntity<>(taskResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<String> setTask(@PathVariable Long taskId, @RequestBody TaskRequestDto taskRequestDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        taskService.setTask(authorId, taskRequestDto, taskId);
        return new ResponseEntity<>("수정을 완료했습니다", HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        taskService.deleteTask(authorId, taskId);
        return new ResponseEntity<>("일정을 삭제했습니다.", HttpStatus.OK);

    }

}
