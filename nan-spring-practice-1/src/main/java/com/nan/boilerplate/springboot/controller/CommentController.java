package com.nan.boilerplate.springboot.controller;

import com.nan.boilerplate.springboot.model.Article;
import com.nan.boilerplate.springboot.model.Book;
import com.nan.boilerplate.springboot.model.Comment;
//import com.nan.boilerplate.springboot.service.CommentService;
import com.nan.boilerplate.springboot.security.dto.AddCommentRequest;
import com.nan.boilerplate.springboot.service.ArticleService;
import com.nan.boilerplate.springboot.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api")
@RestController
public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;

    @Autowired
    public CommentController(CommentService commentService, ArticleService articleService) {
        this.commentService = commentService;
        this.articleService = articleService;
    }

    //댓글 생성
    @PostMapping("/articles/{id}/comments")
    public ResponseEntity<Comment> save(@PathVariable Long id, @RequestBody AddCommentRequest request) {
//        return ResponseEntity.ok(commentService.saveComment(id, request));
        try {
            Comment savedComment = commentService.saveComment(id, request);
            if (savedComment != null) {
                return ResponseEntity.ok(savedComment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // 예외 처리 및 로그 추가
            System.err.println("Error saving comment: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 댓글 읽어오기
    @GetMapping("/articles/{id}/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/articles/{articleId}/comments/{id}")
    public Optional<Comment> getCommentById(@PathVariable long id) {
        return commentService.getCommentById(id);
    }

    // 댓글 수정
    @PutMapping("/articles/{articleId}/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long articleId, @PathVariable Long id, @RequestBody AddCommentRequest updatedComment) {
        Optional<Article> existingArticleOptional = articleService.getArticleById(articleId);
        Optional<Comment> existingCommentOptional = commentService.getCommentById(id);

        if (existingArticleOptional.isPresent() && existingCommentOptional.isPresent()) {
            Comment updated = commentService.updateComment(id, updatedComment);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 댓글 삭제
    @DeleteMapping("/articles/{articleId}/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}


//    //댓글 업데이트
//    @PutMapping({"/articles/{articleId}/comments/{id}"})
//    public ResponseEntity<Long> update(@PathVariable long articleId, @PathVariable Long id
//    , @RequestBody UpdateCommentRequest dto) {
//        commentService.update(articleId, id, dto);
//        return ResponseEntity.ok(id);
//    }


