package com.nikki.directory;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DirectoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner addContacts(DirectoryRepository directoryRepository) {
		return args -> {
			directoryRepository.deleteAll()
					.subscribe(null, null, () -> {
						Stream.of(new Contact(UUID.randomUUID().toString(),"Bharathy", new String[]{"0428147222", "0428147223"},Boolean.TRUE),
								new Contact(UUID.randomUUID().toString(),"Sachin", new String[]{"0429147333", "0429147334"},Boolean.TRUE),
								new Contact(UUID.randomUUID().toString(),"Dhoni", new String[]{"0428147323", "0428147324"},Boolean.TRUE))
								.forEach(contact -> directoryRepository.save(contact).subscribe(contact1 -> System.out.println(contact)));
					});
		};
	}

}
