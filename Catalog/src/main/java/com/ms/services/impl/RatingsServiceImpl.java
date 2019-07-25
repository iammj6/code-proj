package com.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.catalog.models.Movies;
import com.ms.catalog.models.Ratings;
import com.ms.catalog.models.RatingsResponse;
import com.ms.services.RatingsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getRatingsFallback",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")
	})
	public RatingsResponse getRatings(Movies movie) {
		RatingsResponse ratingsResponse = restTemplate.getForObject("http://eureka-zuul/api/ratings-service/ratings/listratings/"+movie.getId(), RatingsResponse.class);
		return ratingsResponse;
	}

	public RatingsResponse getRatingsFallback(Movies movie){
		RatingsResponse resp = new RatingsResponse(new Ratings("0", "null", "*****"));
		return resp;
	}
}
