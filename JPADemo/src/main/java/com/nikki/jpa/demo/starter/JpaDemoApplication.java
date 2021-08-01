package com.nikki.jpa.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nikki")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.nikki.jpa.demo.repository")
@EntityScan(basePackages = "com.nikki.jpa.demo.entity")
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

}
