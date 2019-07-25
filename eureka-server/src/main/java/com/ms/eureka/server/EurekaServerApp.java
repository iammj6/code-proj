package com.ms.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
/**
 * 1. The Zuul starter does not include a discovery client, so, for routes based on service IDs, 
 * you need to provide one of those on the classpath as well (Eureka is one choice).
 * 2. If the serviceId or url is not specified in the routes path for a service, then the
 * route name for eg.movies will considered as the serviceId. The serviceId should then match
 * the service-name in the Eureka registry.
 * @author Sampoorna
 *
 */
public class EurekaServerApp {
//https://stackoverflow.com/questions/39587317/difference-between-ribbonclient-and-loadbalanced
//https://stackoverflow.com/questions/43538030/zuul-and-ribbon-integration
//https://stackoverflow.com/questions/57123551/client-side-load-balancing-in-microservices
//https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#cookies-and-sensitive-headers
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApp.class, args);
	}

}
