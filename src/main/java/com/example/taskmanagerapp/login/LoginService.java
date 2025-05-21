package com.example.taskmanagerapp.login;

import com.example.taskmanagerapp.config.PasswordEncoder;
import com.example.taskmanagerapp.entity.Author;
import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import com.example.taskmanagerapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {
    private final AuthorRepository authorRepository;
    private final PasswordEncoder passwordEncoder;

    public Author login(LoginRequestDto loginRequestDto) {
        Optional<Author> optionalAuthor = Optional.ofNullable(authorRepository.findByEmail(loginRequestDto.getEmail()));
        if(optionalAuthor.isEmpty()) {
            System.out.println("1번 이슈");
            throw new LoginAuthenticationException();
        }
        Author author = optionalAuthor.get();
        String savedPw = author.getPassword();
        String inputPw = loginRequestDto.getPassword();
        if(!passwordEncoder.matches(inputPw, savedPw)) {
            System.out.println("2번 이슈");
            log.info("원래 비밀번호: {}", savedPw);//테스트 때 로그인 편하게 하려고...잠시 넣어둠
            log.info("입력 비밀번호: {}", inputPw);
            throw new LoginAuthenticationException();
        }
        return author;
    }
}
