package com.tnas.assignment.linkedlist;

public class Book extends LibraryItem {

	private String author;
	
	private int numberOfPages;
	
	private boolean isFiction;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isFiction() {
		return isFiction;
	}

	public void setFiction(boolean isFiction) {
		this.isFiction = isFiction;
	}

	@Override
	public String toString() {
		return "Book [title=" + this.getTitle() + " author=" + author + ", numberOfPages=" + numberOfPages + ", isFiction=" + isFiction + "]";
	}
	
	

}
