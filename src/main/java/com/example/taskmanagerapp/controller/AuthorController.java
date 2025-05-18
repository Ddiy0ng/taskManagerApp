package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.AuthorPwUpdateRequestDto;
import com.example.taskmanagerapp.dto.AuthorRequestDto;
import com.example.taskmanagerapp.dto.AuthorResponseDto;
import com.example.taskmanagerapp.dto.AuthorUpdateReqeustDto;
import com.example.taskmanagerapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping()
    public ResponseEntity<String> signUp(@RequestBody AuthorRequestDto authorRequestDto){
        authorService.signUp(authorRequestDto);
        return new ResponseEntity<>("회원가입을 완료했습니다.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AuthorResponseDto>> readAllAuthors(){
        List<AuthorResponseDto> authorList = authorService.findAllAuthors();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> readAuthor(@PathVariable Long authorId){
        AuthorResponseDto authorResponseDto = authorService.findAuthor(authorId);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{authorId}/update")
    public ResponseEntity<String> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorUpdateReqeustDto authorUpdateRequestDto){
        authorService.updateAuthor(authorId, authorUpdateRequestDto);
        return new ResponseEntity<>("회원 정보를 수정했습니다.", HttpStatus.OK);
    }

    @PutMapping("/{authorId}/updatePw")
    public ResponseEntity<String> updateAuthorPassword(@PathVariable Long authorId, @RequestBody AuthorPwUpdateRequestDto authorPwUpdateDto){
        authorService.updateAuthorPw(authorId, authorPwUpdateDto);
        return new ResponseEntity<>("비밀번호를 변경했습니다.", HttpStatus.OK);
    }

}
