package com.github.joanersoncosta.apipedido.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocOpenApiConfig {

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(
					new Info()
						.title("Rest API - Pedidos")
						.description("API para realizar pedidos")
						.license(new License().name("Apache 2.0").url("http://www.apache.org/license/LICENSE-2.0"))
						.contact(new Contact().name("Joanerson Costa").email("joanersonc31@gmai.com"))
				);
	}
}
