package com.project.generator.util;

import org.springframework.stereotype.Component;

@Component
public class CreateMethodName {
	
public String createMethodName(String modelName) {
		
		String fCapital = modelName.substring(0, 1).toUpperCase();
		
		return fCapital+modelName.substring(1).toLowerCase();
	}

}
