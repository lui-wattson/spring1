package com.nan.boilerplate.springboot.repository;

import com.nan.boilerplate.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // JPA코드

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String userName);
}
