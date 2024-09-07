package com.project.generator.util.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YbSoftConfig {

	@Value("${ysoft.applicatin.angular}")
	private String application_angular;
	
	@Value("${ysoft.applicatin.react}")
	private String application_react;
	
	@Value("${ysoft.command.angular}")
	private String command_angular;
	
	@Value("${ysoft.command.react}")
	private String command_react;
	

	

	public String getApplication_angular() {
		return application_angular;
	}

	public void setApplication_angular(String application_angular) {
		this.application_angular = application_angular;
	}

	public String getApplication_react() {
		return application_react;
	}

	public void setApplication_react(String application_react) {
		this.application_react = application_react;
	}

	public String getCommand_angular() {
		return command_angular;
	}

	public void setCommand_angular(String command_angular) {
		this.command_angular = command_angular;
	}

	public String getCommand_react() {
		return command_react;
	}

	public void setCommand_react(String command_react) {
		this.command_react = command_react;
	}

	
	

	

	
}