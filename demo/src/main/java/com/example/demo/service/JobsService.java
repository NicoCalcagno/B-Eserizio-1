package com.example.demo.service;

import com.example.demo.dao.JobRepositoryAccessDb;
import com.example.demo.entity.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobsService {


    private final JobRepositoryAccessDb jobsRepository;

    @Autowired
    public JobsService(JobRepositoryAccessDb jobsRepository){
        this.jobsRepository = jobsRepository;
    }

    public void addJob(Jobs job){
        jobsRepository.save(job);
    }

    public List<Jobs> retrieveAllJobs(){
        return jobsRepository.findAll();
    }


    public void deleteJobById(Long idj) { jobsRepository.deleteById(idj);}

    public Jobs findById(Long idj) { return jobsRepository.getReferenceById(idj); }

    public Jobs saveUpdate(Jobs job){
        return jobsRepository.save(job);
    }

}