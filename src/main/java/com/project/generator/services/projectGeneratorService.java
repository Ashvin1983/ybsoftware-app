package com.project.generator.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.generator.model.TemplateGenrator;
import com.project.generator.model.projectGenerator;

@Service
@Component
public interface projectGeneratorService {

	public List<String> createProject(projectGenerator prognrt);
	
	public Object createTemplate( TemplateGenrator templateGnrt);
	

}

