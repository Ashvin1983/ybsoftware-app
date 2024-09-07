package com.project.generator.services.Imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.TemplateGenrator;
import com.project.generator.model.projectGenerator;
import com.project.generator.services.projectGeneratorService;
import com.project.generator.util.config.YBSoftTemplate;
import com.project.generator.util.config.YbSoftConfig;

@Component
public class projectGeneratorServiceImp implements projectGeneratorService {
	private static final Logger logger = LoggerFactory.getLogger(projectGeneratorServiceImp.class);
	@Autowired
	YbSoftConfig config;

	@Autowired
	projectGenerator progn;
	@Autowired
	TemplateGenrator tempGnrt;
	String command;
	String projectDirctory;
	
	@Autowired
	YBSoftTemplate ybsoftTmp;

	@Override

	public List<String> createProject(projectGenerator prognrt) {
		List<String> listOutput = new ArrayList<>();
		logger.info("Enter in createProject");
		String replacevale = "E:\\YbSoft";

		if (prognrt.getTechnologyName().equalsIgnoreCase(config.getApplication_angular())) {
			command = "cd \"" + replacevale + "\"  && " + config.getCommand_angular() + " " + "new" + " "
					+ prognrt.getProjectName();
			logger.info("Creating command for you" + "" + command);
		} else if (prognrt.getTechnologyName().equalsIgnoreCase(config.getApplication_react())) {

			command = "cd \"" + replacevale + "\"  && " + config.getCommand_react() + "  " + prognrt.getProjectName();
			logger.info("Creating command for you" + "" + command);
		}

		if (processCmd(command)) {
			projectDirctory = replacevale + "\\" + prognrt.getProjectName();
			listOutput.add(projectDirctory);
		}
		return listOutput;

	}

	@Override
	public Object createTemplate(TemplateGenrator templateGnrt) {

		Object  listOutput=null;
		if(templateGnrt.getInput()!=null) {
				listOutput=ybsoftTmp.getElement();
				listOutput="<input type=\"text\" id=\"name\" name=\"name\" required minlength=\"4\" maxlength=\"8\" size=\"10\" />";
		}

		return listOutput;
	}

	public boolean processCmd(String command) {
		boolean cmdCompleted = false;
		try {

			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
			builder.redirectErrorStream(true);
			Process process = builder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				cmdCompleted = true;
			}
			

		} catch (InterruptedException ex) {
			logger.info("IOException command for you" + "" + command + "" + ex.fillInStackTrace());
		} catch (IOException e) {
			logger.info("IOException command for you" + "" + command + "" + e.fillInStackTrace());
		}
		return cmdCompleted;
	}
}
