package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatingModel {

	@Autowired
	CreateMethodName createMethod;

	public List<String> createModel(String obJectName, Map<String, String> modelData, String dbName,String pkgName) {

		List<String> modelHeader = new ArrayList<String>();
		StringBuffer constorcterBuffer = new StringBuffer();
		StringBuffer toStringMetodBuffer = new StringBuffer();
		StringBuffer constorcterBufferinsid = new StringBuffer();
		StringBuffer constorcterBufferThis = new StringBuffer();
		StringBuffer toStringMetodBufferInsid = new StringBuffer();
		modelHeader.add("package "+pkgName+".model;");
		modelHeader.add("import java.util.*;");
		modelHeader.add("import org.springframework.stereotype.Component;");

		if (dbName.equalsIgnoreCase("mongo")) {
			modelHeader.add("import org.springframework.data.annotation.Id;");
			modelHeader.add("import org.springframework.data.mongodb.core.index.IndexDirection;");
			modelHeader.add("import org.springframework.data.mongodb.core.index.Indexed;");
			modelHeader.add("import org.springframework.data.mongodb.core.mapping.DBRef;");
			modelHeader.add("import org.springframework.data.mongodb.core.mapping.Document;");
			modelHeader.add(" ");
			modelHeader.add(" ");
			modelHeader.add("@Component");
			modelHeader.add("@Document(collection =\"" + obJectName.toLowerCase() + "\")");
			modelHeader.add("public class" + " " + createMethod.createMethodName(obJectName) + "{");
			modelHeader.add(" ");
			modelHeader.add("@Id");
			modelHeader.add("private String id;");
			modelHeader.add("@Indexed(unique = true, direction = IndexDirection.DESCENDING)");

		} else {
			modelHeader.add("import java.util.Objects;");
			modelHeader.add("import javax.persistence.*;");			
			modelHeader.add(" ");
			modelHeader.add("@Entity");
			modelHeader.add("@Table(name = \"" + obJectName.toLowerCase() + "\")");
			modelHeader.add("public class" + " " + createMethod.createMethodName(obJectName) + "{");
			modelHeader.add(" ");
			modelHeader.add("@Id");
			modelHeader.add("@GeneratedValue(strategy = GenerationType.IDENTITY)");
			modelHeader.add("private Long id;");

		}

		modelHeader.add(" ");
		modelData.forEach((K, V) -> {
			createModelData(K, V, dbName).forEach((data) -> modelHeader.add(data));			
		});
		modelHeader.add("public " + " " + createMethod.createMethodName(obJectName) + "(){}");
		modelHeader.add(" ");
		modelData.forEach((K, V) -> {
			String perameterConstrct =" " + V + " "+ K.toLowerCase() + ",";
			constorcterBufferinsid.append(perameterConstrct);
			constorcterBufferThis.append("     this." + K.toLowerCase() + "=" + K.toLowerCase() + ";\n");

		});
		constorcterBuffer.append("public");
		constorcterBuffer
				.append(" " + createMethod.createMethodName(obJectName) + "(" + constorcterBufferinsid.toString().toString().substring(0, constorcterBufferinsid.toString().toString().length() - 1));
		constorcterBuffer.append("){\n");
		constorcterBuffer.append(constorcterBufferThis.toString());
		constorcterBuffer.append("  }");
		modelHeader.add(constorcterBuffer.toString());
		modelData.forEach((K, V) -> {
			createModelMethod( createMethod.createMethodName(K), V).forEach((data) -> modelHeader.add(data));			

		});		
		modelData.forEach((K, V) -> {
			String perameterConstrct ="\","+ K.toLowerCase()+"=\"+"+ K.toLowerCase() +"+";
			toStringMetodBufferInsid.append(perameterConstrct );
		});	
		toStringMetodBuffer.append("@Override \n");
		toStringMetodBuffer.append("public String toString() { \n return" +" "+ "\""
				+ createMethod.createMethodName(obJectName) + "[id=\"+id+" + toStringMetodBufferInsid.toString().toString().substring(0, toStringMetodBufferInsid.toString().toString().length() - 1)+"+\"]\";");
		toStringMetodBuffer.append("\n  }");
		modelHeader.add(toStringMetodBuffer.toString());
		return modelHeader;

	}

	public List<String> createModelData(String data, String type, String dbtype) {

		List<String> createModelData = new ArrayList<>();
		if (!dbtype.equalsIgnoreCase("mongo")) {
			createModelData.add("  @Column(name = \"" + data.toLowerCase() + "\")");
		}
		createModelData.add("  private " + type + "   " + data.toLowerCase() + ";");
		createModelData.add(" ");

		return createModelData;
	}


	public List<String> createModelMethod(String modelData, String type) {

		List<String> serviceMethod = new ArrayList<>();

		serviceMethod.add("  public" + " " + type + " " + "get" + modelData + "()");
		serviceMethod.add("   {");
		serviceMethod.add("     return" + " " + modelData.toLowerCase() + ";");
		serviceMethod.add("  }");
		serviceMethod.add("   ");		
		serviceMethod.add(
				"  public" + " " + "void " + "set" + modelData + "(" + type + " " + modelData.toLowerCase() + " )");
		serviceMethod.add("  {");
		serviceMethod.add("     this." + modelData.toLowerCase() + "=" + modelData.toLowerCase() + ";");
		serviceMethod.add("  }");
		
	

		return serviceMethod;

	}

	
}
