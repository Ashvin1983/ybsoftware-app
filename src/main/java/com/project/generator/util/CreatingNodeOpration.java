package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.generator.util.Imp.sqlQuery;
import com.project.generator.util.config.YbSoftConfiguration;

@Component
public class CreatingNodeOpration {
	@Autowired
	YbSoftConfiguration ybsoftconfig;
	@Autowired
	sqlQuery sqlquery;
	public List<String> createPostMetod(String Key, Map<String, String> data, String apiUrl, String tableName,
			String dataType) {
		List<String> crtMthdPostList = new ArrayList<String>();
		crtMthdPostList.add("  router." + Key + "(\"" + "/" + "\",(req,res)=> {");
		if (dataType.equalsIgnoreCase("mysql")) {
			crtMthdPostList.add(" ");
			crtMthdPostList.add(" ");
			data.forEach((K, V) -> {
				crtMthdPostList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
			});

			crtMthdPostList.add(" ");
			crtMthdPostList.add("   connection.query(\"" + sqlquery.createSqlInserQuery(data, tableName, dataType)+"\",");
			crtMthdPostList.add(" ");
			ybsoftconfig.createOprationFunction("insert").forEach(action -> {
				crtMthdPostList.add(action);
			});
		} else if (dataType.equalsIgnoreCase("mongodb")) {
			crtMthdPostList.add(" ");
			crtMthdPostList.add("User.create(req.body, function (err, post) {");
			crtMthdPostList.add("   if (err) return res.json({ success: false, error: err });");
			crtMthdPostList.add("          return res.json({ success: true, data: post });");
			crtMthdPostList.add("  });");		
			crtMthdPostList.add(" ");
			crtMthdPostList.add("});");
		} else if (dataType.equalsIgnoreCase("mssql")) {
			data.forEach((K, V) -> {
				crtMthdPostList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
				crtMthdPostList.add(" ");

			});
			sqlquery.createSqlQueryFunction(null, sqlquery.createSqlInserQuery(data, tableName, dataType))
					.forEach(mmsqldata -> {
						crtMthdPostList.add(mmsqldata);

					});

		}
		return crtMthdPostList;

	}

	public List<String> createGetMetod(String Key, Map<String, String> data, String apiUrl, String tableName,
			String dataType) {
		List<String> crtMthdGetList = new ArrayList<String>();

		crtMthdGetList.add("  router." + Key + "(\"" + "/" + "\",(req,res)=> {");
		crtMthdGetList.add(" ");
		if (dataType.equalsIgnoreCase("mysql")) {
			crtMthdGetList.add(" ");
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdGetList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
				});
			crtMthdGetList.add("   connection.query(\"" + sqlquery.createSqlGetQuery(data, tableName, dataType) + "\",");
			ybsoftconfig.createOprationFunction("fetch").forEach(action -> {
				crtMthdGetList.add(action);
			});
		} else if (dataType.equalsIgnoreCase("mongodb")) {

			crtMthdGetList.add("User.find((err, data) => {");
			crtMthdGetList.add("   if (err) return res.json({ success: false, error: err });");
			crtMthdGetList.add("          return res.json({ success: true, data: data });");
			crtMthdGetList.add("  });");
			crtMthdGetList.add(" ");
			crtMthdGetList.add("});");
		} else if (dataType.equalsIgnoreCase("mssql")) {
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdGetList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
					crtMthdGetList.add(" ");
				});
			sqlquery.createSqlQueryFunction(null, sqlquery.createSqlGetQuery(data, tableName, dataType))
					.forEach(mmsqldata -> {
						crtMthdGetList.add(mmsqldata);

					});
		}
		return crtMthdGetList;

	}

	public List<String> createUpdateMetod(String Key, Map<String, String> data, String apiUrl, String tableName,
			String dataType) {
		List<String> crtMthdUpdateList = new ArrayList<String>();
		crtMthdUpdateList.add("  router.put(\"" + "/" + "\",(req,res)=> {");
		if (dataType.equalsIgnoreCase("mysql")) {
			crtMthdUpdateList.add(" ");
			crtMthdUpdateList.add(" ");
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdUpdateList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
					crtMthdUpdateList.add(" ");
				});
			crtMthdUpdateList.add(" ");
			crtMthdUpdateList
					.add("   connection.query(\"" + sqlquery.createSqlUpdateQuery(data, tableName, dataType) + "\",");
			crtMthdUpdateList.add(" ");
			ybsoftconfig.createOprationFunction("update").forEach(action -> {
				crtMthdUpdateList.add(action);
			});
		} else if (dataType.equalsIgnoreCase("mongodb")) {
			crtMthdUpdateList.add("const { id, update } = req.body;");
			crtMthdUpdateList.add(" ");
			crtMthdUpdateList.add("User.findByIdAndUpdate(id, update, (err) => {");
			crtMthdUpdateList.add("  if (err) return res.json({ success: false, error: err });");
			crtMthdUpdateList.add("  return res.json({ success: true });");
			crtMthdUpdateList.add(" });");
			crtMthdUpdateList.add(" ");
			crtMthdUpdateList.add("});");
		} else if (dataType.equalsIgnoreCase("mssql")) {
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdUpdateList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
					crtMthdUpdateList.add(" ");
				});

			sqlquery.createSqlQueryFunction(null, sqlquery.createSqlUpdateQuery(data, tableName, dataType))
					.forEach(mmsqldata -> {
						crtMthdUpdateList.add(mmsqldata);

					});
		}
		return crtMthdUpdateList;

	}

	public List<String> createDeleteMetod(String Key, Map<String, String> data, String apiUrl, String tableName,
			String dataType) {
		List<String> crtMthdDeltList = new ArrayList<String>();
		crtMthdDeltList.add("  router." + Key + "(\"" + "/" + "\",(req,res)=> {");
		if (dataType.equalsIgnoreCase("mysql")) {
			crtMthdDeltList.add(" ");			
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdDeltList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
					crtMthdDeltList.add(" ");
				});
			crtMthdDeltList
			.add("   connection.query(\"" + sqlquery.createSqlDeleteQuery(data, tableName, dataType) + "\",");
			
			crtMthdDeltList.add(" ");
			ybsoftconfig.createOprationFunction("delete").forEach(action -> {
				crtMthdDeltList.add(action);
			});
		} else if (dataType.equalsIgnoreCase("mongodb")) {
			crtMthdDeltList.add(" ");
			crtMthdDeltList.add("const { id } = req.body;");
			crtMthdDeltList.add(" ");
			crtMthdDeltList.add("  User.findByIdAndRemove(id, (err) => {");
			crtMthdDeltList.add("  if (err) return res.send(err);");
			crtMthdDeltList.add("   return res.json({ success: true });");
			crtMthdDeltList.add("  });");
			crtMthdDeltList.add(" ");
			crtMthdDeltList.add("});");
		} else if (dataType.equalsIgnoreCase("mssql")) {
			if (data != null)
				data.forEach((K, V) -> {
					crtMthdDeltList.add("  var " + K.toLowerCase() + "= req.body." + K + ";");
					crtMthdDeltList.add(" ");
				});
				sqlquery.createSqlQueryFunction(null, sqlquery.createSqlDeleteQuery(data, tableName, dataType))
						.forEach(mmsqldata -> {
							crtMthdDeltList.add(mmsqldata);
                   });
			
		}
		return crtMthdDeltList;

	}

}
