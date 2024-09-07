package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.projectServiceImpModel;

@Component
public class CreatingServicesImp {
	@Autowired
	CreateMethodName createMethod;

	public List<String> createServiceImp(String objectName, String serviceObjName, String repositryObjName,
			String modelName, List<projectServiceImpModel> proSrvImpmodel,Map<String,Map<String,String>> modelData,String dbName,String pkgName) {
		List<String> serviceImpHeader = new ArrayList<String>();
		serviceImpHeader.add("package   "+pkgName+".services.Imp;");
		serviceImpHeader.add("import java.util.*;");
		serviceImpHeader.add("import java.io.*;");
		serviceImpHeader.add("import org.springframework.stereotype.*;");
		serviceImpHeader.add("import org.springframework.beans.factory.annotation.*;");
		serviceImpHeader.add("import "+pkgName+".model.*;");
		serviceImpHeader.add("import "+pkgName+".services.*;");
		serviceImpHeader.add("import "+pkgName+".repository.*;");
		serviceImpHeader.add(" ");
		serviceImpHeader.add(" ");
		serviceImpHeader.add("@Component");
		serviceImpHeader.add("public class" + " " + objectName + " " + "implements" + " " + serviceObjName + "{");
		serviceImpHeader.add(" ");
		serviceImpHeader.add(" ");
		serviceImpHeader.add("      @Autowired");
		serviceImpHeader.add("      public" + " " + repositryObjName + "  " + repositryObjName.toLowerCase() + ";");
		serviceImpHeader.add(" ");
		serviceImpHeader.add(" ");
		proSrvImpmodel.forEach((serviceImp) -> {
			createServiceIMpMethod(serviceImp, modelName,modelData,dbName).forEach((serviceImpData) -> {
				serviceImpHeader.add(serviceImpData);
			});
		});
		serviceImpHeader.add(" ");
		serviceImpHeader.add(" ");
		return serviceImpHeader;

	}

	public List<String> createServiceIMpMethod(projectServiceImpModel proSrvImpmodel, String modelName,Map<String,Map<String,String>> modelData,String dbName) {
		List<String> createsrvImpMethodlist = new ArrayList<>();
		List<String> createsrvImpMethodData = new ArrayList<>();

		for (Map.Entry<String, Map<String, String>> methodType : proSrvImpmodel.getMethoddefine().entrySet()) {
			for (Map.Entry<String, String> methodval : methodType.getValue().entrySet()) {

				if (methodType.getKey().equalsIgnoreCase("post")) {

					createsrvImpMethodData = createPostMeThod(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName));
				}
				if (methodType.getKey().equalsIgnoreCase("get")) {

					createsrvImpMethodData = createGetMethod(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName));
					
				}
				if (methodType.getKey().equalsIgnoreCase("getById")) {
					createsrvImpMethodData =createGetMethodById(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName),dbName);
				}
				if (methodType.getKey().equalsIgnoreCase("put")) {

					createsrvImpMethodData = createPutMethod(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName),modelData,dbName);
				}
				if (methodType.getKey().equalsIgnoreCase("delete")) {

					createsrvImpMethodData = createDeletMethod(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName));
				}
				if (methodType.getKey().equalsIgnoreCase("deleteById")) {

					createsrvImpMethodData = createDeletMethodById(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proSrvImpmodel.getMethodLogic().get(methodType.getKey()), modelName),dbName);
				}
			}
			createsrvImpMethodData.forEach((methodData) -> createsrvImpMethodlist.add(methodData));
		}

		return createsrvImpMethodlist;

	}

	public List<String> getMethodLogic(Map<String, String> methodLoic, String passMethodType) {

		List<String> methodlogicConstruct = new ArrayList<>();

		String metodlgc = methodLoic.get(passMethodType);
		methodlogicConstruct.add(metodlgc);

		return methodlogicConstruct;

	}

	public List<String> createPostMeThod(String methodName, String returnType, List<String> methodlogic) {

		List<String> createPostMeThod = new ArrayList<>();

		createPostMeThod.add(" ");		
		createPostMeThod.add("   public " +  createMethod.createMethodName(returnType)  + " " + "create" + createMethod.createMethodName(returnType) +"(" + " " + createMethod.createMethodName(returnType) + " "
				+ returnType.toLowerCase() + ")");
		createPostMeThod.add("    {");			
		createPostMeThod.add("     "+createMethod.createMethodName(returnType)  + "  " + returnType + "mdl=null;");
		createPostMeThod.add("     if(" + returnType + "!=null)");
		createPostMeThod.add("     {");
		createPostMeThod.add("         " + returnType + "mdl=" + returnType + "repository.save(" + returnType+");");	
		createPostMeThod.add("     }");		
		createPostMeThod.add("  return" + " " + returnType + "mdl;");
		createPostMeThod.add("}");
		
		return createPostMeThod;

	}

	public List<String> createGetMethod(String methodName, String returnType, List<String> methodlogic) {
		List<String> gettMethod = new ArrayList<>();

		gettMethod.add("");
		gettMethod.add("");
		gettMethod.add("    public List<" +  createMethod.createMethodName(returnType)  + "> " + "get" + createMethod.createMethodName(returnType) + "All()");
		gettMethod.add("     {");
		gettMethod.add("   ");		
		gettMethod.add("         List<" +  createMethod.createMethodName(returnType)  + "> " + returnType + "mdl=new ArrayList<>();");	
		gettMethod.add("              for("+createMethod.createMethodName(returnType)+" "+ returnType + "mdls:" + returnType + "repository.findAll())");
		gettMethod.add("              {");		
		gettMethod.add("                " + returnType + "mdl.add(" + returnType + "mdls);");		
		gettMethod.add("               }");
		gettMethod.add("      return  " + returnType + "mdl;");
		gettMethod.add("      ");
		gettMethod.add("      }");
		
		return gettMethod;

	}
	public List<String> createGetMethodById(String methodName, String returnType, List<String> methodlogic,String dbName) {
		List<String> gettMethod = new ArrayList<>();
		
		gettMethod.add(" ");
		if(dbName.equalsIgnoreCase("mongo")) {
			gettMethod.add("    public " +  createMethod.createMethodName(returnType)  + " " + "get" + createMethod.createMethodName(returnType) + "ById(String id)");
		}else {
			gettMethod.add("    public " +  createMethod.createMethodName(returnType)  + " " + "get" + createMethod.createMethodName(returnType) + "ById(long id)");
		}
		gettMethod.add("     {");		
		gettMethod.add("         " +  createMethod.createMethodName(returnType)  + "  " + returnType + "mdl=null;");	
		gettMethod.add("               Optional<" +  createMethod.createMethodName(returnType)  +">   "+ returnType.toLowerCase() +"Data =" + returnType + "repository.findById(id);");
		gettMethod.add("              ");		
		gettMethod.add("                 if ("+ returnType.toLowerCase() +"Data.isPresent()) {  ");	
		gettMethod.add("                      " + returnType +"mdl="+returnType.toLowerCase() +"Data.get();");
		gettMethod.add("                      return " + returnType + "mdl;");
		gettMethod.add("                 }");
		gettMethod.add("        return null;");
		gettMethod.add("      ");
		gettMethod.add("      }");
		
		return gettMethod;

	}
	public List<String> createPutMethod(String methodName, String returnType, List<String> methodlogic,Map<String,Map<String,String>> modelData ,String dbName) {

		List<String> putMethod = new ArrayList<>();
		putMethod.add("  ");
		if(dbName.equalsIgnoreCase("mongo")) {
			putMethod.add("   public " +  createMethod.createMethodName(returnType)  + "   " +"update"+createMethod.createMethodName(returnType) + "(" + " " + createMethod.createMethodName(returnType) + " "
				+ returnType.toLowerCase() + ",String id)");
		}else {
			putMethod.add("   public " +  createMethod.createMethodName(returnType)  + "   " +"update"+createMethod.createMethodName(returnType) + "(" + " " + createMethod.createMethodName(returnType) + " "
					+ returnType.toLowerCase() + ",long id)");
		}
		putMethod.add("    {");
		putMethod.add("   ");		
		putMethod.add("       " + createMethod.createMethodName(returnType)  + "  " + returnType + "mdl=get" + createMethod.createMethodName(returnType) + "ById(id);");
		putMethod.add("       if(" + returnType + "!=null)");
		putMethod.add("       {");
		modelData.forEach((K,V) -> {
			if(K.equalsIgnoreCase(returnType))
			V.forEach((Key,Val)->{
				putMethod.add("          " + returnType +"mdl.set"+createMethod.createMethodName(Key) +"("+returnType+".get"+createMethod.createMethodName(Key)+"());");
			});
		
		});		
		putMethod.add("             " + returnType + "repository.save(" + returnType + "mdl);");				
		putMethod.add("       }");
		putMethod.add("   return" + "   " + returnType.toLowerCase() + ";");		
		putMethod.add("   }");
		
		return putMethod;

	}
	

	public List<String> createDeletMethod(String methodName, String returnType, List<String> methodlogic) {
		List<String> deletMethod = new ArrayList<>();


		deletMethod.add(" ");
		deletMethod.add("   public " +  createMethod.createMethodName(returnType)  + "  " + "delete" + createMethod.createMethodName(returnType) + "(" + " " + createMethod.createMethodName(returnType) + " "+ returnType.toLowerCase() + ")");
		deletMethod.add("  {");			
		deletMethod.add("      " +  createMethod.createMethodName(returnType)  + "   " + returnType + "mdl=null;");		
		deletMethod.add("           if(" + returnType + "!=null)");
		deletMethod.add("           {");				
		deletMethod.add("                " +  returnType + "repository.delete(" + returnType + ");");
		deletMethod.add(" ");
		deletMethod.add("                " + returnType + "mdl="+returnType+";");		
		deletMethod.add("           }");		
		deletMethod.add("  return" + " " + returnType + "mdl;");
		deletMethod.add("}");
		
		
		return deletMethod;

	}
	public List<String> createDeletMethodById(String methodName, String returnType, List<String> methodlogic,String dbName) {
		List<String> deletMethod = new ArrayList<>();

		deletMethod.add(" ");
		if(dbName.equalsIgnoreCase("mongo")) {
			deletMethod.add("   public  void  " + "delete" + createMethod.createMethodName(returnType) + "ById(String id)");
		}else {
			deletMethod.add("   public  void  " + "delete" + createMethod.createMethodName(returnType) + "ById(long id)");
		}
		deletMethod.add("   {");		
		deletMethod.add("                " +  returnType + "repository.deleteById(id);");		
		deletMethod.add("    }");		
		return deletMethod;

	}
	
	
}
