package com.example.taskmanagerapp.login;

import com.example.taskmanagerapp.entity.Author;
import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import com.example.taskmanagerapp.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class LoginService {
    private final AuthorRepository authorRepository;
    public LoginService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author login(LoginRequestDto loginRequestDto) {
        Optional<Author> optionalAuthor = Optional.ofNullable(authorRepository.findByEmail(loginRequestDto.getEmail()));
        if(optionalAuthor.isEmpty()) {
            System.out.println("1번 이슈");
            throw new LoginAuthenticationException();
        }
        Author author = optionalAuthor.get();
        String checkPw = author.getPassword();
        String inputPw = loginRequestDto.getPassword();
        if(!checkPw.equals(inputPw)) {
            System.out.println("2번 이슈");
            log.info("원래 비밀번호: {}", checkPw);
            log.info("입력 비밀번호: {}", inputPw);
            throw new LoginAuthenticationException();
        }
        return author;
    }
}
