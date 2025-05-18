package com.example.taskmanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorPwUpdateRequestDto {
    //비밀번호만 업데이트
    private final String oldPassword;
    private final String newPassword;
}
