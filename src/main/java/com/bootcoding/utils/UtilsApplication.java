package com.bootcoding.utils;

import com.bootcoding.utils.service.CodingProblemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilsApplication.class, args);
	}

	@Bean
	CommandLineRunner runOnStartup(CodingProblemService codingProblemService) {
		return args -> {
			System.out.println("🚀 Inserting data from JSON...");
			codingProblemService.insertDataFromJson();
			System.out.println("Data insertion complete.");
		};
	}
}
