package com.example.SocialMediaCommentingAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyResponce {
    private Long id;
    private String author,body;
    private Integer likes;
    private LocalDateTime createdAt;
}
