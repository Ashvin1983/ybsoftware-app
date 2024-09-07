package com.project.generator.util;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class CreateProjectListner implements Runnable{
	
	YbSoftWritingFile ybSoftWritingFile=new YbSoftWritingFile();
	private String createProjectFileName = null;
	 private String fullFilePath = null;
	 private String createFile=null;
	 private List<String> createFileList=null;
	    public CreateProjectListner(final String fullFilePath,final String createFile,final List<String> createFileList) {
	        this.fullFilePath = fullFilePath;
	        this.createFile = createFile;
	        this.createFileList = createFileList;
	    }
	 
	    public void run() {
	        try {
	            register(this.fullFilePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    private void register(final String file) throws IOException {
	        final int lastIndex = file.lastIndexOf("/");
	        String dirPath = file.substring(0, lastIndex + 1);
	        String fileName = file.substring(lastIndex + 1, file.length());
	        this.createProjectFileName = fileName;
	 
	        projectChanged(file,createFile,createFileList);
	        startWatcher(dirPath, fileName);
	    }
	 
	    private void startWatcher(String dirPath, String file) throws IOException {
	        final WatchService watchService = FileSystems.getDefault()
	                .newWatchService();
	        Path path = Paths.get(dirPath);
	        path.register(watchService, ENTRY_MODIFY);
	 
	        Runtime.getRuntime().addShutdownHook(new Thread() {
	            public void run() {
	                try {
	                    watchService.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	 
	        WatchKey key = null;
	        while (true) {
	            try {
	                key = watchService.take();
	                for (WatchEvent<?> event : key.pollEvents()) {
	                    if (event.context().toString().equals(createProjectFileName)) {
	                    	projectChanged(dirPath + file,createFile,createFileList);
	                    }
	                }
	                boolean reset = key.reset();
	                if (!reset) {
	                    System.out.println("Could not reset the watch key.");
	                    break;
	                }
	            } catch (Exception e) {
	                System.out.println("InterruptedException: " + e.getMessage());
	            }
	        }
	    }
	 
	    public List<String> projectChanged(String replacevale,String createFile,List<String> createFileList) {
	        System.out.println("Refreshing the configuration.");
	        return ybSoftWritingFile.filesWriting(replacevale,createFile,createFileList,false);
	    }
}
