package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.projectControllerModel;
import com.project.generator.model.projectServiceModel;

@Component
public class CreatingServices {

	@Autowired
	CreateMethodName createMethod;
	
	public  List<String> createServices(String serviceName,String modelName,List<projectServiceModel> projectSrvmodel,String dbName,String pkgName) {
		   List<String> serViceHeader=new ArrayList<String>();		
		   serViceHeader.add("package "+pkgName+".services;");
		   serViceHeader.add("import java.util.*;");
		   serViceHeader.add("import org.springframework.stereotype.*;");
		   serViceHeader.add("import "+pkgName+".model.*;");
		   serViceHeader.add(" ");
		   serViceHeader.add(" ");
		   serViceHeader.add("@Service");                        
		   serViceHeader.add("@Component");
	       serViceHeader.add("public interface "+" "+serviceName+"{");
	       serViceHeader.add(" ");
		   serViceHeader.add(" ");
		   projectSrvmodel.forEach((serviceData)->{ createServiceMethod(serviceData,modelName,dbName).forEach((srvData)->{serViceHeader.add(srvData);}); });
		   serViceHeader.add(" ");
		   serViceHeader.add(" ");
		return serViceHeader;
		
	    }
	
	 public List<String> createServiceMethod(projectServiceModel projectSrvmodel,String modelName,String dbName) {
		   
		   List<String> serviceMethodlist=new ArrayList<>();
		   List<String> createserviceMethodData=new ArrayList<>();

			 for (Map.Entry<String, Map<String,String>> methodType : projectSrvmodel.getMethodcreate().entrySet()) 
			   {
				 for(Map.Entry<String,String> methodval:methodType.getValue().entrySet()) {
				    
					 
                       if(methodType.getKey().equalsIgnoreCase("post")){
						 
                    	   createserviceMethodData=createPostMethod(methodType.getValue().get(modelName), modelName);
					   }
					    if(methodType.getKey().equalsIgnoreCase("get")){
							 
					    	createserviceMethodData=createGetMethod(methodType.getValue().get(modelName),modelName);					    	
					   }
					    if(methodType.getKey().equalsIgnoreCase("getById")){
							 
					    	createserviceMethodData=createGetMethodByID(methodType.getValue().get(modelName),modelName,dbName);					    	
					   }
					    if(methodType.getKey().equalsIgnoreCase("put")){
					    	createserviceMethodData=createPutMethod(methodType.getValue().get(modelName),modelName,dbName);
					    	
					   }
					    if(methodType.getKey().equalsIgnoreCase("delete")){
					    	createserviceMethodData=createDeleteMethod(methodType.getValue().get(modelName),modelName);
					    	
					   }
					    if(methodType.getKey().equalsIgnoreCase("deleteById")){
					    	createserviceMethodData=createDeleteMethodByID(methodType.getValue().get(modelName),modelName,dbName);
					    }
				 }
				 createserviceMethodData.forEach((methodData)-> serviceMethodlist.add(methodData));
				 }
				 
			   
			   

			return serviceMethodlist;
		}
	 
		
	 public List<String> createPostMethod(String methodName,String returnType) {
			
 			List<String> postMethod=new ArrayList<>();
			
			   postMethod.add(" ");			  
			   postMethod.add("   public "+returnType+" "+"create"+createMethod.createMethodName(returnType) +"("+" "+ createMethod.createMethodName(returnType)+" "+ returnType.toLowerCase()+");");
		      
			return postMethod;
			
		    }
	   public  List<String> createGetMethod(String methodName,String returnType) {
		   List<String> gettMethod=new ArrayList<>();		   
		   gettMethod.add(" ");		  
		   gettMethod.add("    public List<"+returnType+"> "+"get"+createMethod.createMethodName(returnType) +"All();");
			return gettMethod;
			
		    }
	   public  List<String> createGetMethodByID(String methodName,String returnType, String dbName) {
		   List<String> gettMethod=new ArrayList<>();		   
		   gettMethod.add(" ");	
			   if(dbName.equalsIgnoreCase("mongo")) {
				   gettMethod.add("    public "+returnType+" "+"get"+createMethod.createMethodName(returnType) +"ById(String id);");
			   }else {
				   gettMethod.add("    public "+returnType+" "+"get"+createMethod.createMethodName(returnType) +"ById(long id);");
			   }
				   
			 return gettMethod;
			
		    }
	   public  List<String> createPutMethod(String methodName,String returnType,String dbName ) {
			
		   List<String> putMethod=new ArrayList<>();		 
		   putMethod.add(" ");
		   if(dbName.equalsIgnoreCase("mongo")) {
			   putMethod.add("   public "+returnType+" "+"update"+createMethod.createMethodName(returnType) +"("+" "+ createMethod.createMethodName(returnType)+" "+ returnType.toLowerCase()+",String id);");
	       
		   }else {
			   putMethod.add("   public "+returnType+" "+"update"+createMethod.createMethodName(returnType) +"("+" "+ createMethod.createMethodName(returnType)+" "+ returnType.toLowerCase()+",long id);");
		   }
			   return putMethod;
			
		    }
	   public List<String> createDeleteMethod(String methodName,String returnType) {
		   List<String> deletMethod=new ArrayList<>();	  	
		   deletMethod.add("  ");		  
		   deletMethod.add("   public "+returnType+" "+"delete"+createMethod.createMethodName(returnType) +"("+" "+ createMethod.createMethodName(returnType)+" "+ returnType.toLowerCase()+");");
	      
			return deletMethod;
			
		    }
	   
	   public  List<String> createDeleteMethodByID(String methodName,String returnType,String dbName) {
		   List<String> gettMethod=new ArrayList<>();		   
		   gettMethod.add(" ");
		   if(dbName.equalsIgnoreCase("mongo")) {
			   gettMethod.add("    public "+"void"+" "+"delete"+createMethod.createMethodName(returnType) +"ById(String id);");
		   }else{
			   
			   gettMethod.add("    public "+"void"+" "+"delete"+createMethod.createMethodName(returnType) +"ById(long id);");
		   }
		  return gettMethod;
			
		 }
	  

}
