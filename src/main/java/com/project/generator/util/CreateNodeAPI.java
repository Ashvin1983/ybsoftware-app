package com.project.generator.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.model.GeneratorNodejsApp;
import com.project.generator.util.config.YbSoftConfiguration;

@Component
public class CreateNodeAPI {

	String replacevale = null;

	@Autowired
	YbSoftWritingFile YbSoftwrtFile;
	@Autowired
	CreatingNodeOpration creatingnodeOpration;
	@Autowired
	Server server;
	@Autowired
	YbSoftConfiguration ybsoftconfig;
	
	List<String> createFileList = new ArrayList<String>();
	
	String apiUrl;
	String port;
	String fileName;


	public List<String> createNodeJsApi(Map<String, Map<String, String>> APIdata, String portn, String tableName,
			String apiUrl, String dataType) {
		List<String> nodeAPI = new ArrayList<String>();
		port = portn;
		if (dataType.equalsIgnoreCase("mysql")) {
			nodeAPI.add("const express = require('express');");
			nodeAPI.add("const conn = require('./config');");
			nodeAPI.add(" let connection = conn.getConnection();");
			nodeAPI.add(" ");
			nodeAPI.add(" // connect to database");
			nodeAPI.add(" connection.connect();");
		} else if (dataType.equalsIgnoreCase("mongodb")) {
			nodeAPI.add("const express = require('express');");
			nodeAPI.add("const {init } = require('./config');");
			nodeAPI.add("const User = require('./data');");
			nodeAPI.add("init().then(() => {");
			nodeAPI.add("	  console.log('starting server on port 32000')");
			nodeAPI.add("})");
		}

		else if (dataType.equalsIgnoreCase("mssql")) {

			nodeAPI.add("const express = require('express');");
			nodeAPI.add("const config = require('config');");
			nodeAPI.add("var sql = require(\"mssql\");");

		}

		nodeAPI.add(" ");
		nodeAPI.add("  let router = express.Router();");
		nodeAPI.add(" ");
		nodeAPI.add(" ");
		List<String> crtMthdList = new ArrayList<String>();

		for (Map.Entry<String, Map<String, String>> methodType : APIdata.entrySet()) {

			if (methodType.getKey().equalsIgnoreCase("post")) {
				crtMthdList = creatingnodeOpration.createPostMetod(methodType.getKey(), APIdata.get(methodType.getKey()), apiUrl, tableName,
						dataType);
				if(dataType.equalsIgnoreCase("mongodb")) {
				createFileList =ybsoftconfig.createMongoDBModel(APIdata.get(methodType.getKey()));
				fileName = "data.js";
				generateJavaAPI(fileName, createFileList);
				}
			}
			if (methodType.getKey().equalsIgnoreCase("Get")) {
				crtMthdList =creatingnodeOpration.createGetMetod(methodType.getKey(), APIdata.get(methodType.getKey()), apiUrl, tableName,
						dataType);

			}
			if (methodType.getKey().equalsIgnoreCase("Update")) {
				crtMthdList = creatingnodeOpration.createUpdateMetod(methodType.getKey(), APIdata.get(methodType.getKey()), apiUrl,
						tableName, dataType);

			}
			if (methodType.getKey().equalsIgnoreCase("Delete")) {
				crtMthdList = creatingnodeOpration.createDeleteMetod(methodType.getKey(), APIdata.get(methodType.getKey()), apiUrl,
						tableName, dataType);

			}
			crtMthdList.forEach(methodData -> {
				nodeAPI.add(methodData);
			});

		}

		nodeAPI.add(" ");
		nodeAPI.add("module.exports = router;");
		fileName = "controller.js";
		return nodeAPI;

	}

	

	public List<String> generateNodeApi(GeneratorNodejsApp generatornodejsapp) {

		replacevale = "E:\\YbSoft\\" + generatornodejsapp.getProjectName() + "NodAPI";
		StringBuffer inputData= new StringBuffer();
		if (generatornodejsapp != null) {
			if (generatornodejsapp.isPackageJson()) {
				List<String> commandlist = new ArrayList<String>();
				commandlist.add("express");
				commandlist.add("body-parser");
				commandlist.add(generatornodejsapp.getDataBaseName());
				if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mysql")) {
					commandlist.add("mysql");
				} else if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mongodb")) {

					commandlist.add("mongodb");
					commandlist.add("mongoose");
				} else if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mssql")) {
					commandlist.add("config");
					commandlist.add("mssql");
					commandlist.add("tedious");
					commandlist.add("msnodesqlv8");

				}			
				
				String command = null;
				if (YbSoftwrtFile.createDir(replacevale)) {
					if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mssql")) {
						YbSoftwrtFile.createDir(replacevale + "\\config");
					}
					command = "cd \"" + replacevale + "\"  && npm init -y";
					if (YbSoftwrtFile.handleComd(command)) {

						for (String cmd : commandlist) {
							command = "cd \"" + replacevale + "\"  && npm  install --save " + cmd + "";

							YbSoftwrtFile.handleComd(command);
						}

					}
					if (YbSoftwrtFile.createDir(replacevale + "\\package.json")) {
						inputData.append("\"scripts\"");
					    inputData.append(":");
						inputData.append("{\"start\":\"node server.js\"}");	
						
						try {
							YbSoftwrtFile.replaceFileString(inputData.toString(),replacevale + "\\package.json");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
			if (generatornodejsapp.getDataBaseName() != null) {

							
				if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mysql")) {					
					
					generatornodejsapp.getConfig().forEach(config -> {						
						createFileList =ybsoftconfig.createMysqlConfig(config.getDbType(),config.getHost(), config.getUserName(),
								config.getPassword(), config.getDatabase());

					});
					fileName = "config.js";
					generateJavaAPI(fileName, createFileList);
				} else if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mongodb")) {

					generatornodejsapp.getConfig().forEach(config -> {						
						createFileList =ybsoftconfig.createMongoDBcreatConfigList(config.getDbType(),config.getHost(), config.getUserName(),
								config.getPassword(), config.getDatabase());

					});
					fileName = "config.js";
					generateJavaAPI(fileName, createFileList);
					
					
					
				} else if (generatornodejsapp.getDataBaseName().equalsIgnoreCase("mssql")) {

					generatornodejsapp.getConfig().forEach(config -> {						
						createFileList =ybsoftconfig.createMSsqlreatConfigList(config.getDbType(),config.getHost(), config.getUserName(),
								config.getPassword(), config.getDatabase());

					});
					fileName = "\\config\\default.json";
					generateJavaAPI(fileName, createFileList);
				}

			}
			if (generatornodejsapp.getProjectModelInput() != null) {
				generatornodejsapp.getProjectModelInput().forEach(projectModel -> {
					apiUrl = projectModel.getApiUrl();
					port = projectModel.getPort();
					projectModel.getCreateApidata().forEach((K, V) -> {

						createFileList = createNodeJsApi(projectModel.getCreateApidata().get(K), port, K, apiUrl,
								generatornodejsapp.getDataBaseName());
					});

				});

				generateJavaAPI(fileName, createFileList);
			}
			if (generatornodejsapp.isServer()) {
				createFileList = server.createServer(apiUrl, port);
				fileName = "server.js";
				generateJavaAPI(fileName, createFileList);
			}

		}

		return null;

	}

	public List<String> generateJavaAPI(String createFile, List<String> createFileList) {

		return YbSoftwrtFile.NodefilesWriting(replacevale + "\\" + createFile, createFileList);
	}

}
