package com.mdb.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdb.demo.entity.Job;
import com.mdb.demo.entity.JobRepository;
import com.mdb.demo.services.JobService;

@RestController
public class IndexController {
	
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	JobService jService;
	
	
	@GetMapping(path = "/")
	public String getJobById() {
		return "Ola Amigo";
	}
	
	@PostMapping(path = "/")
	public Job postJob(@RequestBody Job job) {
		return jobRepo.save(job);
	}
	
	@GetMapping(path = "/aggr")
	public List<Job> getJobsByAggregation() {
		return jService.getJobsByAggregation();
	}
}