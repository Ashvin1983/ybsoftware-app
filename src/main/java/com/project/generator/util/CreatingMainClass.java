package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CreatingMainClass {


	public List<String> createMainClass(String PkgName,String MainClassName) {

		List<String> createMainclassList = new ArrayList<String>();		
		
		createMainclassList.add("package "+PkgName+";");
		createMainclassList.add("import org.springframework.boot.SpringApplication;");
		createMainclassList.add("import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;");
		createMainclassList.add("import org.springframework.context.annotation.ComponentScan;");
		createMainclassList.add("import org.springframework.boot.autoconfigure.SpringBootApplication;");
		createMainclassList.add("@SpringBootApplication");
		createMainclassList.add("@ComponentScan({\""+PkgName+"\"})");
		createMainclassList.add("public class "+MainClassName+"Application {");
		createMainclassList.add(" ");
		createMainclassList.add("    public static void main(String[] args) { ");
		createMainclassList.add("        SpringApplication.run("+MainClassName+"Application.class, args);");
		createMainclassList.add("    }");
		 
		//createMainclassList.add("}");
		
		return createMainclassList;


	}

	
}
