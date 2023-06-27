package com.example.blogjustforme.controller;

import com.example.blogjustforme.dto.BlogRequestDto;
import com.example.blogjustforme.dto.BlogResponseDto;
import com.example.blogjustforme.entity.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class BlogController {
    private final Map<Long, Blog> blogList = new HashMap<>();
        @PostMapping("/blogs")

        public BlogResponseDto createBlog(@RequestBody BlogRequestDto requestDto) {

            // RequestDto -> Entity
            Blog blog = new Blog(requestDto);

            // Memo Max ID Check
            Long maxId = blogList.size() > 0 ? Collections.max(blogList.keySet()) + 1 : 1;
            blog.setId(maxId);

            // DB 저장
            blogList.put(blog.getId(), blog);

            // Entity -> ResponseDto
            BlogResponseDto memoResponseDto = new BlogResponseDto(blog);

            return memoResponseDto;
        }

        @GetMapping("/blogs")
        public List<BlogResponseDto> getblogs() {
            // Map To List
            List<BlogResponseDto> responseList = blogList.values().stream()
                    .map(BlogResponseDto::new).toList();

            return responseList;
        }




        @PutMapping("/blogs/{id}")
        public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
            // 해당 메모가 DB에 존재하는지 확인
            if(blogList.containsKey(id)) {
                // 해당 메모 가져오기
                Blog blog = blogList.get(id);

                // password 확인
                if(blog.getPassword().equals(requestDto.getPassword())){
                    // memo 수정
                    blog.update(requestDto);
                    return blog.getId();
                }else{
                    throw new IllegalArgumentException("비번 틀림");
                }
            } else {
                throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
            }
        }

        @DeleteMapping("/blogs/{id}")
        public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
            // 해당 메모가 DB에 존재하는지 확인
            if(blogList.containsKey(id)) {
                Blog blog = blogList.get(id);
                // 해당 메모 삭제하기
                if(blog.getPassword().equals(requestDto.getPassword())){
                    blogList.remove(id);
                    return id;
                }{
                    throw new IllegalArgumentException("비번 틀림");
                }

            } else {
                throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
            }



    }

}