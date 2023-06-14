package com.nikki.directory.service;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DirectoryService {

    private DirectoryRepository directoryRepository;

    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }


    public Flux<Contact> getAllContacts() {
        return  directoryRepository.findAll();
    }

    public Mono<Contact> getContactById( String id) {
        return directoryRepository.findById(id);
    }


    public Mono<Contact> createContact(@RequestBody Contact contact) {
        return  directoryRepository.save(contact);
    }



    public Mono<Contact> updateContact(@RequestBody Contact contact) {
        return this.directoryRepository.findById(contact.getId())
                .map(c -> contact)
                .flatMap(this.directoryRepository::save);
    }

}
