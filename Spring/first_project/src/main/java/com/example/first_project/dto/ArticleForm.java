package com.example.first_project.dto;

import com.example.first_project.entity.Article;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ArticleForm {
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(null,title,content); // DTO를 엔티티로 변환하는 작업
    }
}
