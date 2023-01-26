package com.stackroute.datamunger.query.parser;

/*There are total 4 DataMungerTest file:
 * 
 * 1)DataMungerTestTask1.java file is for testing following 4 methods
 * a)getBaseQuery()  b)getFileName()  c)getOrderByClause()  d)getGroupByFields()
 * 
 * Once you implement the above 4 methods,run DataMungerTestTask1.java
 * 
 * 2)DataMungerTestTask2.java file is for testing following 2 methods
 * a)getFields() b) getAggregateFunctions()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask2.java
 * 
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getRestrictions()  b)getLogicalOperators()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 * 
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public class QueryParser {

	private QueryParameter queryParameter = new QueryParameter();

	/*
	 * This method will parse the queryString and will return the object of
	 * QueryParameter class
	 */
	public QueryParameter parseQuery(String queryString) {
		queryParameter.setQueryString(queryString);
		queryParameter.setBasesQuery(getBaseQuery(queryString));
		queryParameter.setFile(getFileName(queryString));
		queryParameter.setOrderByFields(getOrderByFields(queryString));
		queryParameter.setGroupByFields(getGroupByFields(queryString));

		queryParameter.setFields(getFields(queryString));
		queryParameter.setAggregateFunctions(getAggregateFunctions(queryString));
		queryParameter.setRestrictions(getConditions(queryString));
		queryParameter.setLogicalOperators(getLogicalOperators(queryString));



		return queryParameter;
	}

	/*
	 * Extract the name of the file from the query. File name can be found after the
	 * "from" clause.
	 */
	public String getFileName(String queryString) {
		System.out.println("\nExtract file name after 'from'");
		String fileName = "";

		System.out.println("This is queryString: "+queryString);
		String[] word = queryString.split("from ");

		fileName= word[1].split(" ")[0];
		System.out.println("This is filename: "+fileName);
		return fileName;
	}


	/*
	 * 
	 * Extract the baseQuery from the query.This method is used to extract the
	 * baseQuery from the query string. BaseQuery contains from the beginning of the
	 * query till the where clause
	 */
	public String getBaseQuery(String queryString) {
		System.out.println("\nExtract base part before 'where'");
		String base = "";

		System.out.println("This is query: "+ queryString);

		if (!queryString.contains("where")){
			return queryString;
		}

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
	 * extract the order by fields from the query string. Please note that we will
	 * need to extract the field(s) after "order by" clause in the query, if at all
	 * the order by clause exists. For eg: select city,winner,team1,team2 from
	 * data/ipl.csv order by city from the query mentioned above, we need to extract
	 * "city". Please note that we can have more than one order by fields.
	 */
	public List<String> getOrderByFields(String queryString) {
		System.out.println("\nExtract 'order by' fields ");
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

		List<String> list = Arrays.asList(field);
		System.out.println("This is the answer " + list);
		return list;
	}


	/*
	 * Extract the group by fields from the query string. Please note that we will
	 * need to extract the field(s) after "group by" clause in the query, if at all
	 * the group by clause exists. For eg: select city,max(win_by_runs) from
	 * data/ipl.csv group by city from the query mentioned above, we need to extract
	 * "city". Please note that we can have more than one group by fields.
	 */
	public List<String> getGroupByFields(String queryString) {
		System.out.println("\nExtract 'group by' fields");
		System.out.println("This is the query: "+ queryString);
		String fields = " ";

//		if (!queryString.contains("group by")){
//			return null;
//		}

		String[] field = queryString.split("group by");
		for (int i=1; i<field.length; i++){
			fields = fields + field[i];
			fields= fields.trim();

		}
		if (fields.contains("order by")){
			field = fields.split("order by");
			fields = field[0];
		}
		fields= fields.trim().toLowerCase();
		field= fields.split(" ");
//		System.out.println(Arrays.toString(field));

		List<String> list = Arrays.asList(field);
		System.out.println("This is the answer " + list);
		return list;
	}
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////

	/*
	 * Extract the selected fields from the query string. Please note that we will
	 * need to extract the field(s) after "select" clause followed by a space from
	 * the query string. For eg: select city,win_by_runs from data/ipl.csv from the
	 * query mentioned above, we need to extract "city" and "win_by_runs". Please
	 * note that we might have a field containing name "from_date" or "from_hrs".
	 * Hence, consider this while parsing.
	 */
	public List<String> getFields(String queryString) {
		System.out.println("\nExtract the selected fields after 'select' ");
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


		List<String> list = Arrays.asList(word);
		System.out.println("This is the answer " + list);
		return list;
	}

	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	/*
	 * Extract the conditions from the query string(if exists). for each condition,
	 * we need to capture the following: 1. Name of field 2. condition 3. value
	 * 
	 * For eg: select city,winner,team1,team2,player_of_match from data/ipl.csv
	 * where season >= 2008 or toss_decision != bat
	 * 
	 * here, for the first condition, "season>=2008" we need to capture: 1. Name of
	 * field: season 2. condition: >= 3. value: 2008
	 * 
	 * the query might contain multiple conditions separated by OR/AND operators.
	 * Please consider this while parsing the conditions.
	 * 
	 */
	public List<Restriction> getConditions(String queryString) {
		System.out.println("Extract Conditions");
		System.out.println("This is the query: "+ queryString );

		List<Restriction> list = new ArrayList<>();
		String condition = null;
		String field;
		String value;

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

		for (String words: word){
			if (words.contains("=")){
				condition= "=";
				words = words.replace("=", " ");
			}else if (words.contains("+")){
				condition= "+";
				words = words.replace("+", " ");
			}else if (words.contains("=<")){
				condition= "=<";
				words = words.replace("=<", " ");
			}else if (words.contains(">=")){
				condition= ">=";
				words = words.replace(">=", " ");
			}else if (words.contains(">")){
				condition= ">";
				words = words.replace(">", " ");
			} else if (words.contains("<")) {
				condition="<";
				words = words.replace("<", " ");
			}
			System.out.println("This is word before split: " + Arrays.toString(word));
			if (words.contains("'")){
				words= words.replace("'", "");
			}
			word = words.split("\\s+");

			System.out.println("This is word after split: " + Arrays.toString(word));
			field = word[0];
			value = word[1];
			list.add(new Restriction(field, value, condition));
		}
		
		System.out.println("This is the filter part: "+ list);
		return list;
	}



	/*
	 * Extract the logical operators(AND/OR) from the query, if at all it is
	 * present. For eg: select city,winner,team1,team2,player_of_match from
	 * data/ipl.csv where season >= 2008 or toss_decision != bat and city =
	 * bangalore
	 * 
	 * The query mentioned above in the example should return a List of Strings
	 * containing [or,and]
	 */
	public List<String> getLogicalOperators(String queryString) {
		System.out.println("\nExtract the logical operator");
		System.out.println("This is the query: "+ queryString );

		List<String> list = new ArrayList<>();

		if(!queryString.contains("where")){
			return null;
		}


		String[] result = queryString.split(" ");
		for (String str: result){
			str=str.trim();
			if (str.equals("and")){
				list.add("and");
			} else if (str.equals("or")) {
				list.add("or");
			} else if (str.contains("not")) {
				list.add("not");
			}
		}


		System.out.println("This is answer: "+ list.toString());

		return list;
	}


	/*
	 * Extract the aggregate functions from the query. The presence of the aggregate
	 * functions can determined if we have either "min" or "max" or "sum" or "count"
	 * or "avg" followed by opening braces"(" after "select" clause in the query
	 * string. in case it is present, then we will have to extract the same. For
	 * each aggregate functions, we need to know the following: 1. type of aggregate
	 * function(min/max/count/sum/avg) 2. field on which the aggregate function is
	 * being applied.
	 * 
	 * Please note that more than one aggregate function can be present in a query.
	 */


	public List<AggregateFunction> getAggregateFunctions(String queryString) {
		System.out.println("\nExtract the aggregate functions");
		System.out.println("This is query: " + queryString);

		String agg = " ";
		List<AggregateFunction> list = new ArrayList<>();

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


		for (String str: word){
			str = str.replace("(", " ");
			str = str.replace(")", " ");

			word = str.split(" ");

			list.add(new AggregateFunction(word[1],word[0]));
		}

		System.out.println("This is the answer: " + list);
		return list;
	}



}






























