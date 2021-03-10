package com.tnas.assignment.library;

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
	public void print() {
		System.out.println("The book title is " + this.getTitle());
		System.out.println("The book author is " + this.author);
		if (this.isFiction)
			System.out.println("The book is fiction and " + this.numberOfPages + " pages long");
		else
			System.out.println("The book is non-fiction and " + this.numberOfPages + " pages long");
	}
	
}
