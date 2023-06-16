package com.nikki.directory.config;

import com.nikki.directory.model.Contact;
import com.nikki.directory.repository.DirectoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Stream;

@Component
@Slf4j
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private DirectoryRepository directoryRepository;


    @Override
    public void run(String... args) throws Exception {
        directoryRepository.deleteAll()
                .subscribe(null, null, () -> {
                    Stream.of(new Contact(UUID.randomUUID().toString(),"Bharathy", "0428147222",Boolean.TRUE),
                                    new Contact(UUID.randomUUID().toString(),"Sachin", "0428147223",Boolean.TRUE),
                                    new Contact(UUID.randomUUID().toString(),"Dhoni", "0428147224",Boolean.TRUE))
                            .forEach(contact -> directoryRepository.save(contact).subscribe(contact1 -> System.out.println(contact)));
                });
    }
}
