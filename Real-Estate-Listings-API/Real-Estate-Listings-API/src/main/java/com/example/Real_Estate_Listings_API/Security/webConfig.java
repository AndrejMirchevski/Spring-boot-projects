package com.example.Real_Estate_Listings_API.Security;

import com.example.Real_Estate_Listings_API.Security.ApiKeyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    private final ApiKeyInterceptor apiKeyInterceptor;

    public webConfig(ApiKeyInterceptor apiKeyInterceptor) {
        this.apiKeyInterceptor = apiKeyInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Enforces the API key check on every endpoint starting with /api/
        registry.addInterceptor(apiKeyInterceptor)
                .addPathPatterns("/api/**");
    }
}