package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.projectControllerModel;

@Component
public class CreatingController {
	@Autowired
	CreateMethodName createMethod;

	public List<String> createController(String controllerName, String serviceName,
			projectControllerModel proContrlermodel, String modelName,String dbName,String pkgName) {

		List<String> controllerHeader = new ArrayList<String>();
		controllerHeader.add("package  " +pkgName+".rest;");
		controllerHeader.add("import org.springframework.web.bind.annotation.*;");
		controllerHeader.add("import java.util.*;");
		controllerHeader.add("import org.springframework.stereotype.*;");
		controllerHeader.add("import org.springframework.beans.factory.annotation.*;");
		controllerHeader.add("import org.springframework.http.*;");
		controllerHeader.add("import "+pkgName+".model.*;");
		controllerHeader.add("import "+pkgName+".services.*;");
		controllerHeader.add("import "+pkgName+".services.Imp.*;");
		controllerHeader.add(" ");
		controllerHeader.add(" ");
		controllerHeader.add(" @RestController");	
		controllerHeader.add(" @RequestMapping(\""+"/api" + "\")");
		controllerHeader.add(" @CrossOrigin(origins =" + "\"*" + "\")");
		controllerHeader.add(" public class" + " " + controllerName + "{");
		controllerHeader.add(" ");
		controllerHeader.add(" ");
		controllerHeader.add("      @Autowired");
		controllerHeader.add("      public" + " " + serviceName + "  " + serviceName.toLowerCase() + ";");
		controllerHeader.add(" ");
		controllerHeader.add(" ");
		createControllerMethod(proContrlermodel, modelName,dbName).forEach((controllerCreation) -> {
			controllerHeader.add(controllerCreation);
		});
		controllerHeader.add(" ");
		controllerHeader.add(" ");
		return controllerHeader;

	}

	public List<String> createControllerMethod(projectControllerModel proContrlermodel, String modelName,String dbName) {
		List<String> createControllerMethodlist = new ArrayList<>();
		List<String> createControllerMethodData = new ArrayList<>();

		for (Map.Entry<String, Map<String, String>> methodType : proContrlermodel.getMethoddefine().entrySet()) {
			for (Map.Entry<String, String> methodval : methodType.getValue().entrySet()) {

				if (methodType.getKey().equalsIgnoreCase("post")) {

					createControllerMethodData = createPostMapping(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()),modelName));
				}
				if (methodType.getKey().equalsIgnoreCase("get")) {

					createControllerMethodData = createGetMapping(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()), modelName));
				}
				if (methodType.getKey().equalsIgnoreCase("getById")) {

					createControllerMethodData = createGetMappingById(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()), modelName),dbName);
				}
				if (methodType.getKey().equalsIgnoreCase("put")) {

					createControllerMethodData = createPutMapping(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()), modelName),dbName);
				}
				if (methodType.getKey().equalsIgnoreCase("delete")) {

					createControllerMethodData = createDeleteMapping(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()), modelName));
				}
				if (methodType.getKey().equalsIgnoreCase("deleteById")) {

					createControllerMethodData = createDeleteByIdMapping(methodType.getValue().get(modelName), modelName.toLowerCase(),
							getMethodLogic(proContrlermodel.getMethodLogic().get(methodType.getKey()), modelName),dbName);
				}
			}
			createControllerMethodData.forEach((methodData) -> createControllerMethodlist.add(methodData));
		}

		return createControllerMethodlist;

	}

	public List<String> getMethodLogic(Map<String, String> methodLogic, String passMethodType) {

		List<String> methodlogicConstruct = new ArrayList<>();
		String logicValue = methodLogic.get(passMethodType);
		methodlogicConstruct.add(logicValue);

		return methodlogicConstruct;

	}

	public List<String> createPostMapping(String methodName, String returnType , List<String> methodlogic) {

		List<String> postMapping = new ArrayList<>();
		postMapping.add(" ");		
		postMapping.add("   @PostMapping(\"/" + returnType + "/create\")");
		postMapping.add("   public ResponseEntity<" + createMethod.createMethodName(returnType) + ">" +"  " +"create"+createMethod.createMethodName(returnType)  + "(@RequestBody" + " "
				+ createMethod.createMethodName(returnType) + " " + returnType+ ")");
		postMapping.add("    {");
		postMapping.add("      try { ");
		postMapping.add("          " + createMethod.createMethodName(returnType) + " " + returnType + "mdl=null;");
		postMapping.add("              if(" + returnType + "!=null)");
		postMapping.add("               {");
		postMapping.add("                  " + returnType + "mdl=" + returnType + "service.create" + createMethod.createMethodName(returnType) + "("+ returnType + ");");
		postMapping.add("  ");
		postMapping.add("                }");		
		postMapping.add("                return new " +" "+"ResponseEntity<>("+returnType +"mdl,HttpStatus.CREATED);");
		postMapping.add("            } catch (Exception e) {");
		postMapping.add("                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);");	  
		postMapping.add("            }");
		postMapping.add("     }");
		return postMapping;

	}


	public List<String> createGetMapping(String methodName, String returnType, List<String> methodlogic) {
		List<String> gettMapping = new ArrayList<>();

		gettMapping.add("  ");		
		gettMapping.add("    @GetMapping(\"/" + returnType + "/data\")");
		gettMapping.add("    public ResponseEntity<List<" + createMethod.createMethodName(returnType) + ">> " +" "+"get" + createMethod.createMethodName(returnType) + "()");
		gettMapping.add("     {");
		gettMapping.add("      try {");		
		gettMapping.add("               List<"+ createMethod.createMethodName(returnType) + "> " + returnType + "mdl="+returnType + "service.get"+createMethod.createMethodName(returnType)+"All();");				
		gettMapping.add("           ");		
		gettMapping.add("                return new " +" "+"ResponseEntity<>("+returnType +"mdl,HttpStatus.OK);");
		gettMapping.add("            } catch (Exception e) {");
		gettMapping.add("                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);");	  
		gettMapping.add("            }");
		gettMapping.add("     }");
		

		return gettMapping;

	}
	public List<String> createGetMappingById(String methodName, String returnType, List<String> methodlogic,String dbName) {
		List<String> gettMapping = new ArrayList<>();

		gettMapping.add("  ");		
		gettMapping.add("    @GetMapping(\"/" + returnType + "/data/{id}\")");
		if(dbName.equalsIgnoreCase("mongo")) {
			gettMapping.add("    public ResponseEntity<" + createMethod.createMethodName(returnType) + "> " + " "+"get" + createMethod.createMethodName(returnType) + "ById(@PathVariable(\"id\") String id)");
		}else {
			gettMapping.add("    public ResponseEntity<" + createMethod.createMethodName(returnType) + "> " + " "+"get" + createMethod.createMethodName(returnType) + "ById(@PathVariable(\"id\") long id)");
		}
		gettMapping.add("     {");
		gettMapping.add("      try {");		
		gettMapping.add("               "+ createMethod.createMethodName(returnType) + " " + returnType + "mdl="+returnType + "service.get"+createMethod.createMethodName(returnType)+"ById(id);");			
		gettMapping.add("                return new " +" "+"ResponseEntity<>("+returnType +"mdl,HttpStatus.OK);");
		gettMapping.add("            } catch (Exception e) {");
		gettMapping.add("                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);");	  
		gettMapping.add("            }");
		gettMapping.add("     }");
		

		return gettMapping;

	}
	public List<String> createPutMapping(String methodName, String returnType, List<String> methodlogic,String dbName) {

		List<String> putMapping = new ArrayList<>();
		putMapping.add("  ");		
		putMapping.add("   @PutMapping(\"/" + returnType + "/update/{id}\")");
		if(dbName.equalsIgnoreCase("mongo")) {
			putMapping.add("   public ResponseEntity<" + createMethod.createMethodName(returnType)  + "> " +" "+"update" + createMethod.createMethodName(returnType) + "(@PathVariable(\"id\") String id, @RequestBody" + " "
				+ createMethod.createMethodName(returnType) + " " + returnType.toLowerCase() + ")");
		}else {
			putMapping.add("   public ResponseEntity<" + createMethod.createMethodName(returnType)  + "> " +" "+"update" + createMethod.createMethodName(returnType) + "(@PathVariable(\"id\") long id, @RequestBody" + " "
					+ createMethod.createMethodName(returnType) + " " + returnType.toLowerCase() + ")");
		}
		putMapping.add("      {");
		putMapping.add("        ");
		putMapping.add("         " + createMethod.createMethodName(returnType) + "\t" + returnType + "mdl=null;");
		putMapping.add("              if(" + returnType + "!=null)");
		putMapping.add("              {");
		putMapping.add("                 " + returnType + "mdl=" + returnType + "service.update" + createMethod.createMethodName(returnType) + "("+ returnType + ",id);");	
		putMapping.add("                  return  new" + "  "+" ResponseEntity<>(" + returnType + "mdl,HttpStatus.OK"+");");	
		putMapping.add("               }else{");		
		putMapping.add("                  return  new" + "  "+" ResponseEntity<>(" + returnType + "mdl,HttpStatus.NOT_FOUND"+");");		
		putMapping.add("             }");
		putMapping.add("}");

		return putMapping;

	}

	public List<String> createDeleteMapping(String methodName, String returnType, List<String> methodlogic) {
		List<String> deletMapping = new ArrayList<>();	
				
		deletMapping.add("   @DeleteMapping(\"/" + returnType + "/delete\")");
		deletMapping.add("   public ResponseEntity<" + createMethod.createMethodName(returnType) + ">" + " "+"delete" + createMethod.createMethodName(returnType) + "(@RequestBody" + " "
				+ createMethod.createMethodName(returnType)  + " " + returnType.toLowerCase() + ")");		;
		deletMapping.add("   {");
		deletMapping.add("      try{");	
		deletMapping.add("          " + createMethod.createMethodName(returnType) + " " + returnType + "mdl=null;");
		deletMapping.add("          if(" + returnType + "!=null)");
		deletMapping.add("          {");
		deletMapping.add("            " + returnType + "mdl=" + returnType + "service.delete" + createMethod.createMethodName(returnType) + "("+ returnType + ");");		
		deletMapping.add("          }");		
		deletMapping.add("            return  new"+ " "+" ResponseEntity<>(" + returnType + "mdl,HttpStatus.NO_CONTENT);");
		deletMapping.add("        } catch (Exception e) {");
		deletMapping.add("            return  new"+ " "+" ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);");
		deletMapping.add("        }");
		deletMapping.add("    }");

		return deletMapping;

	}
	public List<String> createDeleteByIdMapping(String methodName, String returnType, List<String> methodlogic,String dbName) {
		List<String> deletMapping = new ArrayList<>();	
		
		deletMapping.add("    @DeleteMapping(\"/delete/" + returnType + "/{id}\")");
		if(dbName.equalsIgnoreCase("mongo")) {
			deletMapping.add("   public ResponseEntity "+"<HttpStatus>"+ " "+"delete" + createMethod.createMethodName(returnType)+"ById(@PathVariable(\"id\") String id)");
		}else {
			deletMapping.add("   public ResponseEntity "+"<HttpStatus>"+ " "+"delete" + createMethod.createMethodName(returnType)+"ById(@PathVariable(\"id\") long id)");
		}
		deletMapping.add("   {");
		deletMapping.add("      try{");			
		deletMapping.add("            " + returnType + "service.delete" + createMethod.createMethodName(returnType)+"ById(id);");					
		deletMapping.add("            return  new "+" "+" ResponseEntity<>(HttpStatus.NO_CONTENT);");
		deletMapping.add("        } catch (Exception e) {");
		deletMapping.add("            return new "+" "+" ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);");
		deletMapping.add("        }");
		deletMapping.add("    }");

		return deletMapping;

	}

}
