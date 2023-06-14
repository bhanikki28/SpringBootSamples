package com.nikki.directory.resource;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
@Tag(name = "Customer", description = "Customer API")
public class DirectoryResource {

    private DirectoryRepository directoryRepository;

    public DirectoryResource(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @GetMapping("/contacts")
    public Flux<Contact> getAll() {
        return  directoryRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Mono<Contact> getContactById(@PathVariable("id") String id) {
        return directoryRepository.findById(id);
    }




}