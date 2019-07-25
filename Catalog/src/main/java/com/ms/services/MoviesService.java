package com.ms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.catalog.models.Movies;

public interface MoviesService {

	public List<Movies> getMoviesList();
}
