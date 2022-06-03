package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "id_job")
    private Jobs job;


    public Person() {
        // Do nothing
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Jobs getJob(){
        return job;
    }

    public void setJob(Jobs job){
        this.job = job;
    }
}
