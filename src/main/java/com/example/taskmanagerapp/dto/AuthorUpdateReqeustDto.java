package com.example.taskmanagerapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorUpdateReqeustDto {
    @NotBlank
    private final String authorName;

    @Email
    @NotBlank
    private final String email;
}
