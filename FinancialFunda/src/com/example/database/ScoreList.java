package com.example.database;

public class ScoreList {
	
	private int id;	
	private int rating;
	private String comment;
	private String username;
	
	
	public void DatabaseDetails(){
		
	}
	
	public void DatabaseDetails(String comment, int rating){
		this.comment=comment;
		this.rating=rating;
	}
	
	
	//getters
	public String getComment(){
		return comment;
	}

	public int getRating(){
		return rating;
	}
	
	//setters
	public void setComment(String comment){
		this.comment=comment;
	}
	
	public void setRating(int rating){
		this.rating=rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
