package com.project.generator.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Yajat
 *
 */

@Component
public class NodJsprojectModel {

	
	public Map<String,Map<String,Map<String,String>>>  createApidata;
	public String port;
	public String dbconnectionUrl;
	public String apiUrl;
	
	
	
	
	/**
	 * @return the createApidata
	 */
	public Map<String, Map<String, Map<String, String>>> getCreateApidata() {
		return createApidata;
	}
	/**
	 * @param createApidata the createApidata to set
	 */
	public void setCreateApidata(Map<String, Map<String, Map<String, String>>> createApidata) {
		this.createApidata = createApidata;
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
	/**
	 * @return the dbconnectionUrl
	 */
	public String getDbconnectionUrl() {
		return dbconnectionUrl;
	}
	/**
	 * @param dbconnectionUrl the dbconnectionUrl to set
	 */
	public void setDbconnectionUrl(String dbconnectionUrl) {
		this.dbconnectionUrl = dbconnectionUrl;
	}
	/**
	 * @return the apiUrl
	 */
	public String getApiUrl() {
		return apiUrl;
	}
	/**
	 * @param apiUrl the apiUrl to set
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	
	
}

