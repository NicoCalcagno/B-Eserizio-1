package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_job;

    @Column(name = "name_job")
    private String name_job;

    public Jobs(){

    }


    public String getJob() {
        return name_job;
    }

    public void setJob(String name_job) {
        this.name_job = name_job;
    }

    public Long getId_job() {
        return id_job;
    }

    public void setId_job(Long id_job) {
        this.id_job = id_job;
    }
}
