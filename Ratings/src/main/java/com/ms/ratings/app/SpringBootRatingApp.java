package com.ms.ratings.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages={"com.ms.ratings.resources"})
@EnableEurekaClient
public class SpringBootRatingApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRatingApp.class, args);
	}

}
