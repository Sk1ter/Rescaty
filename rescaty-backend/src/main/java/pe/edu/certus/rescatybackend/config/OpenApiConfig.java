package pe.edu.certus.rescatybackend.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI rescatyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rescaty API")
                        .description("API de eventos, mascotas y adopciones para la plataforma Rescaty")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Equipo Rescaty")
                                .email("soporte@rescaty.com")
                        )
                );
    }
}
