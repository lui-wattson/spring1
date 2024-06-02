package com.nan.boilerplate.springboot.repository;

import com.nan.boilerplate.springboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment,Long> {

}
