package com.example.taskmanagerapp.repository;

import com.example.taskmanagerapp.entity.Comment;
import com.example.taskmanagerapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByTaskIdOrderByUpdateDateDesc(Long taskId);
}
