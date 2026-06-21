package com.example.SocialMediaCommentingAPI.exception;

//user for api key error
public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message){
        super(message);
    }
}
