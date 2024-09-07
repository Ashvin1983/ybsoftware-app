package com.project.generator.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class YbSoftWritingFile {
	private static final Logger logger = LoggerFactory.getLogger(YbSoftWritingFile.class);


public List<String> filesWriting(String dirPath ,String file,List<String> inputData,boolean isExist) {
	List<String> createFileList=new ArrayList<String>();	
	try {
		if(!dirPath.isEmpty()) {
		 /*File f1 = new File(dirPath);  		
		 boolean bool2 = f1.mkdirs();  
         if(bool2){            
            createFileList.add("Folder is created+"+dirPath+"+successfully");
         } */         
		FileWriter myWriter = new FileWriter(dirPath+"\\"+file);
        BufferedWriter out = new BufferedWriter(myWriter);
        
        if(!file.isEmpty() && file.endsWith(".java")){
        	inputData.add("}");
        }   
        inputData.forEach((fileData)->           
        		{
        			
        			try {
        			  if(isExist) {
        				  out.append(fileData);
        			  }else {
						out.write(fileData);
						out.newLine();
						createFileList.add("File is created"+file+"successfully");
        			  }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			
        			});
          out.close();
          myWriter.close();
        
	 }
	}catch (Exception e ) {
		// TODO: handle exception
	}
	
	return createFileList;
	
}
public boolean createDir(String path) {

	
	File files = new File(path);
	boolean dirPath=files.mkdirs();	   
       if(dirPath){            
          return dirPath;
       }
     
	return dirPath;
}
public boolean handleComd(String cmd) {
	boolean cmdCompleted=false;
	try {
		
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",cmd);
		builder.redirectErrorStream(true);
		Process p;

		p = builder.start();

		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			cmdCompleted=true;
		}
	} catch (IOException e) {
		// TODO: handle exception
	}
	return cmdCompleted;
}
public List<String> NodefilesWriting(String filePath ,List<String> inputData) {
	List<String> createFileList=new ArrayList<String>();

	try {
		FileWriter myWriter = new FileWriter(filePath);
        BufferedWriter out = new BufferedWriter(myWriter);
   
        inputData.forEach((fileData)->
        
        		{
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
         
	}catch (Exception e ) {
		// TODO: handle exception
	}
	
	return createFileList;
	
}

public static void replaceFileString(String newtesxt,String path) throws IOException {
	
      //Instantiating the Scanner class to read the file
      Scanner sc = new Scanner(new File(path));
      //instantiating the StringBuffer class
      StringBuffer buffer = new StringBuffer();
      //Reading lines of the file and appending them to StringBuffer
      while (sc.hasNextLine()) {
         buffer.append(sc.nextLine()+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      System.out.println("Contents of the file: "+fileContents);
      //closing the Scanner object
      sc.close();
      String oldLine = "No preconditions and no impediments. Simply Easy Learning!";
      String newLine = "Enjoy the free content";
      //Replacing the old line with new line
      fileContents = fileContents.replaceAll(oldLine, newLine);
      //instantiating the FileWriter class
      FileWriter writer = new FileWriter(path);
      System.out.println("");
      System.out.println("new data: "+fileContents);
      writer.append(fileContents);
      writer.flush();
}
}
