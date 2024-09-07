package com.project.generator.model;

import org.springframework.stereotype.Component;
@Component

public class ProjectApplicationPro {
	
	 
		
	private String driverName;
	private String  url;
	private String  userName;
	private String  password;
	private String  port;

	
	
	/**
	 * 
	 */
	public ProjectApplicationPro() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}



	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}



	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}



	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	

	
	

}
