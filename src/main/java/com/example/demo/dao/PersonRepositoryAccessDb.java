package com.example.demo.dao;

import com.example.demo.model.Jobs;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

public interface PersonRepositoryAccessDb extends JpaRepository<Person, Long> {

    @Query("SELECT j FROM Jobs j WHERE j IN (SELECT p.job FROM Person p WHERE p.name = :name AND p.surname=:surname)")
    public Jobs findJobByPersona(@Param("name") String name,@Param("surname") String surname);
}
