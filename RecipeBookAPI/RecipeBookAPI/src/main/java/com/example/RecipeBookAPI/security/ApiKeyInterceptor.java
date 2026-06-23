package com.example.RecipeBookAPI.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    @Value("${api.key}")
    private String validApiKey;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception{
        String providedKey = request.getHeader("X-API-Key");
        if (validApiKey.equals(providedKey)){
            return true;
        }
        response.sendError(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Invalid or missing API key"
        );
        return false;
    }
}
