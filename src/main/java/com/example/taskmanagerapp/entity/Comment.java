package com.example.taskmanagerapp.entity;

import com.example.taskmanagerapp.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private String commentContent;

    public Comment(CommentRequestDto commentRequestDto){
        this.commentContent = commentRequestDto.getCommentContent();
    }
}
