package com.mdb.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Job")
public class Job {
	private String title;
	private String location;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}