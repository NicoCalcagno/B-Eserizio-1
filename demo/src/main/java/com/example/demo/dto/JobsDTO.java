package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobsDTO {

    private Long idjob;

    private String namejob;

    public JobsDTO(@JsonProperty("namejob") String namejob){
        this.namejob = namejob;
    }

    public Long getIdjob() {
        return idjob;
    }

    public void setIdjob(Long idjob) {
        this.idjob = idjob;
    }

    public String getNamejob() {
        return namejob;
    }

    public void setNamejob(String namejob) {
        this.namejob = namejob;
    }
}