package com.project.generator.util.config;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("ysoft")
public class YbSoftJavaConfig {

	@Value("${ysoft.targate.javaModeldir}")
	private String java_model_dir;
	
	@Value("${ysoft.targate.javaRestdir}")
	private String java_rest_dir;
	
	@Value("${ysoft.targate.javaServicesdir}")
	private String java_services_dir;
	
	@Value("${ysoft.targate.javaServiceImpdir}")
	private String java_serviceImp_dir;
	
	@Value("${ysoft.jFile.model}")
	private String java_model_obj;
	
	@Value("${ysoft.jFile.controller}")
	private String java_rest_obj;
	
	@Value("${ysoft.jFile.service}")
	private String java_services_obj;
	
	@Value("${ysoft.jFile.serviceImp}")
	private String java_serviceImp_obj;
 
	
	private Map<String,String> targate;
	
	private Map<String,String> jFile;
	
	/**
	 * 
	 */
	public YbSoftJavaConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the java_model_dir
	 */
	public String getJava_model_dir() {
		return java_model_dir;
	}

	/**
	 * @param java_model_dir the java_model_dir to set
	 */
	public void setJava_model_dir(String java_model_dir) {
		this.java_model_dir = java_model_dir;
	}

	/**
	 * @return the java_rest_dir
	 */
	public String getJava_rest_dir() {
		return java_rest_dir;
	}

	/**
	 * @param java_rest_dir the java_rest_dir to set
	 */
	public void setJava_rest_dir(String java_rest_dir) {
		this.java_rest_dir = java_rest_dir;
	}

	/**
	 * @return the java_services_dir
	 */
	public String getJava_services_dir() {
		return java_services_dir;
	}

	/**
	 * @param java_services_dir the java_services_dir to set
	 */
	public void setJava_services_dir(String java_services_dir) {
		this.java_services_dir = java_services_dir;
	}

	/**
	 * @return the java_serviceImp_dir
	 */
	public String getJava_serviceImp_dir() {
		return java_serviceImp_dir;
	}

	/**
	 * @param java_serviceImp_dir the java_serviceImp_dir to set
	 */
	public void setJava_serviceImp_dir(String java_serviceImp_dir) {
		this.java_serviceImp_dir = java_serviceImp_dir;
	}

	/**
	 * @return the java_model_obj
	 */
	public String getJava_model_obj() {
		return java_model_obj;
	}

	/**
	 * @param java_model_obj the java_model_obj to set
	 */
	public void setJava_model_obj(String java_model_obj) {
		this.java_model_obj = java_model_obj;
	}

	/**
	 * @return the java_rest_obj
	 */
	public String getJava_rest_obj() {
		return java_rest_obj;
	}

	/**
	 * @param java_rest_obj the java_rest_obj to set
	 */
	public void setJava_rest_obj(String java_rest_obj) {
		this.java_rest_obj = java_rest_obj;
	}

	/**
	 * @return the java_services_obj
	 */
	public String getJava_services_obj() {
		return java_services_obj;
	}

	/**
	 * @param java_services_obj the java_services_obj to set
	 */
	public void setJava_services_obj(String java_services_obj) {
		this.java_services_obj = java_services_obj;
	}

	/**
	 * @return the java_serviceImp_obj
	 */
	public String getJava_serviceImp_obj() {
		return java_serviceImp_obj;
	}

	/**
	 * @param java_serviceImp_obj the java_serviceImp_obj to set
	 */
	public void setJava_serviceImp_obj(String java_serviceImp_obj) {
		this.java_serviceImp_obj = java_serviceImp_obj;
	}

	/**
	 * @return the targate
	 */
	public Map<String, String> getTargate() {
		return targate;
	}

	/**
	 * @param targate the targate to set
	 */
	public void setTargate(Map<String, String> targate) {
		this.targate = targate;
	}

	/**
	 * @return the jFile
	 */
	public Map<String, String> getjFile() {
		return jFile;
	}

	/**
	 * @param jFile the jFile to set
	 */
	public void setjFile(Map<String, String> jFile) {
		this.jFile = jFile;
	}

	

	
	

	

	
}