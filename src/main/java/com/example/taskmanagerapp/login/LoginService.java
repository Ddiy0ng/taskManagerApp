
package com.example.taskmanagerapp.login;

import com.example.taskmanagerapp.config.PasswordEncoder;
import com.example.taskmanagerapp.entity.Author;
import com.example.taskmanagerapp.exceptionHandler.customError.PasswordEmailMismatchException;
import com.example.taskmanagerapp.exceptionHandler.customError.PasswordMismatchException;
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
            throw new PasswordEmailMismatchException();
        }
        Author author = optionalAuthor.get();
        String savedPw = author.getPassword();
        String inputPw = loginRequestDto.getPassword();
        if(!passwordEncoder.matches(inputPw, savedPw)) {
            throw new PasswordEmailMismatchException();
        }
        return author;
    }
}
