package com.example.taskmanagerapp.repository;

import com.example.taskmanagerapp.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findAllByAuthorIdOrderByUpdateDateDesc(Long authorId, Pageable pageable);
}
