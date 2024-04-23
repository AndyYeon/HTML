package com.example.study_spring.repository;

import com.example.study_spring.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
