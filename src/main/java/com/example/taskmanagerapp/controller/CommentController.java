package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.CommentRequestDto;
import com.example.taskmanagerapp.dto.CommentResponseDto;
import com.example.taskmanagerapp.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authors/tasks")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{taskId}/comments/post")
    public ResponseEntity<String> createComment(@PathVariable Long taskId, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        commentService.createComment(commentRequestDto, authorId, taskId);
        return new ResponseEntity<>("댓글을 추가했습니다.", HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}/comments")
    public ResponseEntity<List<CommentResponseDto>> findCommentList(@RequestParam(defaultValue = "0") int pageNumber, @PathVariable Long taskId){
        List<CommentResponseDto> commentList = commentService.findCommentList(pageNumber, taskId);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PutMapping("/{taskId}/comments/{commentId}")
    public ResponseEntity<String> setComment(@PathVariable Long taskId, @PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        commentService.setComment(authorId, commentRequestDto, taskId, commentId);
        return new ResponseEntity<>("수정을 완료했습니다", HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long taskId, @PathVariable Long commentId, HttpServletRequest httpServletRequest){
        Long authorId = (Long)httpServletRequest.getSession().getAttribute("sessionKey");
        commentService.deleteComment(authorId, commentId);
        return new ResponseEntity<>("댓글을 삭제했습니다.", HttpStatus.OK);

    }

}
