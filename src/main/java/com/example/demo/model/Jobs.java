package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_job")
    private Long idjob;

    @Column(name = "name_job")
    private String namejob;

    public Jobs(){
        // Do nothing
    }


    public String getNamejob() {
        return namejob;
    }

    public void setNamejob(String namejob) {
        this.namejob = namejob;
    }

    public Long getIdjob() {
        return idjob;
    }

    public void setIdjob(Long idjob) {
        this.idjob = idjob;
    }
}
