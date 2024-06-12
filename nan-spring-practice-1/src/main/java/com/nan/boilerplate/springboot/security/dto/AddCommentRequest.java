package com.nan.boilerplate.springboot.security.dto;

import com.nan.boilerplate.springboot.model.Article;
import com.nan.boilerplate.springboot.model.Comment;
import com.nan.boilerplate.springboot.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddCommentRequest {
    private Long id;
    private String comment;
    private User userId;
    private Long article;

    public Comment toEntity() { // 생성자를 사용해 객체 생성
        return Comment.builder()
                .comment(comment)
                .userId(userId)
                .article(article)
                .build();
    }
}