package com.nikki.directory.service;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DirectoryServiceTest {
    @InjectMocks
    private DirectoryService directoryService;

    @Mock
    private DirectoryRepository directoryRepository;

    @Test
    public void shouldGetContactById(){
        Contact contact = Contact.builder().id("1")
                .name("Test")
                .phoneNumber("9789999373")
                .active(Boolean.TRUE)
                .build();
        when(directoryRepository.findById("1")).thenReturn(Mono.just(contact));
        Mono<Contact> contactMono = directoryService.getContactById("1");
        StepVerifier
                .create(contactMono)
                .consumeNextWith(contact1 -> {
                    Assertions.assertEquals(contact1.getPhoneNumber(), "9789999373");
                })
                .verifyComplete();
    }

    @Test
    public void shouldCreateContact(){
        Contact contact = Contact.builder().id("1")
                .name("Test")
                .phoneNumber("9789999373")
                .active(Boolean.TRUE)
                .build();
        when(directoryRepository.save(contact)).thenReturn(Mono.just(contact));
        Mono<Contact> contactMono = directoryService.createContact(contact);
        StepVerifier
                .create(contactMono)
                .consumeNextWith(contact1 -> {
                    Assertions.assertEquals(contact1.getPhoneNumber(), "9789999373");
                })
                .verifyComplete();
    }


    /*
    @Test
    public void shouldGetAllContacts(){
        List<Contact> contactList = Arrays.asList(  Contact.builder().id("1")
                .name("Test")
                .phoneNumber("9789999373")
                .active(Boolean.TRUE)
                .build(),
                Contact.builder().id("1")
                .name("Test")
                .phoneNumber("9789999374")
                .active(Boolean.TRUE)
                .build());

        Contact contact = Contact.builder().id("1")
                .name("Test")
                .phoneNumber("9789999373")
                .active(Boolean.TRUE)
                .build();

        Flux<Contact> contactFlux = Flux.just(Contact.builder().id("1")
                        .name("TestUser1")
                        .phoneNumber("9789999373")
                        .active(Boolean.TRUE)
                        .build(),
                Contact.builder().id("2")
                        .name("TestUser2")
                        .phoneNumber("9789999374")
                        .active(Boolean.TRUE)
                        .build());

        when(directoryRepository.findAll()).thenReturn(contactFlux);
        Flux<Contact> contactFlux2 = directoryService.getAllContacts();
        StepVerifier
                .create(contactFlux2)
                .consumeNextWith(contact1 -> {
                    Assertions.assertEquals(contact1.getPhoneNumber(), "9789999373");
                })
                .verifyComplete();
    }*/
}
