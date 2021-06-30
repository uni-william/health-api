package com.system.health.api.core;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.system.health.api.core.model.PageableModelOpenApi;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.system.health"))
				.paths(PathSelectors.any()).build()
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Sis Health",
				"API Sis Health",
				"API CMS 1.0", "Terms of service",
				new Contact("WCG Systems ", "Contatos William", "william.desenv@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
	}	

}
