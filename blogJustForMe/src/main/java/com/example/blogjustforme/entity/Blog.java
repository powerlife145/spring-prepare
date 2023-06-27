package com.example.blogjustforme.entity;



import com.example.blogjustforme.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;

    private LocalDate date;
    //entity
    public Blog(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.date = requestDto.getDate();
        this.password=requestDto.getPassword();

    }

    public void update(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.date = requestDto.getDate();
        this.password=requestDto.getPassword();
        this.title=requestDto.getTitle();

    }


}
