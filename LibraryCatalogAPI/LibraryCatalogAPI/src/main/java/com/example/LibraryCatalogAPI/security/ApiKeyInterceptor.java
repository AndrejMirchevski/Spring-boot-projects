package com.example.LibraryCatalogAPI.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class ApiKeyInterceptor implements HandlerInterceptor {

    @Value("${api.key}")
    private String validApiKey;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        String providedKey =
                request.getHeader("X-API-Key");

        if(validApiKey.equals(providedKey)){
            return true;
        }

        response.sendError(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Invalid API Key"
        );

        return false;
    }
}