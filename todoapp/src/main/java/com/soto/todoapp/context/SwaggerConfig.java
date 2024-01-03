package com.soto.todoapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Configuración principal de Swagger para la documentación de la API
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // Selecciona el paquete base donde se encuentran los controladores que deben ser documentados
                .apis(RequestHandlerSelectors.basePackage("com.soto.todoapp.controller"))
                // Incluye todos los paths
                .paths(PathSelectors.any())
                .build()
                // Configura la información general de la API
                .apiInfo(apiInfo());
    }

    // Configura la información general de la API para la documentación Swagger
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Todo API",                    // Título de la API
                "La API REST de ToDo App.",    // Descripción de la API
                "v1",                          // Versión de la API
                "Terms of service",             // Términos de servicio
                new Contact(
                        "Soto Tech",               // Nombre del contacto
                        "www.example.com",         // URL del contacto
                        "carlossotto574@gmail.com" // Correo electrónico del contacto
                ),
                "License of API",               // Licencia de la API
                "API license URL",              // URL de la licencia
                Collections.emptyList()
        );
    }
}
