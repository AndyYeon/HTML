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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        return"redirect:/articles/" +sa.getId();
    }

    @GetMapping("/articles/{id}") //데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){
        log.info("id ="+id);
        //1. id를 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article",articleEntity);
        //3. 조회한 데이터를 사용자에게 보여 주기 위한 뷰 페이지 만들고 변환하기
        return"articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1.모든 데이터 가져오기
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("articleList",articleEntityList);
        //3. 뷰 페이지 설정하기
        return"articles/index";
    }

    //Update 수정
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 찾아오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //모델에 엔티티 등록
        model.addAttribute("article",articleEntity);
        //뷰페이지 설정
        return "/articles/edit";
    }
    @PostMapping("/articles/update")
    public String postUpdate(ArticleForm form){
        //1. DTO 엔티티 변환
        Article article = form.toEntity();
        //2. 엔티티 db에 저장
        //2-1 DB에서 기존데이터 꺼내오기
        Article target = articleRepository.findById(article.getId()).orElse(null);
        //2-2 기존 데이터 값을 갱신
        if (target != null){
            articleRepository.save(article); //엔티티를 DB에 저장(갱신)
        }
        //3. 수정결과 결과 페이지로 리다이렉트
        return "redirect:/articles/" + article.getId();
    }

    //삭제 Delete
    @GetMapping("/articles/{id}/delete")
    public String getDelete(@PathVariable Long id, RedirectAttributes rttr){
        //1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        //2. 대상 엔티티 삭제하기
        if(target!=null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제되었습니다");
        }
        //3. 결과 페이지로 리다이렉트
        return"redirect:/articles";
    }

}
