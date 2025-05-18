package com.example.taskmanagerapp.dto;

import com.example.taskmanagerapp.entity.Author;
import lombok.Getter;
import java.sql.Timestamp;

@Getter
public class AuthorResponseDto {
    private final String authorName;
    private final String email;
    private final Timestamp postDate;
    private final Timestamp updateDate;

    public AuthorResponseDto(Author author){
        this.authorName = author.getAuthorName();
        this.email = author.getEmail();
        this.postDate = author.getPostDate();
        this.updateDate = author.getUpdateDate();
    }
}
