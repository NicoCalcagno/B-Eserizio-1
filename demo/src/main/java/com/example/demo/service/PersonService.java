package com.example.demo.service;

import com.example.demo.dao.PersonRepositoryAccessDb;
import com.example.demo.entity.Jobs;
import com.example.demo.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Person> retrieveAllPeople(){
        return personRepository.findAll();
    }


    public String retrieveJobByPerson(String name, String surname){
        return personRepository.findJobByPersona(name, surname)
                .map(Jobs::getJobName)
                .orElse("job not found");
    }


    public String retrieveNamesByChar(String input, int ind){
        char c = Character.toLowerCase(input.charAt(ind));
        String allNames = "";
        try {
            if(input.length() < 2 && Character.isLetter(input.charAt(0))
                    && !input.substring(0, 1).matches("[^A-Za-z0-9 ]")
                    && input.charAt(0) != 0 && input.charAt(0) != ' ') {

                allNames = personRepository.findAll()
                        .stream()
                        .map(Person::getName)
                        .filter(name -> Character.toLowerCase(name.charAt(0)) == c)
                        .collect(Collectors.joining(", "));

                if(allNames.isEmpty()) {
                    allNames = "Nessun record trovato";
                }

            }else {
                allNames = "Error, input non valido";
            }
        } catch(IndexOutOfBoundsException siobe){
            allNames = "Error, input non valido " + siobe.getMessage();
        }
        return allNames;
    }
}
