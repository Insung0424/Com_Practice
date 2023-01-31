package com.JIS.upgradeProject.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SwaggerConfig.java
@OpenAPIDefinition(
        info = @Info(title = "TestController API 명세서",
                description = "Spring boot, MySQL, JPA를 사용한 test프로젝트 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/content/**"};

        return GroupedOpenApi.builder()
                .group("TestController API v1")
                .pathsToMatch(paths)
                .build();
    }
}
