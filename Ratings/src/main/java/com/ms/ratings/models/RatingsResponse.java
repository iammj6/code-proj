package com.ms.ratings.models;

public class RatingsResponse {

	private Ratings ratings;
	
	public RatingsResponse(){
		
	}
	
	public RatingsResponse(Ratings ratings) {
		super();
		this.ratings = ratings;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}
	
	
	
}
