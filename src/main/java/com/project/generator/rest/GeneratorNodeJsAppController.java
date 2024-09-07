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

import com.project.generator.model.GeneratorNodejsApp;
import com.project.generator.services.GeneratorNodeJsAppService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*")
public class GeneratorNodeJsAppController {

	@Autowired
	GeneratorNodeJsAppService generatorNodejsAppserv;
	
	List<String> appFileList;
	

	@RequestMapping(method=RequestMethod.POST, value="/generator/nodejs/app")
    public ResponseEntity<List<String>> createNodjsProject(@RequestBody GeneratorNodejsApp  generatorNodeJsapp) {
		appFileList=new ArrayList<String>();
		if(generatorNodeJsapp !=null) {
		
			appFileList=generatorNodejsAppserv.createNodeJsAppProject(generatorNodeJsapp);
		}
		
        return ResponseEntity.status(HttpStatus.CREATED).body(appFileList);
    
	
	
	}
	
}
