package com.nan.boilerplate.springboot.service.Impl;

import com.nan.boilerplate.springboot.model.Article;
import com.nan.boilerplate.springboot.repository.ArticleRepository;
import com.nan.boilerplate.springboot.repository.CommentRepository;
import com.nan.boilerplate.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() { return articleRepository.findAll(); }

    @Override
    public Optional<Article> getArticleById(Long id) { return articleRepository.findById(id); }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {articleRepository.deleteById(id);}


}
