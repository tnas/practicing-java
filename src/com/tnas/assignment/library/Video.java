package com.tnas.assignment.library;

public class Video extends LibraryItem {

	private String genre;
	
	private String rate;
	
	private int duration;
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public void print() {
		System.out.println("The video title is " + this.getTitle());
		System.out.println("The video genre is " + this.genre);
		System.out.println("The video is rated " + this.rate + 
				" and runs for " + this.duration + " minutes");
	}

}
