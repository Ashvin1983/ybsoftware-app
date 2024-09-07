package com.project.generator.util.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class YbSoftConfiguration {

	
	
	public List<String> createMysqlConfig(String dbType, String host, String userName, String password,
			String database){
		List<String>  creatConfigList=new ArrayList<>();
		creatConfigList.add("const   " + dbType.toLowerCase() + " = require(\"" + dbType + "\");");
		creatConfigList.add(" ");
		creatConfigList.add(" ");
		creatConfigList.add("module.exports = {");
		creatConfigList.add(" getConnection: () => {");
		creatConfigList.add("  return    " + dbType.toLowerCase() + ".createConnection({");
		creatConfigList.add(" ");
		creatConfigList.add("     host:\"" + host + "\",");
		creatConfigList.add("     user: \"" + userName + "\",");
		creatConfigList.add("     password:\"" + password + "\",");
		creatConfigList.add("     database: \"" + database + "\",");
		creatConfigList.add(" ");
		creatConfigList.add(" ");
		creatConfigList.add(" });");
		creatConfigList.add(" }");
		creatConfigList.add(" }");
		return creatConfigList;
	}
	
	public List<String> createMongoDBcreatConfigList(String dbType, String host, String userName, String password,
			String database){
		List<String>  creatConfigList=new ArrayList<>();
		  creatConfigList.add("const mongoose = require('mongoose');");
		  creatConfigList.add("const mongoURI ='mongodb+srv://root:81GTQw9nMX0gS8hf@cluster0-wyfqm.mongodb.net/test?retryWrites=true&w=majority';");
		  creatConfigList.add("const init = () =>");
		  creatConfigList.add("mongoose.connect(mongoURI, () => { }, { useNewUrlParser: true })");
		  creatConfigList.add("   .catch(err => {");
		  creatConfigList.add("     console.log(err);");
		  creatConfigList.add(" });");
          creatConfigList.add("let db = mongoose.connection;");
          creatConfigList.add("db.once('open', () => console.log('connected to the database'));");
		  creatConfigList.add("db.on('error', console.error.bind(console, 'MongoDB connection error:'));");
          creatConfigList.add(" module.exports = { init}");
				return creatConfigList;
		
	}
	
	public List<String> createMSsqlreatConfigList(String dbType, String host, String userName, String password,
			String database){
		List<String>  creatConfigList=new ArrayList<>();
		creatConfigList.add(" {");
  		creatConfigList.add("  \"config\": {");  		
  		creatConfigList.add("     \"server\":\"" + host + "\",");
  		creatConfigList.add("     \"authentication\":{");
  		creatConfigList.add("        \"type\":\"default\",");
  		creatConfigList.add("        \"options\":{");
  		creatConfigList.add("           \"userName\":\"" + userName + "\",");
  		creatConfigList.add("           \"password\":\"" + password + "\"");
  		creatConfigList.add("            }");
  		creatConfigList.add("          },");
  		creatConfigList.add("        \"options\":{");
  		creatConfigList.add("           \"database\": \"" + database + "\"");
  		creatConfigList.add(" ");    		
  		creatConfigList.add("            }");
  		creatConfigList.add("   }");
  		creatConfigList.add(" }");
				return creatConfigList;
		
	}
	
	public List<String> createOprationFunction(String opration) {
		List<String> funcAPI = new ArrayList<String>();
		funcAPI.add(" ");
		funcAPI.add("     function (err, result)  { ");
		funcAPI.add(" ");
		funcAPI.add("        if (err) { ");
		funcAPI.add(" ");
		funcAPI.add("            console.log(\"error while " + opration + "ting the object!\")");
		funcAPI.add(" ");
		funcAPI.add("        } else { ");
		funcAPI.add(" ");
		funcAPI.add("           res.send({" + opration + ":result });");
		funcAPI.add("        }");
		funcAPI.add("  });");
		funcAPI.add("});");

		return funcAPI;
	}
	public List<String> createMongoDBModel(Map<String,String> modelData) {

		List<String> createModelList = new ArrayList<String>();

		createModelList.add("const mongoose = require(\"mongoose\");");
		createModelList.add("const Schema = mongoose.Schema;");
		createModelList.add("const User = require('./config');");
		createModelList.add("// this will be our data base's data structure ");
		createModelList.add("const UserSchema = new Schema({");
		
		for (Map.Entry<String, String> modelprop : modelData.entrySet()) {
			createModelList.add(""+modelprop.getKey()+": {");
			createModelList.add("    type:String,");
			createModelList.add(" required:true");
  		    createModelList.add(" },");
		}

		createModelList.add("});");

		createModelList.add("module.exports = mongoose.model(\"User\", UserSchema);");
		
		return createModelList;
	}
}

