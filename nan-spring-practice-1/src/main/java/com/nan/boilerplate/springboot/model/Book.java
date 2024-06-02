package com.nan.boilerplate.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블 정의할 때 테이블 위에 붙여주는 어노테이션 -> JPA
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 만들어주는 어노테이션
@AllArgsConstructor // 생성자 만들어주는 
public class Book {
    @Id // 아이디 자동 1부터 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;

}