package com.example.SocialMediaCommentingAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateReplyRequest {

    @NotBlank(message = "Auhtor name can not be left empty")
    private String authorName;

    @NotBlank(message = "message body can not be left empty")
    @Size(max = 10, message = "reply body can not be more then 10 cahracters")
    private String body;

    @NotNull(message = "missing post id ")
    private Long postId;

    public CreateReplyRequest(){}

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
