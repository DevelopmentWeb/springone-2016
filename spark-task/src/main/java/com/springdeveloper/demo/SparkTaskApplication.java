package com.springdeveloper.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(org.springframework.cloud.task.app.spark.yarn.SparkYarnTaskConfiguration.class)
public class SparkTaskApplication {

	public static void main(String[] args) {
		System.out.println("Hello Task");
		SpringApplication.run(SparkTaskApplication.class, args);
	}
}
