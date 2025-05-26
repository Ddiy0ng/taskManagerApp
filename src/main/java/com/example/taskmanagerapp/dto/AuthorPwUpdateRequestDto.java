package com.example.taskmanagerapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorPwUpdateRequestDto {
    //비밀번호만 업데이트
    @NotBlank
    private final String oldPassword;

    @NotBlank
    private final String newPassword;
}
