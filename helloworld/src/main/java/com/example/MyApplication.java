package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/sleep")
	String sleep() {
		try {
            Thread.sleep(100_000); // 100초 (100,000ms)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Interrupted!";
        }
		return "Hello 100s sleep world";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

}