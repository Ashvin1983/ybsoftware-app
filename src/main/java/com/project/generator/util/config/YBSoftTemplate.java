package com.project.generator.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ysoft")
public class YBSoftTemplate {
	
	@Value("${ysoft.element.input}")
	private String element;

	public YBSoftTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(String element) {
		this.element = element;
	}
	
	
}
