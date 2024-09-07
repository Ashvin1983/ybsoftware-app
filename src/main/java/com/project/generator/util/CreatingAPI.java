package com.project.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.GeneratorSpringbootApp;
import com.project.generator.model.projectPkg;
import com.project.generator.util.config.YbSoftJavaConfig;

@Component
public class CreatingAPI {
	@Autowired
	CreateMethodName createMethod;
	private static final Logger logger = LoggerFactory.getLogger(CreatingAPI.class);
	
	@Autowired
	YbSoftJavaConfig ybjavaconfig;
	
	@Autowired
	CreatingModel crtModel;
	
	@Autowired
	CreatingServices crtService;
	
	@Autowired
	CreatingController crtController;
	
	@Autowired
	CreatingRepository crtRepository;
	
	@Autowired
	CreatingServicesImp crtserviceImp;
	
	@Autowired
	YbSoftWritingFile YbSoftwrtFile;
	 
	@Autowired
	CreateMaven createMaven;
	
	@Autowired
	CreatingMainClass creatingMainClass;
	
	@Autowired
	CreateApplicationProty createApplicationProty;
	
	List<String> createFileList=null;
	List<String>  modelName=new ArrayList<String>(); 
	Map<String,Map<String,String>>  modelDataValue=new HashMap<>(); 
	String   serViceName=null;
	String repositoryName=null;
	String serviceImpName=null;
	String createFile=null;	
	StringBuffer pkgConstrct=new StringBuffer();
	List<String> generateFileList = new ArrayList<String>();
	 String dbName=null;
	//generateSpringAPI
	public List<String> generateSpringAPI(GeneratorSpringbootApp generatorspringapp) {
		
		logger.info("Eneter in generateSpringAPI ");
		String directory = generatorspringapp.getDirName()+"\\"+generatorspringapp.getProjectName();
		 
		try {
			
			for(String prePkg : generatorspringapp.getPakgList())
			{
				   String replacevale=directory+"\\src\\main\\java\\";
				   String[] pName=generatorspringapp.getProjectName().split("-");
					String pkgName="com."+generatorspringapp.getOrgName()+"."+pName[0];
					 if(prePkg.equalsIgnoreCase("main")) {					
						 replacevale+="com\\"+generatorspringapp.getOrgName()+"\\"+pName[0];
						if( YbSoftwrtFile.createDir(replacevale)) {
							List<String> crtMainClass=creatingMainClass.createMainClass(pkgName,pName[0]);
							if(!crtMainClass.isEmpty()) {
								generateJavaAPI(replacevale,pName[0]+"Application.java",crtMainClass);
							}							
						}
					 }else  if(prePkg.equalsIgnoreCase("Imp")) {
						 replacevale+="com\\"+generatorspringapp.getOrgName()+"\\"+pName[0]+"\\services\\"+prePkg;						 
						 if( YbSoftwrtFile.createDir(replacevale)) {
					         createAPIObjects(generatorspringapp,prePkg,replacevale,pkgName);
						 }
						 
					 }  else {
						 replacevale+="com\\"+generatorspringapp.getOrgName()+"\\"+pName[0]+"\\"+prePkg;						 
						 if( YbSoftwrtFile.createDir(replacevale)) {
					         createAPIObjects(generatorspringapp,prePkg,replacevale,pkgName);
						 }
			        }
				 
			}			  
			if(generatorspringapp !=null && generatorspringapp.getBuildName().equalsIgnoreCase("maven")) {
				String[] pName=generatorspringapp.getProjectName().split("-");
				String pkgName="com."+generatorspringapp.getOrgName()+"."+pName[0];
				dbName=generatorspringapp.getDataBase();
				List<String> mavenCreate=createMaven.createMaven(dbName,pkgName,generatorspringapp.getProjectName(),generatorspringapp.getApplicationV(),generatorspringapp.getJavaVesrion(),generatorspringapp.getsPringBootV());				
				 if(!mavenCreate.isEmpty()) {
					 generateFileList=generateJavaAPI(directory+"\\","pom.xml", mavenCreate);
				 }	
				
			}		
				
			 if(!generatorspringapp.getApplictionProInput().isEmpty()) {
				 dbName=generatorspringapp.getDataBaseName();
				 String db=generatorspringapp.getDataBase();
				 generatorspringapp.getApplictionProInput().forEach((applicationProData)->{	
							createFileList=createApplicationProty.createApplicationPro(db,dbName,generatorspringapp.getProjectName(), applicationProData.getDriverName(), applicationProData.getUrl(), applicationProData.getUserName(), applicationProData.getPassword(), applicationProData.getPort());
							String replacevale=directory+"\\src\\main\\resource\\";
							if(!createFileList.isEmpty()) {
								 if( YbSoftwrtFile.createDir(replacevale)) {
								      generateJavaAPI(directory+"\\src\\main\\resource\\" ,"application.yml", createFileList); 
								 }
							}
							
			    });
			 }	
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return generateFileList;
		
		
	}
	
	public void createAPIObjects(GeneratorSpringbootApp generatorspringapp,String prePkg,String replacevale,String pkgName) {
		 dbName=generatorspringapp.getDataBase();
		if(generatorspringapp !=null) {		
		 if(prePkg.equals("model")) {
			   generatorspringapp.getProjectModelInput().forEach((modelData) -> {
					  modelData.getData().forEach((K,V)->{ 						 
						  createFile=createMethod.createMethodName(K)+".java";
						   modelName.add(createMethod.createMethodName(K));
						   modelDataValue=modelData.getData();
					       createFileList=crtModel.createModel(K,V,dbName,pkgName);
					    generateFileList=generateJavaAPI( replacevale, createFile, createFileList);
					  
					  });
		  
			   });
		 }
          if(prePkg.equals("repository")) {
        	
        	 modelName.forEach((model)->{
        		 repositoryName=model+"repository";
            	 createFile=repositoryName+".java";
            	 Map<String,String> pramlist=new HashMap<String, String>();
            	 pramlist.put("List<String>", "list");
            	 String methodName="findBy"+model;
            	
        	     createFileList=crtRepository.createRepository(repositoryName,model,methodName,pramlist,dbName,pkgName,generatorspringapp.getJavaVesrion());        
        	    generateFileList=generateJavaAPI( replacevale, createFile, createFileList);
        	 });
        	
		 }		 
		  if(prePkg.equals("services")) {
			  modelName.forEach((model)->{
				 serViceName=model+"Service";
				 createFile=serViceName+".java";
				 createFileList=crtService.createServices(serViceName,model,generatorspringapp.getSrvModelInput(),dbName,pkgName);
	        	 generateFileList=generateJavaAPI( replacevale, createFile, createFileList);
			  });
			 
		 }
		  if(prePkg.equals("Imp")) {
			  modelName.forEach((model)->{
			 serviceImpName=model+"Service"+prePkg;
			 createFile=serviceImpName+".java";
			 createFileList=crtserviceImp.createServiceImp(serviceImpName, model+"Service", model+"repository",model,generatorspringapp.getServiceImplInput(),modelDataValue,dbName,pkgName);
        	 generateFileList=generateJavaAPI( replacevale, createFile, createFileList);
			  });
		 }
		  if(prePkg.equals("rest")) {
			  modelName.forEach((model)->{
		  
			 generatorspringapp.getControllerInput().forEach((controllerData)->{
					controllerData.getMethoddefine().forEach((K,V)->{
			            createFile=model+"controller.java";
						createFileList=crtController.createController(model+"controller",model+"Service",controllerData,model,dbName,pkgName);
						generateJavaAPI(replacevale ,createFile, createFileList); });
					});
		 
		  });
		 }
		}
	}
	
	public List<String>  generateJavaAPI(String replacevale,String createFile,List<String> createFileList){
		
		return YbSoftwrtFile.filesWriting(replacevale, createFile, createFileList, false);
	}

	


}
