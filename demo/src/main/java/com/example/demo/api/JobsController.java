package com.example.demo.api;

import com.example.demo.entity.Jobs;
import com.example.demo.dto.JobsDTO;

import com.example.demo.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/job")
public class JobsController {


    private final JobsService jobService;

    @Autowired
    public JobsController(JobsService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public void addJob(@RequestBody JobsDTO job){
        Jobs jobPersistent = new Jobs();
        jobPersistent.setJobName(job.getNamejob());
        jobService.addJob(jobPersistent);
    }

    @DeleteMapping(value="/{id}/delete")
    public void deleteJob(@PathVariable Long id){
        jobService.deleteJobById(id);
    }


    @PutMapping(value="/{id}/update")
    public Jobs updateJob(@PathVariable Long id, @RequestBody JobsDTO jobDto){
        String newName = jobDto.getNamejob();
        Jobs job = jobService.findById(id);
        job.setJobName(newName);
        return jobService.saveUpdate(job);
    }

    @GetMapping
    public List<Jobs> retrieveAllJobs(){
        return jobService.retrieveAllJobs();
    }

}