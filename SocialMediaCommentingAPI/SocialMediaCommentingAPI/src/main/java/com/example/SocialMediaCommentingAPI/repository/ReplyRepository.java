package com.example.SocialMediaCommentingAPI.repository;

import com.example.SocialMediaCommentingAPI.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
