package com.project.generator.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Yajat
 *
 */
@Component
public class GeneratorSpringbootApp {
    

	public String projectName;
	public String dataBase;	
	public String dataBaseName;		
    public String buildName;
    public String dirName;
    public String sPringBootV;
    public String javaVesrion;
    public String applicationV;
    public String orgName;
	public  List<String> output;

	public List<projectControllerModel> controllerInput;

	public List<projectServiceImpModel>  serviceImplInput;
	public List<projectModel>  projectModelInput;
	public List<projectServiceModel>  srvModelInput;
	
	public List<ProjectApplicationPro>   applictionProInput;
	
	public  List<String> pakgList;
	
	public GeneratorSpringbootApp() {}
	
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the dataBaseName
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}
	/**
	 * @param dataBaseName the dataBaseName to set
	 */
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	/**
	 * @return the output
	 */
	public List<String> getOutput() {
		return output;
	}
	/**
	 * @param output the output to set
	 */
	public void setOutput(List<String> output) {
		this.output = output;
	}

	

	/**
	 * @return the controllerInput
	 */
	@JsonProperty("controllerInput")
	public List<projectControllerModel> getControllerInput() {
		return controllerInput;
	}

	/**
	 * @param controllerInput the controllerInput to set
	 */
	@JsonProperty("controllerInput")
	public void setControllerInput(List<projectControllerModel> controllerInput) {
		this.controllerInput = controllerInput;
	}

	/**
	 * @return the serviceImplInput
	 */
	@JsonProperty("serviceImplInput")
	public List<projectServiceImpModel> getServiceImplInput() {
		return serviceImplInput;
	}

	/**
	 * @param serviceImplInput the serviceImplInput to set
	 */
	@JsonProperty("serviceImplInput")
	public void setServiceImplInput(List<projectServiceImpModel> serviceImplInput) {
		this.serviceImplInput = serviceImplInput;
	}
	@JsonProperty("projectModelInput")
	public List<projectModel> getProjectModelInput() {
		return projectModelInput;
	}
	@JsonProperty("projectModelInput")
	public void setProjectModelInput(List<projectModel> projectModelInput) {
		this.projectModelInput = projectModelInput;
	}

	/**
	 * @return the srvModelInput
	 */
	@JsonProperty("srvModelInput")
	public List<projectServiceModel> getSrvModelInput() {
		return srvModelInput;
	}

	/**
	 * @param srvModelInput the srvModelInput to set
	 */
	@JsonProperty("srvModelInput")
	public void setSrvModelInput(List<projectServiceModel> srvModelInput) {
		this.srvModelInput = srvModelInput;
	}

	/**
	 * @return the pakgList
	 */
	@JsonProperty("pakgList")
	public List<String> getPakgList() {
		return pakgList;
	}

	/**
	 * @param pakgList the pakgList to set
	 */
	@JsonProperty("pakgList")
	public void setPakgList(List<String> pakgList) {
		this.pakgList = pakgList;
	}

	/**
	 * @return the buildName
	 */
	@JsonProperty("buildName")
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @param buildName the buildName to set
	 */
	@JsonProperty("buildName")
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * @return the dirName
	 */
	@JsonProperty("dirName")
	public String getDirName() {
		return dirName;
	}

	/**
	 * @param dirName the dirName to set
	 */
	@JsonProperty("dirName")
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	/**
	 * @return the sPringBootV
	 */
	@JsonProperty("sPringBootV")
	public String getsPringBootV() {
		return sPringBootV;
	}

	/**
	 * @param sPringBootV the sPringBootV to set
	 */
	@JsonProperty("sPringBootV")
	public void setsPringBootV(String sPringBootV) {
		this.sPringBootV = sPringBootV;
	}

	/**
	 * @return the javaVesrion
	 */
	@JsonProperty("javaVesrion")
	public String getJavaVesrion() {
		return javaVesrion;
	}

	/**
	 * @param javaVesrion the javaVesrion to set
	 */
	@JsonProperty("javaVesrion")
	public void setJavaVesrion(String javaVesrion) {
		this.javaVesrion = javaVesrion;
	}

	/**
	 * @return the applictionProInput
	 */
	@JsonProperty("applictionProInput")
	public List<ProjectApplicationPro> getApplictionProInput() {
		return applictionProInput;
	}

	/**
	 * @param applictionProInput the applictionProInput to set
	 */
	@JsonProperty("applictionProInput")
	public void setApplictionProInput(List<ProjectApplicationPro> applictionProInput) {
		this.applictionProInput = applictionProInput;
	}

	/**
	 * @return the applicationV
	 */
	@JsonProperty("applicationV")
	public String getApplicationV() {
		return applicationV;
	}

	/**
	 * @param applicationV the applicationV to set
	 */
	@JsonProperty("applicationV")
	public void setApplicationV(String applicationV) {
		this.applicationV = applicationV;
	}

	/**
	 * @return the orgName
	 */
	@JsonProperty("orgName")
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	@JsonProperty("orgName")
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	
	
}

