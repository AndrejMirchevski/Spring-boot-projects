package com.example.MovieReviewsAPI.repository;

import com.example.MovieReviewsAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
