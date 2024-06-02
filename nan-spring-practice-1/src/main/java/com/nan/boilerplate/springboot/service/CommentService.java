package com.nan.boilerplate.springboot.service;

import com.nan.boilerplate.springboot.model.Book;
import com.nan.boilerplate.springboot.model.Comment;
import com.nan.boilerplate.springboot.security.dto.AddCommentRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAllComments();

    Optional<Comment> getCommentById(Long id);

    Comment saveComment(Long id, AddCommentRequest request);

    Comment updateComment(Long id, AddCommentRequest request);

    void deleteComment(Long id);
}
