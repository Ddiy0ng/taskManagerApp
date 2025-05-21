package com.example.taskmanagerapp.service;

import com.example.taskmanagerapp.config.PasswordEncoder;
import com.example.taskmanagerapp.dto.AuthorPwUpdateRequestDto;
import com.example.taskmanagerapp.dto.AuthorRequestDto;
import com.example.taskmanagerapp.dto.AuthorResponseDto;
import com.example.taskmanagerapp.dto.AuthorUpdateReqeustDto;
import com.example.taskmanagerapp.entity.Author;
import com.example.taskmanagerapp.exceptionHandler.customError.PasswordMismatchException;
import com.example.taskmanagerapp.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setAuthorName(authorRequestDto.getAuthorName());
        author.setEmail(authorRequestDto.getEmail());
        String password = passwordEncoder.encode(authorRequestDto.getPassword());
        author.setPassword(password);
        authorRepository.save(author);
    }

    public AuthorResponseDto findAuthor(Long authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty())
            throw new EntityNotFoundException();
        Author author = optionalAuthor.get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto(author);
        return authorResponseDto;
    }
    @Transactional
    public void updateAuthor(Long authorId, AuthorUpdateReqeustDto authorUpdateReqeustDto) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty())
            throw new EntityNotFoundException();
        Author author = optionalAuthor.get();
        author.setAuthorName(authorUpdateReqeustDto.getAuthorName());
        author.setEmail(authorUpdateReqeustDto.getEmail());
    }

    @Transactional
    public void updateAuthorPw(Long authorId, AuthorPwUpdateRequestDto authorPwUpdateDto) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty())
            throw new EntityNotFoundException();
        Author author = optionalAuthor.get();
        if(!author.getPassword().equals(authorPwUpdateDto.getOldPassword()))
            throw new PasswordMismatchException();
        author.setPassword(authorPwUpdateDto.getNewPassword());
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
