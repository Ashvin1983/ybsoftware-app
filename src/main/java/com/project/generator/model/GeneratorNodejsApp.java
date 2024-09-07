package com.project.generator.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Yajat
 *
 */
@Component
public class GeneratorNodejsApp {
    

	public String projectName;
	public String dataBaseName;		
	public  List<NodeJsConfigModel> config;
	public List<NodJsprojectModel>  projectModelInput;	
	public boolean server;
	public boolean packageJson;
	/**
	 * @return the packageJson
	 */
	public boolean isPackageJson() {
		return packageJson;
	}
	/**
	 * @param packageJson the packageJson to set
	 */
	public void setPackageJson(boolean packageJson) {
		this.packageJson = packageJson;
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
	 * @return the projectModelInput
	 */
	@JsonProperty("projectModelInput")
	public List<NodJsprojectModel> getProjectModelInput() {
		return projectModelInput;
	}
	/**
	 * @param projectModelInput the projectModelInput to set
	 */
	@JsonProperty("projectModelInput")
	public void setProjectModelInput(List<NodJsprojectModel> projectModelInput) {
		this.projectModelInput = projectModelInput;
	}
	/**
	 * @return the config
	 */
	@JsonProperty("config")
	public List<NodeJsConfigModel> getConfig() {
		return config;
	}
	/**
	 * @param config the config to set
	 */
	@JsonProperty("config")
	public void setConfig(List<NodeJsConfigModel> config) {
		this.config = config;
	}
	/**
	 * @return the server
	 */
	public boolean isServer() {
		return server;
	}
	/**
	 * @param server the server to set
	 */
	public void setServer(boolean server) {
		this.server = server;
	}
	
	
	
}

