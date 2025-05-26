package com.example.taskmanagerapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorRequestDto {
    @NotBlank(message = "작성자를 입력하세요.")
    private final String authorName;

    @Email
    @NotBlank(message = "이메일을 입력하세요.")
    private final String email;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private final String password;
}
