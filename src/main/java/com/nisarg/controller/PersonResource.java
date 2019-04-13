package com.nisarg.controller;

import com.nisarg.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("person/{id}")
    public Person getPersonById(@PathVariable Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(!optionalPerson.isPresent()) {
            throw new PersonNotFoundException(id);
        }
        return optionalPerson.get();
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPerson.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable long id) {

        Optional<Person> personOptional = personRepository.findById(id);

        if (!personOptional.isPresent())
            return ResponseEntity.notFound().build();

        person.setId(id);

        personRepository.save(person);

        return ResponseEntity.noContent().build();
    }
}

