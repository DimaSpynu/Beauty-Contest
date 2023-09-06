package com.example.Beautycontest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeautyContestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeautyContestApplication.class, args);
    }

    @Component
    public class CommandLineRunnerImpl implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            System.out.println("In CommandLineRunnerImpl ");

            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
