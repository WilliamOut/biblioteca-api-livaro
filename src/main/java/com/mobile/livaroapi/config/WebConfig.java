package com.mobile.livaroapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a configuração a todos os endpoints
                .allowedOrigins("*") // Permite acesso de qualquer origem (IMPORTANTE para Flutter/Mobile)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Permite todos os métodos HTTP
                .allowedHeaders("*") // Permite todos os headers
                .allowCredentials(false); // Não estamos usando cookies/sessões complexas agora
    }
}
