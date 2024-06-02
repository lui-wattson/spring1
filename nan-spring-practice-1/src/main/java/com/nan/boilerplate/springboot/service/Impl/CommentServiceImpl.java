package com.nan.boilerplate.springboot.service.Impl;

import com.nan.boilerplate.springboot.model.Article;
import com.nan.boilerplate.springboot.model.Book;
import com.nan.boilerplate.springboot.model.Comment;
import com.nan.boilerplate.springboot.repository.ArticleRepository;
import com.nan.boilerplate.springboot.repository.BookRepository;
import com.nan.boilerplate.springboot.repository.CommentRepository;
import com.nan.boilerplate.springboot.security.dto.AddCommentRequest;
import com.nan.boilerplate.springboot.service.ArticleService;
import com.nan.boilerplate.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Comment> getAllComments() { return commentRepository.findAll(); }

    @Override
    public Optional<Comment> getCommentById(Long id) { return commentRepository.findById(id); }

    @Override
    public Comment saveComment(Long id, AddCommentRequest request) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            request.setArticle(id);
            return commentRepository.save(request.toEntity());
        } else {
            System.err.println("Article with id " + id + " not found.");
            return null;
        }
    }

    @Override
    @Transactional
    public Comment updateComment(Long id, AddCommentRequest request) {
        Comment comment = commentRepository.getReferenceById(id);
        comment.update(request.getComment());
        return comment;
    }

    @Override
    public void deleteComment(Long id) {commentRepository.deleteById(id);}
}
