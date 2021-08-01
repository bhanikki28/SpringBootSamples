package com.nikki.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.nikki")
@EnableAutoConfiguration
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("employee-api")
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.nikki.demo.controller"))
					.paths(PathSelectors.any())
					.build();
	}
	
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Employee API")
				.description("Spring Rest API reference")
				.licenseUrl("bharathy.poovalingam@gmail.com")
				.version("1.0")
				.build();
	}
	

}
