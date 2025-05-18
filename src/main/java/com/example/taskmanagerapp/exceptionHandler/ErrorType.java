package com.example.taskmanagerapp.exceptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 데이터를 찾을 수 없습니다."),//DB 조회 실패
    //DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "이미 존재하는 리소스입니다."),//이메일 중복 가입 등 중복 리소스 등록
    METHOD_ARGUMENT_NOT_VALID(HttpStatus.BAD_REQUEST, "형식을 준수해서 입력해야 합니다."),//@VALID 실패
    MISSING_SERVLET_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."), //필수 파라미터 누락
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "인가에 실패했습니다."),//인가 실패
    AUTHENTICATION(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    ErrorType(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
