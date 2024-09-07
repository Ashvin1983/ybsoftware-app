package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Server {

	public List<String> createServer(String apiUrl,String port) {

		List<String> crtServer = new ArrayList<String>();

		crtServer.add("const express = require('express');");
		crtServer.add("const fetch = require('./controller');");
		crtServer.add("const bodyparser = require('body-parser');");
		crtServer.add(" ");
		crtServer.add("// create app instance");
		crtServer.add("let app = express();");
		crtServer.add("app.use('/fetch', fetch);");
		crtServer.add(" ");
		crtServer.add("// set JSON as MIME type");
		crtServer.add("app.use(bodyparser.json())");
		crtServer.add(" ");
		crtServer.add("// check for form data");
		crtServer.add("app.use(bodyparser.urlencoded({ extended:false }));");
		crtServer.add(" ");
		crtServer.add("var insert = require('./controller');");
		crtServer.add("app.use('/insert',insert);");
		crtServer.add(" ");
		crtServer.add("// update");
		crtServer.add("let update = require('./controller');");
		crtServer.add("app.use('/update', update);");
		crtServer.add(" ");
		crtServer.add("// delete");
		crtServer.add("let remove = require('./controller');");
		crtServer.add("app.use('/delete', remove);");
		crtServer.add(" ");
		crtServer.add("// Assign port number");
		crtServer.add("app.listen(" + port + ");");
		crtServer.add("console.log('server is listening at port no. 3000');");

		return crtServer;
	}
}
