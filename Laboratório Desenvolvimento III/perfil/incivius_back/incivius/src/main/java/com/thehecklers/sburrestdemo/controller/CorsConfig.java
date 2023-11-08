package com.thehecklers.sburrestdemo.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/perfis") // Especifique a rota que você deseja habilitar o CORS
            .allowedOrigins("http://localhost:8070", "http://127.0.0.1:5500") // Permita origens específicas
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
            .allowedHeaders("*"); // Headers permitidos
    }
}
