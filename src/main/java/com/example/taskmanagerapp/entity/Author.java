package com.example.taskmanagerapp.entity;

import com.example.taskmanagerapp.dto.AuthorRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "author")
public class Author extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Author(AuthorRequestDto authorRequestDto){
        this.authorName = authorRequestDto.getAuthorName();
        this.email = authorRequestDto.getEmail();
        this.password = authorRequestDto.getPassword();
    }
}
