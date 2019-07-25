package com.ms.catalog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/*
 * 1. Difference between @Configuration and @Configurable
 * 2. Autowiring bean into static method in a util class
 * 3. How to access Spring Bean in a Non-Spring class
 */
@SpringBootApplication(scanBasePackages={"com.ms.catalog.resources","com.ms.services.impl"})
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringBootCatalogApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@LoadBalanced
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCatalogApplication.class, args);
	}

}
