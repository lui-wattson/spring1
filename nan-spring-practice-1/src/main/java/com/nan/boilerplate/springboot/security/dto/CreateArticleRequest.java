package com.nan.boilerplate.springboot.security.dto;

import com.nan.boilerplate.springboot.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter // 웬만하면 쓰지말기
public class CreateArticleRequest {
    private String title;
    private String content;
    private String author;

    public Article toEntity() { // DTO -> 엔티티 으로 변환
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    // 엔티티 = 모델

}
