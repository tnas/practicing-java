package com.tnas.assignment.linkedlist;

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
	public String toString() {
		return "Song [title=" + this.getTitle() + " type=" + type + ", artist=" + artist + "]";
	}
	
}
