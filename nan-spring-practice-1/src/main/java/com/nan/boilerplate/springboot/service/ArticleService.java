package com.nan.boilerplate.springboot.service;

import com.nan.boilerplate.springboot.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> getAllArticles();

    Optional<Article> getArticleById(Long id);

    Article create(Article article);

    void deleteArticle(Long id);

}
