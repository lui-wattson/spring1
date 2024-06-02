package com.nan.boilerplate.springboot.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
//    private String text;

//    public Comment(String text) {
//        this.text = text;
//    }ss

    @CreatedDate//엔티티가 생성될 때 생성 시간 저장
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate//엔티티가 수정될 때 수정 시간 저장
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
//
//    @ManyToOne
//    @JoinColumn(name = "article_id")
    private Long article;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId; // 작성자

    // 오리진 커멘트
    // 댓글 수정
    public void update(String comment) {
        this.comment = comment;
    }
}

