package com.example.demo.api;


import com.example.demo.entity.Person;
import com.example.demo.dto.PersonDTO;
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
    public List<Person> retrieveAllPerson(){
        List<Person> personToReturn = personService.retrieveAllPeople();
        String surname = personToReturn.get(0).getSurname();
        return personToReturn;
    }


    @GetMapping(value="/job")
    public String retrieveJobByPerson(@RequestBody PersonDTO person){
        // TODO: sistemare null safe
        return personService.retrieveJobByPerson(person.getName(), person.getSurname());
    }
}
