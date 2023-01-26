package com.stackroute.datamunger;

/*There are total 5 DataMungertest files:
 * 
 * 1)DataMungerTestTask1.java file is for testing following 3 methods
 * a)getSplitStrings()  b) getFileName()  c) getBaseQuery()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask1.java
 * 
 * 2)DataMungerTestTask2.java file is for testing following 3 methods
 * a)getFields() b) getConditionsPartQuery() c) getConditions()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask2.java
 * 
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getLogicalOperators() b) getOrderByFields()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 * 
 * 4)DataMungerTestTask4.java file is for testing following 2 methods
 * a)getGroupByFields()  b) getAggregateFunctions()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask4.java
 * 
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */

import java.lang.reflect.Array;
import java.sql.SQLData;
import java.util.Arrays;

public class DataMunger {

	/*
	 * This method will split the query string based on space into an array of words
	 * and display it on console
	 */
	public String[] getSplitStrings(String queryString) {
		System.out.println("EXERCISE 1");

		queryString = queryString.toLowerCase();
		//Split the strings at each word
		String[] word = queryString.split(" ");

		//print each word by iterating through the words
		for (String i: word) {
			System.out.println(i);
		}
		return word;
	}

	/*
	 * Extract the name of the file from the query. File name can be found after a
	 * space after "from" clause. Note: ----- CSV file can contain a field that
	 * contains from as a part of the column name. For eg: from_date,from_hrs etc.
	 * 
	 * Please consider this while extracting the file name in this method.
	 */

	public String getFileName(String queryString) {
		System.out.println("\nEXERCISE 2");
		String fileName = "";

		System.out.println("This is queryString: "+queryString);
		String[] word = queryString.split("from ");

		fileName= word[1].split(" ")[0];
		System.out.println("This is filename: "+fileName);
		return fileName;
	}

	/*
	 * This method is used to extract the baseQuery from the query string. BaseQuery
	 * contains from the beginning of the query till the where clause
	 * 
	 * Note: ------- 1. The query might not contain where clause but contain order
	 * by or group by clause 2. The query might not contain where, order by or group
	 * by clause 3. The query might not contain where, but can contain both group by
	 * and order by clause
	 */

	public String getBaseQuery(String queryString) {
		System.out.println("EXERCISE 3");
		String base = "";

		System.out.println("This is query: "+ queryString);
		//get all words from input
		String[] word = queryString.split(" ");

		//loop to find "where", then print the words before
		for (int i=0; i< word.length; i++) {
			if (word[i].equals("where") || word[i].equals("order by") || word[i].equals("group by") ){
				break;
			}
			base = base + word[i] + " " ;
		}
		base = base.trim();

		if (base.contains("group by")){
			word = base.split("group by");
			base = word[0];
		}

		if (base.contains("order by")){
			word = base.split("order by");
			base = word[0];
		}
		base = base.trim();

		System.out.println("This is base: " + base);
		return base;
	}

	/*
	 * This method will extract the fields to be selected from the query string. The
	 * query string can have multiple fields separated by comma. The extracted
	 * fields will be stored in a String array which is to be printed in console as
	 * well as to be returned by the method
	 * 
	 * Note: 1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The field
	 * name can contain '*'
	 * 
	 */
	
	public String[] getFields(String queryString) {
		System.out.println("Exercise 1");
		System.out.println("This is the query: " +queryString);

		String field= " ";
		String[] word = queryString.split("select");
		word = word[1].split(" ");

		for (String words : word){
			if (words.equals("from")){
				break;
			}
			field= field + words;
		}

		word = field.trim().split(" ");

		if (field.contains(",")){
			word = field.trim().split(",");
		}

		System.out.println(Arrays.toString(word));
		return word;
	}

	/*
	 * This method is used to extract the conditions part from the query string. The
	 * conditions part contains starting from where keyword till the next keyword,
	 * which is either group by or order by clause. In case of absence of both group
	 * by and order by clause, it will contain till the end of the query string.
	 * Note:  1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
	 * might not contain where clause at all.
	 */
	
	public String getConditionsPartQuery(String queryString) {
		System.out.println("This is Exercise 2");
		System.out.println("This is the query: "+ queryString );

		if (!queryString.contains("where")){
			return null;
		}

		String[] word = queryString.split("where");
		String filter = "";

		//check if word contains "group by"
		if (word[1].contains("group by")) {
			filter = word[1].split("group by")[0].trim().toLowerCase();
		}
		//check if word contains "order by"
		else if (word[1].contains("order by")) {
			filter = word[1].split("order by")[0].trim().toLowerCase();
		}
		//if it does not have "group by" or "order by"
		else {
			filter = word[1].trim().toLowerCase();
		}

		System.out.println("This is the filter part: "+ filter);
		return filter;
	}

	/*
	 * This method will extract condition(s) from the query string. The query can
	 * contain one or multiple conditions. In case of multiple conditions, the
	 * conditions will be separated by AND/OR keywords. for eg: Input: select
	 * city,winner,player_match from ipl.csv where season > 2014 and city
	 * ='Bangalore'
	 * 
	 * This method will return a string array ["season > 2014","city ='bangalore'"]
	 * and print the array
	 * 
	 * Note: ----- 1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
	 * might not contain where clause at all.
	 */

	public String[] getConditions(String queryString) {
		System.out.println("This is Exercise 3");
		System.out.println("This is the query: "+ queryString );

		if (!queryString.contains("where")){
			return null;
		}

		String[] word = queryString.split("where");
		String filter = word[1];

		//check if word contains "group by"
		if (filter.contains("group by")) {
			word = filter.split("group by");
			filter = word[0].trim();
		}

		//check if word contains "order by"
		if (filter.contains("order by")) {
			word = filter.split("order by");
			filter = word[0].trim();
		}

		//check if it contains "and"
		if (filter.contains("and")){
			filter = filter.replace("and ", ",");
		}

		if (filter.contains("or")){
			filter = filter.replace("or ", ",");
		}

		filter=filter.trim().toLowerCase();
		word = filter.split(" ,");

		System.out.println("This is the filter part: "+ Arrays.toString(word));
		return word;
	}

	/*
	 * This method will extract logical operators(AND/OR) from the query string. The
	 * extracted logical operators will be stored in a String array which will be
	 * returned by the method and the same will be printed Note:  1. AND/OR
	 * keyword will exist in the query only if where conditions exists and it
	 * contains multiple conditions. 2. AND/OR can exist as a substring in the
	 * conditions as well. For eg: name='Alexander',color='Red' etc. Please consider
	 * these as well when extracting the logical operators.
	 * 
	 */

	public String[] getLogicalOperators(String queryString) {
		System.out.println("This is Exercise 1");
		System.out.println("This is the query: "+ queryString );

		String operator = "";

		if(!queryString.contains("where")){
			return null;
		}

		if (queryString.contains(" or ")){
			operator = "or ";
		}

		if (queryString.contains(" and ")){
			operator = operator + "and ";
		}

		if (queryString.contains(" not ")){
			operator = operator + "not";
		}

		String[] result = operator.split(" ");
		System.out.println("This is the result: "+ Arrays.toString(result));

		return result;
	}

	/*
	 * This method extracts the order by fields from the query string. Note: 
	 * 1. The query string can contain more than one order by fields. 2. The query
	 * string might not contain order by clause at all. 3. The field names,condition
	 * values might contain "order" as a substring. For eg:order_number,job_order
	 * Consider this while extracting the order by fields
	 */

	public String[] getOrderByFields(String queryString) {
		System.out.println("This is Exercise 2");
		System.out.println("This is the query: "+ queryString);
		String fields = " ";

		if (!queryString.contains("order by")){
			return null;
		}

		String[] field = queryString.split("order by");
		for (int i=1; i<field.length; i++){
			fields = fields + field[i];
			fields= fields.trim();

		}
		fields= fields.trim();
		field= fields.split(" ");
		System.out.println(Arrays.toString(field));
		return field;
	}

	/*
	 * This method extracts the group by fields from the query string. Note:
	 * 1. The query string can contain more than one group by fields. 2. The query
	 * string might not contain group by clause at all. 3. The field names,condition
	 * values might contain "group" as a substring. For eg: newsgroup_name
	 * 
	 * Consider this while extracting the group by fields
	 */

	public String[] getGroupByFields(String queryString) {
		System.out.println("This is Exercise 1");
		System.out.println("This is the query: "+ queryString);
		String fields = " ";

		if (!queryString.contains("group by")){
			return null;
		}

		String[] field = queryString.split("group by");
		for (int i=1; i<field.length; i++){
			fields = fields + field[i];
			fields= fields.trim();

		}
		fields= fields.trim().toLowerCase();
		field= fields.split(" ");
		System.out.println(Arrays.toString(field));
		return field;
	}

	/*
	 * This method extracts the aggregate functions from the query string. Note:
	 *  1. aggregate functions will start with "sum"/"count"/"min"/"max"/"avg"
	 * followed by "(" 2. The field names might
	 * contain"sum"/"count"/"min"/"max"/"avg" as a substring. For eg:
	 * account_number,consumed_qty,nominee_name
	 * 
	 * Consider this while extracting the aggregate functions
	 */

	public String[] getAggregateFunctions(String queryString) {
		System.out.println("This is Exercise 2");
		System.out.println("This is query: " + queryString);

		String agg = " ";
		String[] word = queryString.split("select");
		word = word[1].trim().split(" ");

		for (String words: word){
			if (words.startsWith("sum(") || words.startsWith("count(") || words.startsWith("min(") || words.startsWith("max(") || words.startsWith("avg(")){
				agg = agg + words;
			}
		}

		if (agg.contains(",")){
			word = agg.trim().split(",");
		}

		agg=" ";

		for (String words: word){
			if (words.startsWith("sum(") || words.startsWith("count(") || words.startsWith("min(") || words.startsWith("max(") || words.startsWith("avg(")){
				agg = agg + " " + words;
			}
		}

		if (agg.equals(" ")){
			return null;
		}
		word = agg.trim().split(" ");
		System.out.println(Arrays.toString(word));
		return word;
	}

}













