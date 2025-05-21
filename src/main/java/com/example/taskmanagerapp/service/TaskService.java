package com.example.taskmanagerapp.service;

import com.example.taskmanagerapp.dto.TaskRequestDto;
import com.example.taskmanagerapp.dto.TaskResponseDto;
import com.example.taskmanagerapp.entity.Author;
import com.example.taskmanagerapp.entity.Task;
import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import com.example.taskmanagerapp.repository.AuthorRepository;
import com.example.taskmanagerapp.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final AuthorRepository authorRepository;

    public void createTask(TaskRequestDto taskRequestDto, Long authorId) {
        Task requestTask = new Task(taskRequestDto);
        Author author = authorRepository.getReferenceById(authorId);
        requestTask.setAuthor(author);
        taskRepository.save(requestTask);
    }

    public List<TaskResponseDto> findTaskList(Long authorId) {
        List<Task> taskList = taskRepository.findAllByAuthorIdOrderByUpdateDateDesc(authorId);
        List<TaskResponseDto> responseTaskList = taskList.stream().map(task -> new TaskResponseDto(task)).collect(Collectors.toList());
        return responseTaskList;
    }

    public TaskResponseDto findTask(Long authorId, Long taskId) {
        Task task = emptyCheck(taskId);
        ownerCheck(task, authorId);

        TaskResponseDto taskResponseDto = new TaskResponseDto(task);
        return taskResponseDto;
    }

    public void setTask(Long authorId, TaskRequestDto taskRequestDto, Long taskId) {
        Task task = emptyCheck(taskId);
        ownerCheck(task, authorId);

        task.setTaskTitle(taskRequestDto.getTaskTitle());
        task.setTaskContent(taskRequestDto.getTaskContent());
        taskRepository.save(task);
    }

    public void deleteTask(Long authorId, Long taskId) {
        Task task = emptyCheck(taskId);
        ownerCheck(task, authorId);

        taskRepository.deleteById(taskId);
    }

    private Task emptyCheck(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if(optionalTask.isEmpty())
            throw new EntityNotFoundException();
        Task task = optionalTask.get();
        return task;
    }

    private void ownerCheck(Task task, Long authorId){
        Long taskOwnerId = task.getAuthor().getId();
        if(!taskOwnerId.equals(authorId)) {
            throw new LoginAuthenticationException();
        }
    }

}
