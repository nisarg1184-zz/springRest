package io.github.nisarg1184.spring.rest.controller;

import io.github.nisarg1184.spring.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
