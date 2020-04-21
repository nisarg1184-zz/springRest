package io.github.nisarg1184.spring.rest.controller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PersonNotFoundException extends RuntimeException {
    private Long id;

    public PersonNotFoundException(Long id) {
        super(String.format(" not found : '%s'",id));
        this.id=id;

    }

    public Long getId() {
        return this.id;
    }
}
