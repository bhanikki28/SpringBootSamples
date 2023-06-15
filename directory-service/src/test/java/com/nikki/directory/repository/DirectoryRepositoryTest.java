package com.nikki.directory.repository;

import com.nikki.directory.model.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class DirectoryRepositoryTest {

    @Autowired
    private DirectoryRepository directoryRepository;

    /*
    @Test
    public void shouldSaveContact() {

        Contact contact = new Contact("1", "Test User", "97899999373", Boolean.TRUE);

        Publisher<Contact> setup = directoryRepository.deleteAll().thenMany(directoryRepository.save(contact));
        StepVerifier
                .create(setup)
                .expectNextCount(1)
                .verifyComplete();
    }*/


}
