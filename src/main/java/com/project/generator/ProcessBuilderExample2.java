package com.project.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class StreamGobbler extends Thread {
	InputStream is;
	String type;
	List<String> outlist = new ArrayList<>();
	
	StreamGobbler(InputStream is, String type, List<String> outlist) {
		this.is = is;
		this.type = type;
		this.outlist = outlist;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			String ditPath=null;
			while ((line = br.readLine()) != null) {				
				
				if (line.contains("Directory of")) {
					
					String[]  dir = line.split(" ");	
					 ditPath=dir[3];
				}
				outlist.add(line);				
				
			}
			if(ditPath!=null)
				outlist.add("\n" + ditPath + ">");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}

class GoodWindowsExec {
	List<String> outlist = new ArrayList<>();

	public List<String> command(String args[]) {
		if (args.length < 1) {
			System.out.println("USAGE: java GoodWindowsExec <cmd>");
			System.exit(1);
		}

		try {
			String osName = System.getProperty("os.name");
			System.out.println("OS NAME IS " + osName);
			String[] cmd = new String[3];
			if (osName.equals("Windows NT")) {
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = args[0];
			} else if (osName.equals("Windows 95")) {
				cmd[0] = "command.com";
				cmd[1] = "/C";
				cmd[2] = args[0];
			} else if (osName.toUpperCase().trim().contains("WINDOWS")) {
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = args[0];
			}
			
			Runtime rt = Runtime.getRuntime();
			System.out.println(cmd[2]);
			String[] splitSgin= cmd[2].split(">");
			String directory = System.getProperty("user.dir");
			if (!cmd[2].contains("cd")) {

				
				if (!splitSgin[0].equalsIgnoreCase("YBsoft")) {
					if(splitSgin.length<1) {
					    cmd[2] ="cd" + " " + splitSgin[0] + "&&" + splitSgin[1];
					}
					else {
						
						cmd[2] ="cd" + " " + splitSgin[0] ;
					}
					
				} else {
					cmd[2] ="cd" + " " + directory + " &&" + splitSgin[1];
					
				}

			} 
			else {
				
				if (splitSgin[0].equalsIgnoreCase("YBsoft")) {
					cmd[2] =splitSgin[1];
				}
			}
			
			Process proc = rt.exec(cmd);
			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR", outlist);

			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", outlist);

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			int exitVal = proc.waitFor();
			System.out.println("ExitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return outlist;
	}
}

public class ProcessBuilderExample2 {

	public static void main(String[] args) {
		List<String> outlist = new ArrayList<>();
		GoodWindowsExec gdwnexe = new GoodWindowsExec();
		outlist = gdwnexe.command(new String[] { "cd E:\\YBUI && dir"+"&& cls" });
		for (String out : outlist)
			System.out.println(out);
		
	}

}
