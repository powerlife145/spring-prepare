package com.example.blogjustforme.dto;


import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BlogRequestDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;
    private LocalDate date;

    public LocalDate getDate() {
        this.date = LocalDate.now();
        return date;
    }
}