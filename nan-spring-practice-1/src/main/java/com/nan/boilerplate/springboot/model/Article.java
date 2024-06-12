package com.nan.boilerplate.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter // 모든필드에 대한 접근자 메서드 생성
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자 생성
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
//    @JsonIgnore
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="author",nullable = false)
    private String author;

    @Builder
    public Article(String author,String title,String content,String comment){
        this.author=author;
        this.title=title;
        this.content=content;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
    @CreatedDate//엔티티가 생성될 때 생성 시간 저장
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate//엔티티가 수정될 때 수정 시간 저장
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    // cascade = CascadeType.REMOVE -> 게시글 삭제 시 관련 댓글 같이 삭제
    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;
}