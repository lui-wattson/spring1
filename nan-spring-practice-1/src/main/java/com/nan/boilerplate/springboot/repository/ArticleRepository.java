package com.nan.boilerplate.springboot.repository;

import com.nan.boilerplate.springboot.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
