package com.ms.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ms.catalog.models.Movies;
import com.ms.catalog.models.MoviesResponse;
import com.ms.services.MoviesService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MoviesServiceImpl implements MoviesService{

	@Autowired
	WebClient.Builder webClientBuilder;
	
	@HystrixCommand(fallbackMethod="getMoviesListFallback",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")
	})
	public List<Movies> getMoviesList(){
		MoviesResponse moviesResponse = webClientBuilder.build()
				.get()
				.uri("http://eureka-zuul/api/moviesservice/movies/listmovies/1")
				.retrieve()
				.bodyToMono(MoviesResponse.class)
				.block();
		List<Movies> listOfMovies = moviesResponse.getListOfMovies();
		System.out.println("listOfMovies size "+listOfMovies.size());
		return listOfMovies;
	}
	
	public List<Movies> getMoviesListFallback(){
		List<Movies> listOfMovies = Arrays.asList(new Movies("0", "null", "null"));
		System.out.println("listOfMovies size "+listOfMovies.size());
		return listOfMovies;
	}
}
