package com.nikki.directory.repository;

import com.nikki.directory.model.Contact;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DirectoryRepository extends ReactiveMongoRepository<Contact, String> {
        Mono<Contact> findByName(String name);
}
