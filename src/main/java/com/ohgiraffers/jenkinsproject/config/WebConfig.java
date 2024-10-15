package com.ohgiraffers.jenkinsproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173")

                /* Ingress 적용 이전 프론트 워커노드 포트에 대한 CORS 처리*/
//                .allowedOrigins("http://localhost:30000")

                /* Ingress 적용 이후 CORS 불필요로 인한 경로 제거 (하지만 다른 클라이언트에 대해 적용해야 할수도 있으니 WebConfig 파일은 그냥 두기) */
                .allowedOrigins("")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
