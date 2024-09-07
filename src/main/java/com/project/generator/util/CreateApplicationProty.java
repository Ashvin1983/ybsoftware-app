package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreateApplicationProty {
	
	
	public List<String> createApplicationPro(String db,String dbName,String projectName ,String driverName,String url,String userName,String paswword,String port) {
		List<String> applicationProList = new ArrayList<String>();
		applicationProList.add("spring:");
		applicationProList.add("  application:");
		applicationProList.add("    name: "+projectName);		
		if(db.equals("mongo")) {
			applicationProList.add("  data: "+driverName);
			applicationProList.add("    mongodb: ");			
			applicationProList.add("      url: "+url);
			applicationProList.add("      database: "+dbName);
		}else {
			 applicationProList.add("  datasource: ");
			 applicationProList.add("	 driver-class-name: "+driverName);
			 applicationProList.add("	 url: "+url);
			 applicationProList.add("	 username: "+userName);
			 applicationProList.add("	 password: "+paswword);
		}
		applicationProList.add("  jpa:");
		applicationProList.add("    hibernate:");
		applicationProList.add("    ddl-auto: update");
		applicationProList.add("    show-sql: true");
		applicationProList.add("    database:");
		applicationProList.add("    database-platform: org.hibernate.dialect.H2Dialect");
		applicationProList.add("server: ");
		applicationProList.add("  port: "+port);
		
		
		return applicationProList;
		
	}
	
	
	

}
