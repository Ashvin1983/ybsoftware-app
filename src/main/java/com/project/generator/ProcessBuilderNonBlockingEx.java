package com.project.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class ProcessBuilderNonBlockingEx {

    public static void main(String[] args) throws InterruptedException,
            ExecutionException, TimeoutException, IOException {

    	ExecutorService executor = Executors.newSingleThreadExecutor();

    	ProcessBuilder processBuilder = new ProcessBuilder();
       String commnd="cd E:\\YBUI";
       processBuilder.command("cmd.exe", "/c", commnd+"&& npm start");

        try {
        	
        	//System.out.println("system proccess file",processBuilder.directory().getName());
        	Process process = processBuilder.start();
        	
            System.out.println("processing ping command ...");
            ProcessTask task = new ProcessTask(process.getInputStream());
            Future<List<String>> future = executor.submit(task);

            // non-blocking, doing other tasks
            System.out.println("doing task1 ...");
            System.out.println("doing task2 ...");

            List<String> results = future.get(5, TimeUnit.SECONDS);

            for (String res : results) {
                System.out.println(res);
            }

        } finally {
            executor.shutdown();
        }
    }

    private static class ProcessTask implements Callable<List<String>> {

        private InputStream inputStream;

        public ProcessTask(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public List<String> call() {
            return new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.toList());
        }
    }
}
