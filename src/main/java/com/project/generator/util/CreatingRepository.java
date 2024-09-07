package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreatingRepository {
	@Autowired
	CreateMethodName createMethod;
		
	 public  List<String> createRepository(String repoName,String modelName,String MethodName,Map<String,String> paramName,String dbName,String pkgName,String jVesrion) {
		  

		   List<String> repositoryHeader=new ArrayList<String>();
		    repositoryHeader.add("package "+pkgName+".repository;");			
		    repositoryHeader.add("import java.util.*;");
		    repositoryHeader.add("import java.io.*;");
			repositoryHeader.add("import org.springframework.stereotype.*;");
		    repositoryHeader.add("import org.springframework.beans.factory.annotation.*;");		   
		    repositoryHeader.add("import org.springframework.data.jpa.repository.JpaRepository;");
		    if(!jVesrion.equals("1.8")) {
		    	 repositoryHeader.add("import org.springframework.data.repository.CrudRepository;");
		    }		   
		    repositoryHeader.add("import "+pkgName+".model.*;");
		    repositoryHeader.add(" ");
		    repositoryHeader.add(" ");			
			if(dbName.equalsIgnoreCase("mongo")) {
				repositoryHeader.add("import org.springframework.data.mongodb.repository.MongoRepository;");
			    repositoryHeader.add(" ");
			   repositoryHeader.add("public interface"+" "+repoName+" "+"extends MongoRepository<"+createMethod.createMethodName(modelName)+",String>{");
			}else { 
				repositoryHeader.add("@Component");
			    repositoryHeader.add("public interface"+" "+repoName+" "+"extends JpaRepository<"+createMethod.createMethodName(modelName)+",Long>{");
			  repositoryHeader.add(" ");
			}
		    repositoryHeader.add(" ");
		    repositoryHeader.add(" ");
			return repositoryHeader;
			
		    }
	 
	 public List<String> createRepositoryMethod(String MethodName,Map<String,String> paramName) {
		   
		   List<String> serviceMethod=new ArrayList<>();
		  
			  		
			   for (Map.Entry<String, String> entry : paramName.entrySet()) 
			   {
				   serviceMethod.add("public void "+MethodName+"("+entry.getKey()+" "+entry.getValue()+");");
			   }
			   
			return serviceMethod;
		}
	   

}
