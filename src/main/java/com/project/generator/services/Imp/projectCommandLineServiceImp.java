package com.project.generator.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.ProjectCommandLine;
import com.project.generator.model.projectGenerator;
import com.project.generator.services.projectCommandLineService;
import com.project.generator.util.YBprocessBuilder;
import com.project.generator.util.config.YbSoftConfig;

@Component
public class projectCommandLineServiceImp implements projectCommandLineService {
	private static final Logger logger = LoggerFactory.getLogger(projectGeneratorServiceImp.class);
	@Autowired
	YbSoftConfig config;
	@Autowired
	projectGenerator progn;
	String command;
	@Autowired
	YBprocessBuilder ybprocbldr;

	@Override
	public String projectSSH(ProjectCommandLine commandline, String replacevale) {
		String listOutput = null;

		String directory = System.getProperty("user.dir");
		
		String directoryPath = "";
		logger.info("Enter in build Project");
		try {
			System.out.println(commandline.getCommandLine());
			//String[] splitSgin = commandline.getCommandLine().split(">");
			//if (!commandline.getCommandLine().contains("cd")) {

				/*if (!splitSgin[0].equalsIgnoreCase("YBsoft")) {
					if (splitSgin.length < 1) {
						command = "cd" + " " + splitSgin[0] + "&&" + splitSgin[1];
					} else {
						if (splitSgin[0].contains(":")) {
							
							command = "cd" + " " + directory + " &&" + splitSgin[9];
						} else {
							command = "cd" + " " + splitSgin[0];
						}
					}

				} else {
					ybprocbldr.commandProcess("cd ..");
					command = "cd" + " " + directory + " &&" + splitSgin[1];

				}

			} else {
				
				if (splitSgin[0].equalsIgnoreCase("YBsoft")) {
					command = splitSgin[1];
				}
			}*/
				//command =splitSgin[0]+"\t"+splitSgin[1];
			listOutput = ybprocbldr.commandProcess(commandline.getCommandLine());
			//}

		} catch (Exception e) {
			logger.info("IOException command for you" + "" + command + "" + e.fillInStackTrace());
		}

		return listOutput;
	}

}
