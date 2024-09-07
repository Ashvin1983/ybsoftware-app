package com.project.generator.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Yajat
 *
 */

@Component
public class projectGenerator {

	 
		
	public String projectName;
	public String dataBase;
	public String dataBaseName;
	public String technologyName;	
	public  List<String> output;
	
	
	public projectGenerator() {}
	/**
	 * @param projectName
	 * @param dataBaseName
	 * @param technologyName
	 * @param output
	 */
	public projectGenerator(String projectName, String dataBase, String dataBaseName, String technologyName,
			List<String> output) {		
		this.projectName = projectName;
		this.dataBase = dataBase;
		this.dataBaseName = dataBaseName;
		this.technologyName = technologyName;
		this.output = output;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the dataBaseName
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}
	/**
	 * @param dataBaseName the dataBaseName to set
	 */
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	/**
	 * @return the technologyName
	 */
	public String getTechnologyName() {
		return technologyName;
	}
	/**
	 * @param technologyName the technologyName to set
	 */
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	/**
	 * @return the output
	 */
	public List<String> getOutput() {
		return output;
	}
	/**
	 * @param output the output to set
	 */
	public void setOutput(List<String> output) {
		this.output = output;
	}
	/**
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}
	/**
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	
	
	
}

