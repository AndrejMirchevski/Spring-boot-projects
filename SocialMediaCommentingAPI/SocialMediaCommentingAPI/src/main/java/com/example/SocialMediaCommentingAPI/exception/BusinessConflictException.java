package com.example.SocialMediaCommentingAPI.exception;


//409 exception handler
public class BusinessConflictException extends RuntimeException{
    public  BusinessConflictException(String message){
        super(message);
    }
}
