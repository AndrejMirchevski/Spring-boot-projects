package com.example.SocialMediaCommentingAPI.repository;


import com.example.SocialMediaCommentingAPI.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
