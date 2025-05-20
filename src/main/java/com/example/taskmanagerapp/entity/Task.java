package com.example.taskmanagerapp.entity;

import com.example.taskmanagerapp.dto.TaskRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Task extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskContent;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public Task(TaskRequestDto taskRequestDto) {
        this.taskTitle = taskRequestDto.getTaskTitle();
        this.taskContent = taskRequestDto.getTaskContent();
    }
}
