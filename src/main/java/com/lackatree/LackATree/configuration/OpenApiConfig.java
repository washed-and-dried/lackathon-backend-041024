package com.lackatree.LackATree.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Lack A Tree",
                description = "APIS for Lack A Tree"
        )
)
public class OpenApiConfig {

}
