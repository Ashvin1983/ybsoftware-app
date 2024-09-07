package com.project.generator.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TemplateGenrator {
	
	String input;
	List<String> createTemplate;

	/**
	 * @return the createTemplate
	 */
	public List<String> getCreateTemplate() {
		return createTemplate;
	}

	public TemplateGenrator() {
		
	}

	public TemplateGenrator(String input, List<String> createTemplate) {
	
		this.input = input;
		this.createTemplate = createTemplate;
	}

	/**
	 * @param createTemplate the createTemplate to set
	 */
	public void setCreateTemplate(List<String> createTemplate) {
		this.createTemplate = createTemplate;
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}
	

}
