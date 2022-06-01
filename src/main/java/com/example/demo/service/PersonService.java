package com.example.demo.service;

import com.example.demo.dao.PersonRepositoryAccessDb;
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
        return (List<Person>)personRepository.findAll();
    }

    /*
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

     */

}
