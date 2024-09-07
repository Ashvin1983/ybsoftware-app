package com.project.generator.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Yajat
 *
 */

@Component
public class projectServiceModel {

	

	
	public  Map<String,Map<String,String>> methodcreate;

	/**
	 * @return the methodcreate
	 */
	public Map<String, Map<String, String>> getMethodcreate() {
		return methodcreate;
	}

	/**
	 * @param methodcreate the methodcreate to set
	 */
	public void setMethodcreate(Map<String, Map<String, String>> methodcreate) {
		this.methodcreate = methodcreate;
	}

	
	
	
	
}

