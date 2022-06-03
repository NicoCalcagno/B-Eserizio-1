package com.example.demo.api;

import com.example.demo.model.Jobs;
import com.example.demo.model.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person")
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping(value="/add")
    public void addPerson(@RequestBody PersonDTO person){
        Person personPersistent = new Person();
        personPersistent.setName(person.getName());
        personPersistent.setSurname(person.getSurname());
        personPersistent.setJob(person.getJob());
        personService.addPerson(personPersistent);
    }

    @GetMapping(value="/all")
    public List<Person> getAllPerson(){
        return personService.getAllPeople();
    }


    @GetMapping(value="/job")
    public Jobs getJobByPerson(@RequestBody PersonDTO person){
        return personService.getJobByPerson(person.getName(), person.getSurname());
    }
}
