package com.example.taskmanagerapp.service;

import com.example.taskmanagerapp.dto.CommentRequestDto;
import com.example.taskmanagerapp.dto.CommentResponseDto;
import com.example.taskmanagerapp.entity.Comment;
import com.example.taskmanagerapp.entity.Task;
import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import com.example.taskmanagerapp.repository.CommentRepository;
import com.example.taskmanagerapp.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    //다른 사용자도 댓글 생성 가능
    public void createComment(CommentRequestDto commentRequestDto, Long authorId, Long taskId) {
        Comment comment = new Comment(commentRequestDto);
        Task task = taskRepository.getReferenceById(taskId);
        comment.setTask(task);
        comment.setAuthorId(authorId);
        commentRepository.save(comment);
    }

    //task의 전체 댓글 조회
    public List<CommentResponseDto> findCommentList(Long taskId) {
        List<Comment> commentList = commentRepository.findAllByTaskIdOrderByUpdateDateDesc(taskId);
        List<CommentResponseDto> responseTaskList = commentList.stream().map(comment -> new CommentResponseDto(comment)).collect(Collectors.toList());
        return responseTaskList;
    }

    //본인 댓글만 수정
    public void setComment(Long authorId, CommentRequestDto commentRequestDto, Long commentId, Long taskId) {
        Comment comment = emptyCheck(commentId);
        ownerCheck(comment, authorId);
        comment.setCommentContent(commentRequestDto.getCommentContent());
        commentRepository.save(comment);
    }

    public void deleteComment(Long authorId, Long commentId) {
        Comment comment = emptyCheck(commentId);
        ownerCheck(comment, authorId);
        commentRepository.deleteById(commentId);
    }

    private Comment emptyCheck(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if(optionalComment.isEmpty())
            throw new EntityNotFoundException();
        Comment comment = optionalComment.get();
        return comment;
    }

    private void ownerCheck(Comment comment, Long authorId){
        Long commentOwnerId = comment.getAuthorId();
        if(!commentOwnerId.equals(authorId)) {
            throw new LoginAuthenticationException();
        }
    }


}
