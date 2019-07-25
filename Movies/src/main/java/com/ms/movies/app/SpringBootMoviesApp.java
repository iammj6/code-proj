package com.ms.movies.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages={"com.ms.movies.resources"})
@EnableEurekaClient
public class SpringBootMoviesApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMoviesApp.class, args);
	}

}
