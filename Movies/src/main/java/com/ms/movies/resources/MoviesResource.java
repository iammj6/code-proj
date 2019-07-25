package com.ms.movies.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.movies.models.Movies;
import com.ms.movies.models.MoviesResponse;

@RestController
@RequestMapping("/api/movies")
public class MoviesResource {

	@GetMapping(path="/listmovies/{userId}")
	public MoviesResponse getListOfMovies(@PathVariable(name="userId") String userId){
		Movies movies = new Movies("1","The Avengers","Superhero Movies");
		List<Movies> listOfMovies = new ArrayList<Movies>();
		listOfMovies.add(movies);
		return new MoviesResponse(listOfMovies);
	}
	
	@GetMapping(path="/test")
	public String test(){
		return "Service is Up";
	}
}
