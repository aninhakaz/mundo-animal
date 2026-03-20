package com.senai.infob.mundoanimal.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Mundo Animal",
        version = "1.0",
        description = "Aplicativo Mobile Mundo Animal"
    )
)
public class Swagger {
}