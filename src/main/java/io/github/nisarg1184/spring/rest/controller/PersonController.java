package io.github.nisarg1184.spring.rest.controller;

import io.github.nisarg1184.spring.rest.client.PersonClient;
import io.github.nisarg1184.spring.rest.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    private final PersonClient personClient;

    public PersonController(PersonClient personClient) {
        this.personClient = personClient;
    }

    @GetMapping("/person")
    @ResponseBody
    public Person[] fetchPeople() {
        return personClient.fetchPeople().getBody();
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("personList", personClient.getPersonList());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("personList", personClient.getPersonList());
        return "admin";
    }

}
