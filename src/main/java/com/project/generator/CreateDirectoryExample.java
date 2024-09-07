package com.project.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CreateDirectoryExample {
	public static void main(String[] args) throws Exception {
//		String path="E:\\YbSoft\\NodeApi\"";
//		String cmd="npm install express";
//		String command="cd \""+path+"  && "+cmd+"\"";
//        ProcessBuilder builder = new ProcessBuilder(
//            "cmd.exe", "/c", command);
//        builder.redirectErrorStream(true);
//        Process p = builder.start();
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        while (true) {
//            line = r.readLine();
//            if (line == null) { break; }
//            System.out.println(line);
//        }
		
//		List<String> listdata=new ArrayList<String>();
//		listdata.add("pid");
//		listdata.add("p_name");
//		listdata.add("p_cost");
//		 String data="";
//		 String dataParam="";
//		for(int i=listdata.size()-1;i>=0;i--) {			
//			
//			data="\"+"+listdata.get(i)+"+\",".concat(data);
//			dataParam=listdata.get(i)+",".concat(dataParam);
//		
//		}
//		System.out.println(data.substring(0, data.length() - 2));
//		System.out.println("INSERT INTO tabaleName("+ dataParam.substring(0, dataParam.length() - 2) +") values ("+data.substring(0, data.length() - 2)+")");
		String replacevale = "E:\\YbSoft";
		String command = "cd \"" + replacevale + "\"  && ng new mytestinang";
		boolean cmdCompleted=false;
		   try {

				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
				builder.redirectErrorStream(true);
				Process process = builder.start();
				
				BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while (true) {
					
					line = r.readLine();
					 
					if (line != null) {
						
						System.out.println("\n readLine  code : " + line);
						break;
					} 
					
							
				}
                int exitCode = process.waitFor();
				
	            System.out.println("\nExited with error code : " + exitCode);
				
			} catch(InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		   catch (IOException e) {
			   System.out.println(e.getMessage());
			}
	}		
}
