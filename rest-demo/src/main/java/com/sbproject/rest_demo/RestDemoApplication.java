package com.sbproject.rest_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/cloudvendor/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sbproject.rest_demo"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){

		return new ApiInfo(
				"CLoud Vendor API Application",
				"Cloud Vendor Documentation",
				"1.0",
				"Cloud Vendor Service Terms",
				new Contact("Chayan Chawda", "http://chayanchawda.com",
						"chayanchawda14@gmail.com" ),
				"sbproject License",
				"http://chayanchawda.com",
				Collections.emptyList()
		);
	}

}
