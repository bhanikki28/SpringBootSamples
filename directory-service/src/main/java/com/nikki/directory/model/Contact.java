package com.nikki.directory.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Contact {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private Boolean active;
}
