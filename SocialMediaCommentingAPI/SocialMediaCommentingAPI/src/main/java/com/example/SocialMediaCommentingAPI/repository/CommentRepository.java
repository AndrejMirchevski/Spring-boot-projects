package com.example.SocialMediaCommentingAPI.repository;

import com.example.SocialMediaCommentingAPI.entity.Comment;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByPostIdAndDeletedAtNull(Long postId, Pageable pageable);
}
