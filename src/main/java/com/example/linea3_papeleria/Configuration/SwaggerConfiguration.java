package com.example.linea3_papeleria.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Supabase")
                        .version("1.0")
                        .description("Documentación de la API para gestionar BD en Supabase")
                        .contact(new Contact()
                                .name("Andres Guayacan")
                                .email("aguayacan@ucundinamarca.edu.co")));
    }
}