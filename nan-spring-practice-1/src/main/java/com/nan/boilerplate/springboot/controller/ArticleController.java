package com.nan.boilerplate.springboot.controller;

import com.nan.boilerplate.springboot.model.Article;
import com.nan.boilerplate.springboot.security.dto.CreateArticleRequest;
import com.nan.boilerplate.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {this.articleService = articleService;}

    // 모든 게시글 read
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    // 특정 게시글 read
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticleById(id);
        return article.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    // 게시글 작성
    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestBody CreateArticleRequest request) {
        Article createArticle = articleService.create(request.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createArticle);
    }
    
    // 게시글 업데이트
    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Optional<Article> existingArticleOptional = articleService.getArticleById(id);

        if (existingArticleOptional.isPresent()) {
            Article exisitingArticle = existingArticleOptional.get();
            exisitingArticle.setTitle(updatedArticle.getTitle());
            exisitingArticle.setContent(updatedArticle.getContent());
            exisitingArticle.setAuthor(updatedArticle.getAuthor());

            Article savedArticle = articleService.create(exisitingArticle);
            return ResponseEntity.ok(savedArticle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 게시글 삭제
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
