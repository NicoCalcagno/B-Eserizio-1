package com.example.demo.dao;

import com.example.demo.entity.Jobs;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PersonRepositoryAccessDb extends JpaRepository<Person, Long> {


    @Query("SELECT j FROM Jobs j INNER JOIN Person p ON p.job = j.jobId WHERE p.name= :name AND p.surname= :surname")
    Optional<Jobs> findJobByPersona(@Param("name") String name, @Param("surname") String surname);
}
