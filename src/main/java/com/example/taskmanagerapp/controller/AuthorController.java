package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.AuthorPwUpdateRequestDto;
import com.example.taskmanagerapp.dto.AuthorRequestDto;
import com.example.taskmanagerapp.dto.AuthorResponseDto;
import com.example.taskmanagerapp.dto.AuthorUpdateReqeustDto;
import com.example.taskmanagerapp.service.AuthorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@Valid @RequestBody AuthorRequestDto authorRequestDto){
        authorService.signUp(authorRequestDto);
        return new ResponseEntity<>("회원가입을 완료했습니다.", HttpStatus.CREATED);
    }

    //사용자 정보
    @GetMapping()
    public ResponseEntity<AuthorResponseDto> findAuthor(HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        AuthorResponseDto authorResponseDto = authorService.findAuthor(authorId);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    //사용자 정보 수정
    @PutMapping("/updateInfo")
    public ResponseEntity<String> updateAuthor(@Valid @RequestBody AuthorUpdateReqeustDto authorUpdateRequestDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        authorService.updateAuthor(authorId, authorUpdateRequestDto);
        return new ResponseEntity<>("회원 정보를 수정했습니다.", HttpStatus.OK);
    }

    //사용자 비번 수정
    @PutMapping("/updatePw")
    public ResponseEntity<String> updateAuthorPw(@Valid @RequestBody AuthorPwUpdateRequestDto authorPwUpdateDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        authorService.updateAuthorPw(authorId, authorPwUpdateDto);
        return new ResponseEntity<>("비밀번호를 변경했습니다.", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAuthor(HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("삭제했습니다.", HttpStatus.OK);
    }

}
