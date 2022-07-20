package com.murtiart.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

	private ApiInfo getInfo() {
		return new ApiInfo("Murti Art","This is project devlop for murti", "1.0", "Term ans service",
				new Contact("Kirti", "https://google.com","kirti@gmail.com"), "Licnsens Of API", "Api licsns url",Collections.emptyList());
	}
}
