package com.example.demo.api;

import com.example.demo.model.Jobs;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v2")
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping(value="/add")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping(value="/all")
    public List<Person> getAllPerson(){
        return personService.getAllPeople();
    }


    @GetMapping(value="/job")
    public Jobs getJobByPerson(@RequestBody Person person){
        return personService.getJobByPerson(person.getName(), person.getSurname());
    }
}
