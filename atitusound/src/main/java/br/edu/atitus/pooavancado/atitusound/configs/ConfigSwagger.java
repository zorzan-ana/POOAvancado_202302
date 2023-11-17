package br.edu.atitus.pooavancado.atitusound.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	
	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Atitusound")
						.description("Documentação do back-end AtituSound")
						.version("Version 1.0.0")
						.contact(new Contact()
								.name("Ana Gabriela Zorzan")
								.email("anazorzan.dev@gmail.com")));
	}

}
