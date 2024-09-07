package com.project.generator.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.GeneratorNodejsApp;
import com.project.generator.services.GeneratorNodeJsAppService;
import com.project.generator.util.CreateNodeAPI;


@Component
public class GeneratorNodeJsServiceImp implements GeneratorNodeJsAppService {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorNodeJsServiceImp.class);
	
      
	@Autowired
	CreateNodeAPI createnodeApi;
	
	

	@Override
	public List<String> createNodeJsAppProject(GeneratorNodejsApp generatornodejsapp) {
		
		return createnodeApi.generateNodeApi(generatornodejsapp);
	}



}

