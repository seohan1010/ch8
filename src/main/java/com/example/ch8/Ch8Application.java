package com.example.ch8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Ch8Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Ch8Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Override
    public void run(String... args){
        
    }
}
