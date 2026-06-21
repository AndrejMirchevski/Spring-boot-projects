package com.example.SocialMediaCommentingAPI.exception;

//used for 404 error code
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
