package com.project.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"com.project.generator"})
public class projectGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(projectGeneratorApplication.class, args);
    }
 
}

