package com.ms.services;

import org.springframework.stereotype.Service;

import com.ms.catalog.models.Movies;
import com.ms.catalog.models.RatingsResponse;

public interface RatingsService {

	public RatingsResponse getRatings(Movies movie);
	
}
