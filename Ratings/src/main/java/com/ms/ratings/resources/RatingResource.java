package com.ms.ratings.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ratings.models.Ratings;
import com.ms.ratings.models.RatingsResponse;

@RestController
@RequestMapping("/api/ratings")
public class RatingResource {

	@GetMapping(path="/listratings/{movieId}")
	public RatingsResponse getListOfMovies(@PathVariable(name="movieId") String movieId){
		Ratings ratings = new Ratings("1","The Avengers","****");
		return new RatingsResponse(ratings);
	}
	
	@GetMapping(path="/test")
	public String test(){
		return "Service is Up";
	}
	
}
