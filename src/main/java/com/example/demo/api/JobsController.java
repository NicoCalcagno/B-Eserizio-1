package com.example.demo.api;

import com.example.demo.model.Jobs;
import com.example.demo.model.JobsDTO;
import com.example.demo.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/job")
public class JobsController {


    private final JobsService jobService;

    @Autowired
    public JobsController(JobsService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(value="/add")
    public void addJob(@RequestBody JobsDTO job){
        Jobs jobPersistent = new Jobs();
        jobPersistent.setNamejob(job.getNamejob());
        jobService.addJob(jobPersistent);
    }

    @DeleteMapping(value="/delete")
    public void deleteJob(@RequestBody JobsDTO job){
        jobService.deleteJobById(job.getIdjob());
    }

    @PutMapping(value="/update/{id}")
    public Jobs updateJob(@PathVariable(value = "id") Long idjob, @RequestBody JobsDTO jobsname){
        String newname = jobsname.getNamejob();
        Jobs job = jobService.findById(idjob);
        job.setNamejob(newname);
        return jobService.saveUpdate(job);
    }

}
