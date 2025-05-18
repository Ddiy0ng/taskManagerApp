package com.example.taskmanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorRequestDto {
    private final String authorName;
    private final String email;
    private final String password;
}
