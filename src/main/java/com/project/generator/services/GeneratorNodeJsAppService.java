package com.project.generator.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectWriter.GeneratorSettings;
import com.project.generator.model.GeneratorNodejsApp;
import com.project.generator.model.GeneratorSpringbootApp;
import com.project.generator.model.projectGenerator;

@Service
@Component
public interface GeneratorNodeJsAppService {

	public List<String> createNodeJsAppProject(GeneratorNodejsApp generatornodejsapp);
	
	
	

}

