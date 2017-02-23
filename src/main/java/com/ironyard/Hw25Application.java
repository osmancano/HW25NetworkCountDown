package com.ironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class Hw25Application {

	public static void main(String[] args){
		SpringApplication.run(Hw25Application.class, args);
		System.out.println("Welcome to my application");
	}

	@Bean
	public Docket movieApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("movie-api")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/rest/*.*"))
				.build();
				/*.globalOperationParameters(
						newArrayList(new ParameterBuilder()
								.name("x-authorization-key")
								.description("API Authorization Key")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(true)
								.build()));
				*/
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("This is our API")
				.description("Do all Movie stuff here!!!")
				.termsOfServiceUrl("http://theironyard.com")
				.contact("Jason Skipper")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
				.version("2.1")
				.build();
	}

}
