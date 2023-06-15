package com.nikki.directory.controller;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import com.nikki.directory.service.DirectoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = DirectoryController.class)
@Import(DirectoryService.class)
public class DirectoryControllerTest {

    @MockBean
    DirectoryRepository directoryRepository;

    @Autowired
    private WebTestClient webTestClient;


	@Test
	public void addContact() {

		Contact contact = Contact.builder().id("1")
				.name("Test")
				.phoneNumber("123")
				.active(Boolean.TRUE).build();

        Mockito.when(directoryRepository.save(contact)).thenReturn(Mono.just(contact));

		webTestClient.post()
                .uri("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(contact), Contact.class)
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}

	@Test
	public void getContactById() {

		Contact contact = Contact.builder().id("1")
				.name("Test")
				.phoneNumber("123")
				.active(Boolean.TRUE).build();

		Mono<Contact> contactMono = Mono.just(contact);

		Mockito.when(directoryRepository.findById("1")).thenReturn(Mono.just(contact));

		webTestClient.get()
				.uri("/api/v1/contacts/1")
				.exchange()
				.expectStatus()
				.is2xxSuccessful()
				.expectBody(Contact.class);
	}

	@Test
	public void getAllContacts() {

		;

		Flux<Contact> contactFlux = Flux.just(Contact.builder().id("1")
				.name("TestUser1")
				.phoneNumber("123")
				.active(Boolean.TRUE).build(),
				Contact.builder().id("1")
						.name("TestUser2")
						.phoneNumber("1234")
						.active(Boolean.TRUE).build());

		Mockito.when(directoryRepository.findAll()).thenReturn(contactFlux);

		webTestClient.get()
				.uri("/api/v1/contacts")
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}
}
