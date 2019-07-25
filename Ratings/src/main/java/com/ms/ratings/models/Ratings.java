package com.ms.ratings.models;

public class Ratings {

	private String id;
	private String name;
	private String rating;
	
	public Ratings(){
		
	}
	
	public Ratings(String id, String name, String rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
}