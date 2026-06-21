package com.example.SocialMediaCommentingAPI.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    @Value("${api.key}")
    private String apiKey;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        String providedKey =
                request.getHeader("X-API-Key");

        if (apiKey.equals(providedKey)) {
            return true;
        }

        response.sendError(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Invalid or missing API Key"
        );

        return false;
    }

}
