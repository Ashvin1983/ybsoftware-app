package com.project.generator.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component

public class ProjectCommandLine {
	
	 
		
	private String commandLine;
	private String  dirPath;

	private List<String> project_creation_details; 
	
	/**
	 * 
	 */
	public ProjectCommandLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @return the commandLine
	 */
	public String getCommandLine() {
		return commandLine;
	}



	/**
	 * @param commandLine the commandLine to set
	 */
	public void setCommandLine(String commandLine) {
		this.commandLine = commandLine;
	}



	/**
	 * @return the dirPath
	 */
	public String getDirPath() {
		return dirPath;
	}

	/**
	 * @param dirPath the dirPath to set
	 */
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	/**
	 * @return the project_creation_details
	 */
	public List<String> getProject_creation_details() {
		return project_creation_details;
	}

	/**
	 * @param project_creation_details the project_creation_details to set
	 */
	public void setProject_creation_details(List<String> project_creation_details) {
		this.project_creation_details = project_creation_details;
	}
	
	

}
