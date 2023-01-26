package com.stackroute.datamunger.query.parser;

import java.util.List;

/* 
 * This class will contain the elements of the parsed Query String such as conditions,
 * logical operators,aggregate functions, file name, fields group by fields, order by
 * fields, Query Type
 * */

public class QueryParameter {

	private String queryString;
	private String file;
	private String basesQuery;
	private String QUERY_TYPE;
	private List<String> fields;
	private List<Restriction> restrictions;
	private List<String> logicalOperators;
	private List<AggregateFunction> aggregateFunctions;
	private List<String> orderByFields;
	private List<String> groupByFields;
	/*
	 - queryString : String
    - QUERY_TYPE -> String
	 */

	public void setQueryString(String queryString) {
		this.file = queryString;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setBasesQuery(String basesQuery) {
		this.basesQuery = basesQuery;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}

	public void setLogicalOperators(List<String> logicalOperators) {
		this.logicalOperators = logicalOperators;
	}

	public void setAggregateFunctions(List<AggregateFunction> aggregateFunctions) {
		this.aggregateFunctions = aggregateFunctions;
	}

	public void setOrderByFields(List<String> orderByFields) {
		this.orderByFields = orderByFields;
	}

	public void setGroupByFields(List<String> groupByFields) {
		this.groupByFields = groupByFields;
	}

	public String getQueryString() {
		return queryString;
	}

	public String getFileName() {
		return file;
	}

	public String getBaseQuery() {
		return basesQuery;
	}

	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	public List<String> getLogicalOperators() {
		return logicalOperators;
	}

	public List<String> getFields() {
		return fields;
	}

	public List<AggregateFunction> getAggregateFunctions() {
		return aggregateFunctions;
	}

	public List<String> getGroupByFields() {
		return groupByFields;
	}

	public List<String> getOrderByFields() {
		return orderByFields;
	}
}