package org.sid.reservationservice.config;

import feign.Request;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods(Request.HttpMethod.GET.name(),Request.HttpMethod.POST.name(),Request.HttpMethod.PUT.name(),Request.HttpMethod.DELETE.name())
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}