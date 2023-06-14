package com.nikki.directory.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Getter
@Setter
public class Contact {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private Boolean active;
}
