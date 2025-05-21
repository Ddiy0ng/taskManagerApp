package com.example.taskmanagerapp.dto;

import com.example.taskmanagerapp.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private final Long authorId;
    private final String commentContent;
    private final Timestamp postDate;
    private final Timestamp updateDate;

    public CommentResponseDto(Comment comment){
        this.authorId = comment.getAuthorId();
        this.commentContent = comment.getCommentContent();
        this.postDate = comment.getPostDate();
        this.updateDate = comment.getUpdateDate();
    }
}
