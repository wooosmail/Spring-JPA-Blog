package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    //@Query(value = "Select * from user where username = ?1 and passwd = ?2", nativeQuery = true)
    //User login(String username, String passwd);

    Optional<User> findByUsername(String username);
}