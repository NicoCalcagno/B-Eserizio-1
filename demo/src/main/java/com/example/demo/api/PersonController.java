package com.example.demo.api;


import com.example.demo.entity.Person;
import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/person")
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody PersonDTO person){
        Person personPersistent = new Person();
        personPersistent.setName(person.getName());
        personPersistent.setSurname(person.getSurname());
        personPersistent.setJob(person.getJob());
        personService.addPerson(personPersistent);
    }

    @GetMapping
    public List<Person> retrieveAllPerson(){
        List<Person> personToReturn = personService.retrieveAllPeople();
        String surname = personToReturn.get(0).getSurname();
        return personToReturn;
    }


    @GetMapping(value="/job")
    public String retrieveJobByPerson(@RequestBody Optional<PersonDTO> person){
        // TODO: sistemare null safe
        return person.map(p -> personService.retrieveJobByPerson(p.getName(), p.getSurname()))
                .orElse("Person not can be null");
    }


    @GetMapping(value="/search")
    public ResponseEntity<String> getNamesByChar(@RequestParam String input, @RequestParam int ind){
        String response = personService.retrieveNamesByChar(input, ind);

        if(response.equals("Error, input non valido")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }else if (response.equals("Nessun record trovato")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }

    }
}
