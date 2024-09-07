package com.project.generator.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.GeneratorSpringbootApp;
import com.project.generator.services.GeneratorSpringbootAppService;
import com.project.generator.util.CreatingAPI;


@Component
public class GeneratorSpringbootServiceImp implements GeneratorSpringbootAppService {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorSpringbootServiceImp.class);
	
      
	@Autowired
	CreatingAPI createApi;
	
	@Override		
	public List<String> createSpringbootAppProject(GeneratorSpringbootApp generatorspringapp) {
		
	
		
		return createApi.generateSpringAPI(generatorspringapp);
		
		     
	}



}

