package com.example.taskmanagerapp.exceptionHandler;

import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import com.example.taskmanagerapp.exceptionHandler.customError.PasswordMismatchException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler { ;
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler(){
        return new ResponseEntity<>(ErrorType.ENTITY_NOT_FOUND.getErrorMessage(), ErrorType.ENTITY_NOT_FOUND.getHttpStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidHandler(){
        return new ResponseEntity<>(ErrorType.METHOD_ARGUMENT_NOT_VALID.getErrorMessage(), ErrorType.METHOD_ARGUMENT_NOT_VALID.getHttpStatus());
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterHandler(){
        return new ResponseEntity<>(ErrorType.MISSING_SERVLET_REQUEST_PARAMETER.getErrorMessage(), ErrorType.MISSING_SERVLET_REQUEST_PARAMETER.getHttpStatus());
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> accessDeniedHandler(){
        return new ResponseEntity<>(ErrorType.ACCESS_DENIED.getErrorMessage(), ErrorType.ACCESS_DENIED.getHttpStatus());
    }
    @ExceptionHandler(LoginAuthenticationException.class)
    public ResponseEntity<String> loginAuthenticationHandler(){
        return new ResponseEntity<>(ErrorType.LOGIN_AUTHENTICATION.getErrorMessage(), ErrorType.LOGIN_AUTHENTICATION.getHttpStatus());
    }
    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<String> passwordAuthenticationHandler(){
        return new ResponseEntity<>(ErrorType.PASSWORD_MISMATCH.getErrorMessage(), ErrorType.PASSWORD_MISMATCH.getHttpStatus());
    }
}
