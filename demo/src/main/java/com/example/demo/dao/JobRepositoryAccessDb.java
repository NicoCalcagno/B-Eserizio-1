package com.example.demo.dao;

import com.example.demo.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JobRepositoryAccessDb extends JpaRepository<Jobs, Long> {

}