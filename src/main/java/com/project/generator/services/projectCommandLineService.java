package com.project.generator.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.generator.model.ProjectCommandLine;

@Service
@Component
public interface projectCommandLineService {

	public String projectSSH(ProjectCommandLine procmdLine,String path);
		
	
	
}

