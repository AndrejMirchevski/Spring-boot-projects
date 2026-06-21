package com.example.SocialMediaCommentingAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCommentRequest {

    @NotBlank(message = "Author name can not be left empty")
    private String authorName;

    @NotBlank(message = "comment body can not be left empty")
    @Size(max = 10 ,message = "comment can not excide more then 10 characters")
    private String body;

    public CreateCommentRequest() {
    }

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
}
