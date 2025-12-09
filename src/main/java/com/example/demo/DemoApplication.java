package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Java Spring Boot API! Use /hello?name=YourName to test.";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s! This is a Java Spring Boot REST API.", name);
    }

    @GetMapping("/api/data")
    public DataResponse getData() {
        return new DataResponse("success", "Data retrieved successfully", 
            new String[]{"item1", "item2", "item3"});
    }

    static class DataResponse {
        public String status;
        public String message;
        public String[] data;

        public DataResponse(String status, String message, String[] data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }
    }
}
