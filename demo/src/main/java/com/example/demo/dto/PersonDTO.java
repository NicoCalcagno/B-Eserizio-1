package com.example.demo.dto;

import com.example.demo.entity.Jobs;

public class PersonDTO {

    private String name;
    private String surname;

    private Jobs job;

    public PersonDTO(String name, String surname, Jobs job) {
        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }
}
