package com.nikki.directory;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import org.springframework.boot.CommandLineRunner;
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

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class DirectoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectoryServiceApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner addContacts(DirectoryRepository directoryRepository) {
		return args -> {
			directoryRepository.deleteAll()
					.subscribe(null, null, () -> {
						Stream.of(new Contact(UUID.randomUUID().toString(),"Bharathy", "0428147222",Boolean.TRUE),
								new Contact(UUID.randomUUID().toString(),"Sachin", "0428147223",Boolean.TRUE),
								new Contact(UUID.randomUUID().toString(),"Dhoni", "0428147224",Boolean.TRUE))
								.forEach(contact -> directoryRepository.save(contact).subscribe(contact1 -> System.out.println(contact)));
					});
		};
	}*/

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
