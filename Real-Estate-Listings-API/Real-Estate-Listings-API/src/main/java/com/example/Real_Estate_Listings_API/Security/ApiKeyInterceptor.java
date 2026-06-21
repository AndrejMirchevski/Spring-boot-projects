package com.example.Real_Estate_Listings_API.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-API-Key";
    private static final String VALID_API_KEY = "demo-key-2026";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestApiKey = request.getHeader(API_KEY_HEADER);

        if (VALID_API_KEY.equals(requestApiKey)) {
            return true; // Key matches, let the request proceed to your controller!
        }

        // Key is missing or invalid -> block the request and return 401 Unauthorized
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"Invalid or missing X-API-Key header.\"}");
        return false;
    }
}