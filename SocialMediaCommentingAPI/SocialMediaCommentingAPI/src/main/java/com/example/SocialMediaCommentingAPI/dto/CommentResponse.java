package com.example.SocialMediaCommentingAPI.dto;

import com.example.SocialMediaCommentingAPI.entity.Reply;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommentResponse {
    private Long id;
    private String AuthorName,body;
    private Integer likes;
    private boolean hidden;
    private LocalDateTime createdAt;

    private List<Reply> replies;

}
