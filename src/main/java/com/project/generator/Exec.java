package com.project.generator;
import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;



class Exec {

    private static final String SSH_HOST = "localhost";
    private static final String SSH_LOGIN = "Yajat";
    private static final String SSH_PASSWORD = "Yajat@12";

    public static void main(String[] arg) throws JSchException, IOException, InterruptedException {
       /* System.out.println(runCommand("pwd"));
        System.out.println(runCommand("ls -la"));*/
    	 try
         {
            Runtime rt = Runtime.getRuntime();
            String[] cmd = new String[3];
            cmd[0] = "cmd.exe" ;
            cmd[1] = "/C" ;
            cmd[2] = "/CD E:/YbSoft";
            //cmd[3] = "/c..";
            System.out.println(cmd);
            Process pr = rt.exec(cmd);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null)
            {
               System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
         }
         catch (Exception e)
         {
            System.out.println(e.toString());
            e.printStackTrace();
         }
    }

    private static List<String> runCommand(String command) throws JSchException {
        Session session = setupSshSession();
        session.connect();

        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        try {
            channel.setCommand(command);
            channel.setInputStream(null);
            InputStream output = channel.getInputStream();
            channel.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(output));
            String line = null;
            String result =null;
            while ((line = br.readLine()) != null) {				
            	 return asList(result.split("\n"));
				
			}
           

        } catch (JSchException | IOException e) {
            closeConnection(channel, session);
            throw new RuntimeException(e);

        } finally {
            closeConnection(channel, session);
        }
		return null;
    }

    private static Session setupSshSession() throws JSchException {
        Session session = new JSch().getSession(SSH_LOGIN, SSH_HOST, 135);
        session.setPassword(SSH_PASSWORD);
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig("StrictHostKeyChecking", "no"); // disable check for RSA key
        return session;
    }

    private static void closeConnection(ChannelExec channel, Session session) {
        try {
            channel.disconnect();
        } catch (Exception ignored) {
        }
        session.disconnect();
    }
}