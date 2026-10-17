package com.example.Projeto.LoginJWT.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API - Cardoso Serviços Automotivos",
                description = "Documentação completa dos endpoints de gerenciamento de Ordens de Serviço (OS), mecânicos, clientes, veículos e checklists da oficina.",
                contact = @Contact(
                        name = "Nexus",
                        email = "grupo3-extencao@sptech.school"
                ),
                version = "1.0.0"
        )
)
@SecurityScheme(
        name = "Bearer", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT"
)
public class OpenApiConfig {

}
