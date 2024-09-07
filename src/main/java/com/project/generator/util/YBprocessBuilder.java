package com.project.generator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
class StreamGobbler extends Thread
{
    InputStream is;
    String type;
    List<String> outlist;
    StreamGobbler(InputStream is, String type,List<String> outlist)
    {
        this.is = is;
        this.type = type;
        this.outlist=outlist;
    }

    public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			String ditPath=null;
			
				while ((line = br.readLine()) != null) {				
					System.out.println(line);
					if (line.contains("Directory of")) {
						
						String[]  dir = line.split(" ");	
						 ditPath=dir[3];
					}
					if(line.contains("\f"))						
							outlist.clear();
					
					outlist.add(line);				
					
				}
				if(ditPath!=null)
					outlist.add("\n" + ditPath + ">");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
    
}
@Component
 class GoodWindowsExec
{
	 List<String> outlist=new ArrayList<>();
    public List<String> command(String args[])
    {
        if (args.length < 1)
        {
            System.out.println("USAGE: java GoodWindowsExec <cmd>");
            System.exit(1);
        }

        try
        {            
            String osName = System.getProperty("os.name" );
            System.out.println("OS NAME IS " + osName);
            String[] cmd = new String[3];
            if( osName.equals( "Windows NT" ) )
            {
                cmd[0] = "cmd.exe" ;
                cmd[1] = "/C" ;
                cmd[2] = args[0];
            }
            else if( osName.equals( "Windows 95" ) )
            {
                cmd[0] = "command.com" ;
                cmd[1] = "/C" ;
                cmd[2] = args[0];
            } else if (osName.toUpperCase().trim().contains("WINDOWS")) {
                cmd[0] = "cmd.exe" ;
                cmd[1] = "/C" ;
                cmd[2] = args[0];
            }

            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + cmd[0] + " " + cmd[1] 
                           + " " + cmd[2]);
            Process proc = rt.exec(cmd);
            
            // any error message?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR", outlist);            
           
            // any output?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(),"OUTPUT", outlist);

            // kick them off
            errorGobbler.start();
            outputGobbler.start();

            // any error???
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);        
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
		return outlist;
    }
   
}

class YBssh{
	
	private static YBssh obj;  
	 private YBssh(){}  
	   
	 public static YBssh getA(){  
	   if (obj == null){  
	      synchronized(YBssh.class){  
	        if (obj == null){  
	            obj = new YBssh();//instance will be created at request time  
	        }  
	    }              
	    }  
	  return obj;  
	 }  
	  
	 public String excSsh(String command1){  
		 StringBuffer outlist=new StringBuffer();
		 String host="localhost";
		    String user="yajat";
		    String password="Yajat@12";
		    String directory = System.getProperty("user.dir");
		   // String command1="Dir";
		    try{
		    	
		    	java.util.Properties config = new java.util.Properties(); 
		    	config.put("StrictHostKeyChecking", "no");
		    	JSch jsch = new JSch();
		    	Session session=jsch.getSession(user, host, 22);
		    	session.setPassword(password);
		    	session.setConfig(config);
		    	session.connect();
		    	System.out.println("Connected");		    	
		    	Channel channel=session.openChannel("exec");
		        ((ChannelExec)channel).setCommand(command1);
		        channel.setInputStream(null);
		        ((ChannelExec)channel).setErrStream(System.err);		        
		        InputStream in=channel.getInputStream();
		        channel.connect();
		        byte[] tmp=new byte[1024];
		        while(true){
		          while(in.available()>0){
		            int i=in.read(tmp, 0, 1024);
		            if(i<0)break;
		            System.out.println("output===================="+new String(tmp, 0, i));
		            outlist.append(new String(tmp, 0, i));
		          }
		          if(channel.isClosed()){
		            System.out.println("exit-status: "+channel.getExitStatus());
		            break;
		          }
		          try{Thread.sleep(1000);}catch(Exception ee){}
		        }
		        channel.disconnect();
		        session.disconnect();
		        System.out.println("DONE");
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return outlist.toString();
	 }  
}
 @Component
public class YBprocessBuilder {
	@Autowired
	GoodWindowsExec goodwindExex;	
    public String commandProcess(String commnd) {    	    
    	return YBssh.getA().excSsh(commnd);
    }

}

