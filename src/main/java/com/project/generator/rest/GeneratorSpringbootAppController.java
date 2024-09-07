package com.project.generator.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.generator.model.GeneratorSpringbootApp;
import com.project.generator.services.GeneratorSpringbootAppService;



@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*")
public class GeneratorSpringbootAppController {

	@Autowired
	GeneratorSpringbootAppService generatorSprAppserv;
	
	List<String> appFileList;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/generator/springboot/app")
    public ResponseEntity<List<String>> createSpringbootProject(@RequestBody GeneratorSpringbootApp generatorspringapp) {
		appFileList=new ArrayList<String>();
		if(generatorspringapp !=null) {
		
			appFileList=generatorSprAppserv.createSpringbootAppProject(generatorspringapp);
		}
		
        return ResponseEntity.status(HttpStatus.CREATED).body(appFileList);
	
	}
	
}

