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

import com.project.generator.model.TemplateGenrator;
import com.project.generator.model.projectGenerator;
import com.project.generator.services.projectGeneratorService;



@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*")
public class projectGeneratorController {

	@Autowired
	projectGeneratorService progserv;
	List<String> progList;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/Generator")
    public ResponseEntity<List<String>> createProject(@RequestBody projectGenerator prognrt) {
		progList=new ArrayList<String>();
		if(prognrt !=null) {
		
			progList=progserv.createProject(prognrt);
		}
		
        return ResponseEntity.status(HttpStatus.CREATED).body(progList);
    
	
	
	}
	@RequestMapping(method=RequestMethod.POST, value="/Generator/template")
    public ResponseEntity<Object> createTemplate(@RequestBody TemplateGenrator templateGnrt) {
		Object outElment=null;
		if(templateGnrt.getInput() !=null) {
		
			outElment=progserv.createTemplate(templateGnrt);
		}
		
        return ResponseEntity.status(HttpStatus.CREATED).body(outElment);
    
	
	
	}
	
}

