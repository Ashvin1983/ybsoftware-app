package com.project.generator.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Yajat
 *
 */

@Component
public class projectControllerModel {

	
	 

	public  Map<String,Map<String,String>> methoddefine;	
	public  Map<String,Map<String,String>>  methodLogic;
	public String conrollerName;
	public projectControllerModel() {}


	/**
	 * @return the methoddefine
	 */
	public Map<String, Map<String, String>> getMethoddefine() {
		return methoddefine;
	}


	/**
	 * @param methoddefine the methoddefine to set
	 */
	public void setMethoddefine(Map<String, Map<String, String>> methoddefine) {
		this.methoddefine = methoddefine;
	}


	


	/**
	 * @return the methodLogic
	 */
	public Map<String, Map<String, String>> getMethodLogic() {
		return methodLogic;
	}


	/**
	 * @param methodLogic the methodLogic to set
	 */
	public void setMethodLogic(Map<String, Map<String, String>> methodLogic) {
		this.methodLogic = methodLogic;
	}


	/**
	 * @return the conrollerName
	 */
	public String getConrollerName() {
		return conrollerName;
	}


	/**
	 * @param conrollerName the conrollerName to set
	 */
	public void setConrollerName(String conrollerName) {
		this.conrollerName = conrollerName;
	}






	
	
}

