package com.example.first_project.controller;

import com.example.first_project.dto.ArticleForm;
import com.example.first_project.entity.Article;
import com.example.first_project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j //로깅을위한 어노테이션
@Controller
public class ArticlesController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticle(){
        System.out.println("new 들어옴");
        return"articles/new";

    }
    @PostMapping("/articles/create")
    public String articleCreate(ArticleForm arti){
        System.out.println("create 들어옴");
       // System.out.println(arti.toString());
        //1. DTO를 엔티티로 변환
            Article article = arti.toEntity();
            log.info(arti.toString());
       // System.out.println("DTO가 엔티티에 잘 저장됨\n"+article.toString());
        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
       // System.out.println("article이 DB에 잘 저장됨\n"+saved.toString());
        return"";
    }
}
