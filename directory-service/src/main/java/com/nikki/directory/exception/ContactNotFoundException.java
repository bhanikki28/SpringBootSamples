package com.nikki.directory.exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException() {
        super();
    }
    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ContactNotFoundException(String message) {
        super(message);
    }
    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }

}
