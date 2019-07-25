package com.ms.catalog.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.catalog.models.MovieCatalogResponse;
import com.ms.catalog.models.Movies;
import com.ms.catalog.models.Ratings;
import com.ms.catalog.models.RatingsResponse;
import com.ms.services.MoviesService;
import com.ms.services.RatingsService;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	
	@Autowired
	MoviesService moviesService;
	
	@Autowired
	RatingsService ratingsService;
	
	@GetMapping(path="/moviecatalog")
	public List<MovieCatalogResponse> getMovieCatalog(){
		MovieCatalogResponse movieCatalogResponse = new MovieCatalogResponse();
		//MoviesResponse moviesResponse = restTemplate.getForObject("http://movies-service/movies/listmovies/1", MoviesResponse.class); 
		List<Movies> listOfMovies = moviesService.getMoviesList();
		System.out.println("Using Asynchronous calling");
		
		List<MovieCatalogResponse> listOfMoviesCatalog2 = listOfMovies.stream().map(movie ->{
			RatingsResponse ratingsResponse = ratingsService.getRatings(movie);
			Ratings ratings = ratingsResponse.getRatings();
			movieCatalogResponse.setName(movie.getName());
			movieCatalogResponse.setDesc(movie.getDescription());
			movieCatalogResponse.setRating(ratings.getRating());
			return movieCatalogResponse;
		})
		.collect(Collectors.toList());
		return listOfMoviesCatalog2;
	}
	
	@GetMapping(path="/test")
	public String test(){
		return "Service is Up";
	}
}