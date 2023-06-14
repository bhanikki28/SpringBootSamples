package com.nikki.directory.controller;

import com.nikki.directory.model.Contact;
import com.nikki.directory.service.DirectoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@RestController
@RequestMapping("/api/v1")
@Api(value="Directory Management", protocols = "http")
public class DirectoryController {

    private DirectoryService directoryService;

    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("/contacts")
    @ApiOperation(value = "To get the list of contacts", response = Contact.class,
            code = 200)
    public Flux<Contact> getAll() {
        return  directoryService.getAllContacts();
    }

    @PostMapping("/contacts")
    @ApiOperation(value = "To create an contact by passing the id,name,phone and email_id", response = Contact.class,
            code = 200)
    public Mono<Contact> createContact(@RequestBody Contact contact) {
        return  directoryService.createContact(contact);
    }


    @GetMapping("/contacts/{id}")
    @ApiOperation(value = "To access particular contact by passing the contact id", response = Contact.class,
            code = 200)
    public Mono<Contact> getContactById(@PathVariable("id") String id) {
        return directoryService.getContactById(id);
    }




}