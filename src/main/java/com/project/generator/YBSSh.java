package com.project.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.project.generator.util.CreateMaven;
import com.project.generator.util.YbSoftWritingFile;

public class YBSSh {
	 public static void main(String[] arg) {
		 CreateMaven createMaven=new CreateMaven();
		 YbSoftWritingFile crp=new YbSoftWritingFile();
	        try {
	        	
	        	List<String> mavenCreate=createMaven.createMaven("","","EmpMangment","","","");				
				 if(!mavenCreate.isEmpty()) {
					// crp.filesWriting("E:\\Ybsoftware\\EmpMangment","pom.xml", mavenCreate,false);
					 FileWriter myWriter = new FileWriter("E:\\Ybsoftware\\EmpMangment\\pom.xml");
			         BufferedWriter out = new BufferedWriter(myWriter);
			         mavenCreate.forEach((fileData)->  {
			         try {
						out.write(fileData);
						out.newLine();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
			         
						
			         });
			         out.close();
			          myWriter.close();	
				 }	
				
				
	         /*   JSch jsch = new JSch();

	            //create SSH connection
	            String host = "localhost";
	            String user = "yajat@LAPTOP-6PV0HTV3";
	            String password = "Yajat@12";

	            Session session = jsch.getSession(user, host, 22);
	            session.setPassword(password);
	            session.connect();*/
	        	/*String dpath="E:\\Ybsoftware\\ecommerce\\src\\main\\java\\com\\project\\generator\\model";
	        	File f1 = new File(dpath);     
	            //Creating a folder using mkdirs() method  
	            boolean bool2 = f1.mkdirs();  
	            if(bool2){  
	               System.out.println("Folder is created successfully");  
	            }else{  
	               System.out.println("Error Found!");  
	            }  
	            FileWriter myWriter = new FileWriter(dpath+"\\Employee.java");
	            BufferedWriter out = new BufferedWriter(myWriter);*/
	        	//String file="Employee.java";
	        	//String[]  fExtension=file.split("");
               //System.out.println(fExtension[1]);
	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
}
