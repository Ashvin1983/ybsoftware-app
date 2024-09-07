package com.project.generator.util.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class sqlQuery implements SqlQueries {



	@Override
	public String createSqlInserQuery(Map<String,String> query,String tableName,String dataType) {
		  String sqlquery="";	
		   if(dataType.equalsIgnoreCase("mysql")) {
				sqlquery="INSERT INTO "+tableName+"("+ getParam(query) +") values ("+dataTypevalidateParam(query)+")";
			}
			else if(dataType.equalsIgnoreCase("mssql")) {
				sqlquery="INSERT INTO [dbo].["+tableName+"] ("+ getParam(query)+") values ("+dataTypevalidateParam(query)+")";
			}
			return sqlquery;
	} 

	@Override
	public String createSqlGetQuery(Map<String,String> query,String tableName,String dataType) {
		
		 String sqlquery="";	
		if(query.isEmpty()) {
			
			 if(dataType.equalsIgnoreCase("mysql")) {
				 sqlquery="SELECT * FROM "+tableName;
				 }else if(dataType.equalsIgnoreCase("mssql")) {
					 sqlquery="SELECT * FROM [dbo].["+tableName+"]";
				 }
		}
		else {
			if(dataType.equalsIgnoreCase("mysql")) {
			     sqlquery="SELECT"+getParam(query)+" FROM "+tableName+" WHERE "+createWhereQuery(query)+"\"";
			 }else if(dataType.equalsIgnoreCase("mssql")) {
				 sqlquery="SELECT"+getParam(query)+" FROM [dbo].["+tableName+"] WHERE "+createWhereQuery(query)+"\"";
			 }
		}
		
		
			return sqlquery;
	}

	@Override
	public String createSqlUpdateQuery(Map<String,String> query,String tableName,String dataType) {
		   
		    String sqlquery="";
		    
		    final Set<Entry<String, String>> mapValues = query.entrySet();
	        final int maplength = mapValues.size();
	        final Entry<String,String>[] whereEntry = new Entry[maplength];
	        mapValues.toArray(whereEntry);
	        Map<String,String> wherequery=new HashMap<String, String>();
	        wherequery.put(whereEntry[0].getKey(), whereEntry[0].getValue());
		    
			if(dataType.equalsIgnoreCase("mysql")) {
			     sqlquery="UPDATE "+tableName+" SET  "+ getParam(query)+"="+dataTypevalidateParam(query)+" WHERE "+createWhereQuery(wherequery)+"\"";
			 }else if(dataType.equalsIgnoreCase("mssql")) {
				 sqlquery="UPDATE [dbo].["+tableName+"] SET  "+ getParam(query)+"="+dataTypevalidateParam(query)+" WHERE "+createWhereQuery(wherequery)+"\"";
			 }
			return sqlquery;
		
	}

	@Override
	public String createSqlDeleteQuery(Map<String,String> query,String tableName,String dataType) {
		 String sqlquery="";
		   final Set<Entry<String, String>> mapValues = query.entrySet();
	        final int maplength = mapValues.size();
	        final Entry<String,String>[] whereEntry = new Entry[maplength];
	        mapValues.toArray(whereEntry);
	        Map<String,String> wherequery=new HashMap<String, String>();
	        wherequery.put(whereEntry[0].getKey(), whereEntry[0].getValue());
	        
		if(dataType.equalsIgnoreCase("mysql")) {
		     sqlquery="DELETE FROM "+tableName+" WHERE " +createWhereQuery(wherequery)+"\"";
		 }else if(dataType.equalsIgnoreCase("mssql")) {
			 sqlquery="DELETE FROM [dbo].["+tableName+"] WHERE " + createWhereQuery(wherequery)+"\"";
		 }
		return sqlquery;
	}
	@Override
	public List<String> createSqlQueryFunction(List<String> queryData,String queryType) {
		List<String> sqlQuryList = new ArrayList<String>();		
		sqlQuryList.add("sql.connect(config.config, function (err) {");		    
		sqlQuryList.add("if (err) console.log(err);");		
		sqlQuryList.add("// create Request object");
		sqlQuryList.add("   var request = new sql.Request();");		  
		sqlQuryList.add("// query to the database and get the records");
		sqlQuryList.add(" request.query(\""+queryType+"\", function (err, recordset) { ");		     
		sqlQuryList.add(" if (err) console.log(err) ");		
		sqlQuryList.add(" // send records as a response ");
		sqlQuryList.add(" res.send(recordset);");		  
		sqlQuryList.add("  });");
		sqlQuryList.add(" });");
		sqlQuryList.add("});");
	 
		return sqlQuryList;
	}
	
	public String dataTypevalidateParam(Map<String,String>  queryParam){
		StringBuffer sqlQuryParamList = new StringBuffer();
	

		queryParam.forEach((K,V)->{
			
		
			if(V.equalsIgnoreCase("Integer")) {
				
				sqlQuryParamList.append("\"+"+K+"+\",");
			}
            if(V.equalsIgnoreCase("String")) {
            	sqlQuryParamList.append("'\"+"+K+"+\"',");
			}
            if(V.equalsIgnoreCase("Float")) {
            	sqlQuryParamList.append("+\""+K+"+\",");
			}
			
		});
		
		return sqlQuryParamList.toString().substring(0, sqlQuryParamList.toString().length()-1);	
	}
	public String getParam(Map<String,String>  queryParam){
		StringBuffer sqlQuryParamList = new StringBuffer();		 
		  
		queryParam.forEach((K,V)->{
			
			if(queryParam.size() !=queryParam.size()-1){
				sqlQuryParamList.append(K+",");
		      }
			else {
				sqlQuryParamList.append(K);
			}
			   	
		});
		
		return sqlQuryParamList.toString().substring(0, sqlQuryParamList.toString().length()-1);	
	}
	public String createWhereQuery(Map<String,String>  queryParam){
		StringBuffer sqlQuryParamList = new StringBuffer();
		
		queryParam.forEach((K,V)->{

				if(V.equalsIgnoreCase("Integer")) {
					sqlQuryParamList.append(K+"=");
					sqlQuryParamList.append("\"+"+K+"+\"");
				}
	            if(V.equalsIgnoreCase("String")) {
	            	sqlQuryParamList.append(K+"=");
	            	sqlQuryParamList.append("'\"+"+K+"+\"'");
				}
	            if(V.equalsIgnoreCase("Float")) {
	            	sqlQuryParamList.append(K+"=");
	            	sqlQuryParamList.append("\"+"+K+"+\"");
				}
            
            
	
		});
		
		return sqlQuryParamList.toString().substring(0, sqlQuryParamList.toString().length()-1);		
	}
}
