package com.example.SocialMediaCommentingAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

//JSON erros
@Getter
@AllArgsConstructor
public class ErrorResponse{
    private int status;
    private String message;
}
