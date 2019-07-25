package com.ms.catalog.models;

import java.util.List;

public class MoviesResponse {

	private List<Movies> listOfMovies;

	public MoviesResponse(){
		
	}
	
	public MoviesResponse(List<Movies> listOfMovies) {
		super();
		this.listOfMovies = listOfMovies;
	}

	public List<Movies> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<Movies> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}
	
	
}
