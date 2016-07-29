package com.springdeveloper.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.app.spark.yarn.SparkYarnTaskConfiguration;
import org.springframework.cloud.task.sparkapp.common.SparkAppCommonTaskProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SparkYarnTaskConfiguration.class, SparkAppCommonTaskProperties.class})
public class SparkTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkTaskApplication.class, args);
	}
}
