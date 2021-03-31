package com.cognixia.jump.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * On Postman, do a get request on: http://localhost:8080/v2/api-docs
 * 
 * On Browser, go to URL: http://localhost:8080/swagger-ui.html
 * */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo( apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"User API",
				"Spring Cloud + Spring Cloud 5.0 + Swagger example project",
				"1.0",
				"Free To Use For JUMP Program Educational Purproses",
				new Contact("Foo Bar", "https://google.com", "foobar@email.com"),
				"API Licence",
				"https://google.com",
				Collections.emptyList());
	}
}

