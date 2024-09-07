package com.project.generator.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreateMaven {

	public List<String> createMaven(String dbName,String pkg, String projectName, String applicationV, String jversion,
			String springBversion) {
		List<String> mavenList = new ArrayList<String>();
		mavenList.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		mavenList.add(
				"		<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
		mavenList.add("		    <modelVersion>4.0.0</modelVersion>");
		mavenList.add("		    <groupId>" + pkg + "</groupId>");
		mavenList.add("		    <artifactId>" + projectName + "</artifactId>");
		mavenList.add("		    <name>" + projectName + "</name>");
		mavenList.add("		    <description>" + projectName + "</description>");
		mavenList.add("		    <version>" + applicationV + "</version>");
		mavenList.add("		    <parent>");
		mavenList.add("		        <groupId>org.springframework.boot</groupId>");
		mavenList.add("		        <artifactId>spring-boot-starter-parent</artifactId>");
		mavenList.add("		        <version>" + springBversion + "</version>");
		mavenList.add("		    </parent>");
		mavenList.add("                   ");
		mavenList.add("		    <properties>");
		mavenList.add("		        <java.version>" + jversion + "</java.version>");
		mavenList.add("		    </properties>");
		mavenList.add("");
		mavenList.add("		    <dependencies>");
		mavenList.add("		        <dependency>");
		mavenList.add("		            <groupId>org.springframework.boot</groupId>");
		mavenList.add("		            <artifactId>spring-boot-starter-web</artifactId>");
		mavenList.add("		        </dependency>");
		mavenList.add("");
		mavenList.add("		        <dependency>");
		mavenList.add("		            <groupId>org.springframework.boot</groupId>");
		mavenList.add("		            <artifactId>spring-boot-starter-tomcat</artifactId>");
		mavenList.add("		            <scope>provided</scope>");
		mavenList.add("		        </dependency>");
       if(!jversion.equals("1.8")) {
			mavenList.add("             <dependency>");
			mavenList.add("               <groupId>org.springframework.data</groupId>");
			mavenList.add("               <artifactId>spring-data-jpa</artifactId>");
			mavenList.add("                <version>3.2.4</version>");
			mavenList.add("              </dependency>");
       }else {
			mavenList.add("             <dependency>");
			mavenList.add("               <groupId>org.springframework.boot</groupId>");
			mavenList.add("               <artifactId>spring-boot-starter-data-jpa</artifactId>");
			mavenList.add("              </dependency>");
       }
		mavenList.add("");
		mavenList.add("             <dependency>");
		mavenList.add("                <groupId>org.projectlombok</groupId>");
		mavenList.add("                <artifactId>lombok</artifactId>");
		mavenList.add("             </dependency>");
		mavenList.add("            <dependency>");
		mavenList.add("              <groupId>javax.persistence</groupId>");
		mavenList.add("              <artifactId>javax.persistence-api</artifactId>");
		mavenList.add("              <version>2.2</version>");
		mavenList.add("             </dependency>");
		mavenList.add(" ");
		mavenList.add("              <dependency>");
		mavenList.add("                <groupId>org.springframework.boot</groupId>");
		mavenList.add("                <artifactId>spring-boot-starter-security</artifactId>");
		mavenList.add("              </dependency>");
		mavenList.add(" ");
		mavenList.add("             <dependency>");
		mavenList.add("               <groupId>org.springframework.boot</groupId>");
		mavenList.add("               <artifactId>spring-boot-starter-validation</artifactId>");
		mavenList.add("             </dependency>");
		mavenList.add("               <!-- Use Jetty -->");
		mavenList.add("              <dependency>");
		mavenList.add("                <groupId>org.springframework.boot</groupId>");
		mavenList.add("                 <artifactId>spring-boot-starter-jetty</artifactId>");
		mavenList.add("               </dependency>");
		mavenList.add(" ");
		mavenList.add("              <dependency>");
		mavenList.add("                 <groupId>org.springframework.boot</groupId>");
		mavenList.add("                <artifactId>spring-boot-starter-artemis</artifactId>");
		mavenList.add("             </dependency>");
		mavenList.add(" ");
		mavenList.add("             <dependency>");
		mavenList.add("               <groupId>org.springframework.boot</groupId>");
		mavenList.add("               <artifactId>spring-boot-starter-actuator</artifactId>");
		mavenList.add("               </dependency>");
		mavenList.add(" ");
		if(!jversion.equals("1.8")) {
			mavenList.add("              <dependency>");
			mavenList.add("                <groupId>io.micrometer</groupId>");
			mavenList.add("                <artifactId>micrometer-tracing-bridge-brave</artifactId>");
			mavenList.add("             </dependency>");
			mavenList.add("           <dependency>");
			mavenList.add("             <groupId>org.liquibase</groupId>");
			mavenList.add("             <artifactId>liquibase-core</artifactId>");
			mavenList.add("           </dependency>");
		}
		mavenList.add("             <dependency>");
		mavenList.add("               <groupId>org.postgresql</groupId>");
		mavenList.add("               <artifactId>postgresql</artifactId>");
		mavenList.add("             </dependency>");
		mavenList.add(" ");
		if(dbName.equals("h2")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>com.h2database</groupId>");
			mavenList.add("              <artifactId>h2</artifactId>");
			mavenList.add("            </dependency>");
		}
		if(dbName.equals("mongo")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>org.springframework.boot</groupId>");
			mavenList.add("              <artifactId>spring-boot-starter-data-mongodb</artifactId>");
			mavenList.add("            </dependency>");
		}
		if(dbName.equals("oracle")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>com.oracle</groupId>");
			mavenList.add("              <artifactId>ojdbc14</artifactId>");
			mavenList.add("              <version>10.2.0.4.0</version>");
			mavenList.add("            </dependency>");
		}
		if(dbName.equals("mysql")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>mysql</groupId>");
			mavenList.add("              <artifactId>mysql-connector-java</artifactId>");
			mavenList.add("            </dependency>");
		}
		if(dbName.equals("maria")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>org.mariadb.jdbc</groupId>");
			mavenList.add("              <artifactId>mariadb-java-client</artifactId>");
			mavenList.add("              <version>1.5.7</version>");
			mavenList.add("            </dependency>");
		}
		if(dbName.equals("couchbase")) {
			mavenList.add("            <dependency>");
			mavenList.add("              <groupId>org.springframework.boot</groupId>");
			mavenList.add("              <artifactId>spring-boot-starter-data-couchbase</artifactId>");
			mavenList.add("              <version>2.3.9.RELEASE</version>");
			mavenList.add("            </dependency>");
		}
		mavenList.add(" ");	
		mavenList.add("           <dependency>");
		mavenList.add("              <groupId>org.springframework.boot</groupId>");
		mavenList.add("              <artifactId>spring-boot-starter-test</artifactId>");
		mavenList.add("              <scope>test</scope>");
		mavenList.add("              <exclusions>");
		mavenList.add("                 <exclusion>");
		mavenList.add("                  <groupId>com.vaadin.external.google</groupId>");
		mavenList.add("                  <artifactId>android-json</artifactId>");
		mavenList.add("                </exclusion>");
		mavenList.add("              </exclusions>");
		mavenList.add("           </dependency>");
		mavenList.add("          <!-- For hot reloads in Intellij/Eclipse -->");
		mavenList.add("          <dependency>");
		mavenList.add("            <groupId>org.springframework.boot</groupId>");
		mavenList.add("            <artifactId>spring-boot-devtools</artifactId>");
		mavenList.add("            <optional>true</optional>");
		mavenList.add("         </dependency>");
		mavenList.add(" ");
		mavenList.add("        <dependency>");
		mavenList.add("          <groupId>org.junit.jupiter</groupId>");
		mavenList.add("          <artifactId>junit-jupiter-api</artifactId>");
		mavenList.add("           <scope>test</scope>");
		mavenList.add("         </dependency>");
		mavenList.add(" ");
		mavenList.add("       <dependency>");
		mavenList.add("          <groupId>org.junit.jupiter</groupId>");
		mavenList.add("         <artifactId>junit-jupiter-engine</artifactId>");
		mavenList.add("         <scope>test</scope>");
		mavenList.add("       </dependency>");
		mavenList.add(" ");
		mavenList.add("       <dependency>");
		mavenList.add("           <groupId>org.springframework.boot</groupId>");
		mavenList.add("           <artifactId>spring-boot-configuration-processor</artifactId>");
		mavenList.add("           <optional>true</optional>");
		mavenList.add("       </dependency>");
		mavenList.add(" ");
		mavenList.add("		        <dependency>");
		mavenList.add("		            <groupId>org.apache.tomcat.embed</groupId>");
		mavenList.add("		            <artifactId>tomcat-embed-jasper</artifactId>");
		mavenList.add("		            <scope>provided</scope>");
		mavenList.add("		        </dependency>");
		mavenList.add("		    </dependencies>");
		mavenList.add("		    <build>");
		mavenList.add("		        <plugins>");
		mavenList.add("                 <plugin>");
		mavenList.add("                    <groupId>org.springframework.boot</groupId>");
		mavenList.add("                    <artifactId>spring-boot-maven-plugin</artifactId>");
		if(!jversion.equals("1.8")) {
			mavenList.add("                    <configuration>");
			mavenList.add("                       <mainClass>" + projectName + ".App</mainClass>");
			mavenList.add("                       <layout>JAR</layout>");
			mavenList.add("                   </configuration>");
			mavenList.add("                   <executions>");
			mavenList.add("                     <execution>");
			mavenList.add("                       <goals>");
			mavenList.add("                        <goal>repackage</goal>");
			mavenList.add("                      </goals>");
			mavenList.add("                    </execution>");
			mavenList.add("                  </executions>");
		}
		mavenList.add("              </plugin>");
		mavenList.add("		        </plugins>");
		mavenList.add("		    </build>");
		mavenList.add("		</project>");

		return mavenList;

	}
}
