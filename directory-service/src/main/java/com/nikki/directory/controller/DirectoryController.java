package com.nikki.directory.controller;

import com.nikki.directory.exception.ContactNotFoundException;
import com.nikki.directory.model.Contact;
import com.nikki.directory.service.DirectoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@RestController
@RequestMapping("/api/v1")
@Api(value="Directory Management", protocols = "http")
@Slf4j
public class DirectoryController {

    private DirectoryService directoryService;

    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("/contacts")
    @ApiOperation(value = "To get the list of contacts", response = Contact.class,
            code = 200)
    public Flux<Contact> getAll() {
        log.info("Retrieving all contacts");
        return  directoryService.getAllContacts();
    }

    @PostMapping("/contacts")
    @ApiOperation(value = "To create an contact by passing the id,name,phone and email_id", response = Contact.class,
            code = 200)
    public Mono<Contact> createContact(@RequestBody Contact contact) {
        log.info("Creating new contact for {}", contact.getName());
        return  directoryService.createContact(contact);
    }


    @GetMapping("/contacts/{id}")
    @ApiOperation(value = "To access particular contact by passing the contact id", response = Contact.class,
            code = 200)
    public Mono<Contact> getContactById(@PathVariable("id") String id) {
        log.info("Retrieving contact for {}", id);

        try {
            return directoryService.getContactById(id);
        }
        catch (Exception e){
            throw new ContactNotFoundException("Contact not present in DB");
        }
    }

    @PutMapping("/contacts")
    @ApiOperation(value = "To activate particular contact by passing the contact ", response = Contact.class,
            code = 200)
    public Mono<Contact> updateContact(@RequestBody Contact contact) {
        log.info("Updating contact for {}", contact.getName());
        return directoryService.updateContact(contact);
    }



}