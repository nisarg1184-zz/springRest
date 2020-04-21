package io.github.nisarg1184.spring.rest.client;

import io.github.nisarg1184.spring.rest.model.Person;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonClient {
    private static final String PERSON_API_URL = "http://localhost:8080/api/v1/person/";

    private final RestTemplate restTemplate;

    public PersonClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<Person[]> fetchPeople() {
        return this.restTemplate.getForEntity(PERSON_API_URL, Person[].class);
    }

    public List<Person> getPersonList() {
        return Arrays.asList(fetchPeople().getBody());
    }
}
