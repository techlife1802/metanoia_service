package com.metanoia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply to all endpoints
                .allowedOrigins("*")  // Adjust as needed for your front-end domain
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Allowed methods
                .allowedHeaders("Authorization", "Content-Type")  // Allow Authorization and Content-Type headers in requests
                .exposedHeaders("Authorization")  // Expose the Authorization header in responses
                .allowCredentials(false);  // Allow credentials (if needed)
    }
}

