package com.example.demo.service;

import com.example.demo.dao.PersonRepositoryAccessDb;
import com.example.demo.model.Jobs;
import com.example.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    private final PersonRepositoryAccessDb personRepository;

    @Autowired
    public PersonService(PersonRepositoryAccessDb personRepository){
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }


    public Jobs getJobByPerson(String name, String surname){
        return personRepository.findJobByPersona(name, surname);
    }

}
