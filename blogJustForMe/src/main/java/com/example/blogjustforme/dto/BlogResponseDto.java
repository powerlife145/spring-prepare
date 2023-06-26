package com.example.blogjustforme.dto;


import com.example.blogjustforme.entity.Blog;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BlogResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDate date;
    private String password;


    public BlogResponseDto(Blog blog) {
        this.id = blog.getId();
        this.username = blog.getUsername();
        this.contents = blog.getContents();
        this.password = blog.getPassword();
        this.date=blog.getDate();


    }
}