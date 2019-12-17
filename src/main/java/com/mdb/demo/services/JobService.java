package com.mdb.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.stereotype.Service;

import com.mdb.demo.entity.Job;
import com.mdb.demo.entity.JobRepository;
import com.mongodb.operation.AggregateOperation;

@Service
public class JobService {
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	MongoOperations mongo;
	
	public List<Job> getJobsByAggregation() {
		// Simple Helper to build Aggregation
		AggregationBuilder builder = new AggregationBuilder();
		
		// add match query
		builder.addMatchQuery(Criteria.where("title").is("Java Developer"));
		
		// aggregate job
		AggregationResults<Job> res = mongo.aggregate(builder.build(), "Job", Job.class);
		
		// return mapped results
		return res.getMappedResults();
	}
}