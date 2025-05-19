package com.example.taskmanagerapp.exceptionHandler.customError;

import com.example.taskmanagerapp.exceptionHandler.ErrorType;

public class LoginAuthenticationException extends RuntimeException{
    public LoginAuthenticationException(){
        super(ErrorType.LOGIN_AUTHENTICATION.getErrorMessage());
    }
}
