package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

	@RequestMapping("/")
	String home() {
		logger.debug("debug hello");
		logger.info("info");
		return "Hello World!";
	}

	@RequestMapping("/sleep")
	String sleep() {
		try {
        	logger.debug("start sleep");
            Thread.sleep(100_000); // 100초 (100,000ms)
			logger.debug("end sleep");
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