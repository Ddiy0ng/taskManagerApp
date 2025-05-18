package com.example.taskmanagerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import java.sql.Timestamp;

@Getter
@Entity
public class Comment {
    @Id
    private Long id;
    private Long taskId;
    private Long authorId;
    private String commentContent;
    private Timestamp postDate;
    private Timestamp updateDate;
}
