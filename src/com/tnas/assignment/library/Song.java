package com.tnas.assignment.library;

public class Song extends LibraryItem {

	private String type;
	
	private String artist;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public void print() {
		System.out.println("The song title is " + this.getTitle());
		System.out.println("The song type is " + this.type);
		System.out.println("The artist for this song is " + this.artist);
	}
	
}
