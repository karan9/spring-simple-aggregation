package com.mdb.demo.services;

import java.util.ArrayList;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;


public class AggregationBuilder {
	
	private ArrayList<MatchOperation> matchList;
	private ArrayList<UnwindOperation> unwindList;
	private ArrayList<SortOperation> sortList;
	private ArrayList<LimitOperation> limitList;
	
	public AggregationBuilder() {
		this.matchList = new ArrayList<MatchOperation>();
		this.unwindList = new ArrayList<UnwindOperation>();
		this.sortList = new ArrayList<SortOperation>();
		this.limitList = new ArrayList<LimitOperation>();
	}
	
	public void addMatchQuery(Criteria criteria) {
		this.matchList.add(Aggregation.match(criteria));
	}
	
	public void addMatchQuery(TextCriteria text) {
		this.matchList.add(0, Aggregation.match(text));
	}
	
	public void addAllMatchQueries(ArrayList<MatchOperation> criteriaList) {
		this.matchList.addAll(criteriaList);
	}
	
	public void addSortQuery(Direction direction) {
		this.sortList.add(Aggregation.sort(direction, "count"));
	}
	
	public void addUnwindQuery(String attribute) {
		this.unwindList.add(Aggregation.unwind(attribute));
	}
	
	public void addLimitQuery(long limit) {
		this.limitList.add(Aggregation.limit(limit));
	}
	
	public Aggregation build() {		
		ArrayList<AggregationOperation> finalObjects = new ArrayList<AggregationOperation>();
		finalObjects.addAll(this.matchList);
		finalObjects.addAll(this.unwindList);
		finalObjects.addAll(this.sortList);
		finalObjects.addAll(this.limitList);
		return Aggregation.newAggregation(finalObjects.toArray(new AggregationOperation[finalObjects.size()]));
	}
}
