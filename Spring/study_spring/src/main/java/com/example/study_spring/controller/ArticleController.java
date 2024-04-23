package com.example.study_spring.controller;

import com.example.study_spring.dto.ArticleForm;
import com.example.study_spring.entity.Article;
import com.example.study_spring.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return"articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info("DTO 잘 넘어옴"+" "+form.toString());
        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info("DTO => 엔티티 변환성공"+" "+article.toString());
        //2. 리파지터리로 엔티티를 DB에 저장
        Article sa = articleRepository.save(article);
        log.info("리파지터리 정상동작 엔티티 db저장 성공"+" "+sa.toString());
        return"";
    }

    @GetMapping("/article/{id}") //데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){
        log.info("id ="+id);
        //1. id를 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article",articleEntity);
        //3. 조회한 데이터를 사용자에게 보여 주기 위한 뷰 페이지 만들고 변환하기
        return"articles/show";
    }

}
