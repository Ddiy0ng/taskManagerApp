package com.example.taskmanagerapp.service;

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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public void signUp(AuthorRequestDto authorRequestDto) {
        Author requestAuthor = new Author(authorRequestDto);
        authorRepository.save(requestAuthor);
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
