package com.nikki.directory;


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
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class DirectoryServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(DirectoryServiceApplication.class, args);
	}


	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("employee-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nikki.directory.resource"))
				.paths(PathSelectors.any())
				.build();
	}



	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Directory API")
				.description("Spring Rest API reference")
				.licenseUrl("bharathy.poovalingam@gmail.com")
				.version("1.0")
				.build();
	}

}
