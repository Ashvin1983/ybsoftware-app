package com.project.generator.model;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Yajat
 *
 */

@Component
public class projectModel {

	
	public Map<String,Map<String,String>> data;
	
	public Map<String ,String> relationMapiing;

	/**
	 * @return the relationMapiing
	 */
	public Map<String, String> getRelationMapiing() {
		return relationMapiing;
	}

	/**
	 * @param relationMapiing the relationMapiing to set
	 */
	public void setRelationMapiing(Map<String, String> relationMapiing) {
		this.relationMapiing = relationMapiing;
	}

	/**
	 * @return the data
	 */
	public Map<String, Map<String, String>> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}
	
	

	
	
	
	
}

