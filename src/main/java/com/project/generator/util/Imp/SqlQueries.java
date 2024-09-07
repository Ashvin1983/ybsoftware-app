package com.project.generator.util.Imp;

import java.util.*;

public interface SqlQueries {
	
	public String createSqlInserQuery(Map<String,String> query,String tableName,String dataType);
	
	public String createSqlGetQuery(Map<String,String> query,String tableName,String dataType);
		
	public String createSqlUpdateQuery(Map<String,String> query,String tableName,String dataType);
	
	public String createSqlDeleteQuery(Map<String,String> query,String tableName,String dataType);
	
	public List<String> createSqlQueryFunction(List<String> queryData,String queryType);

}
