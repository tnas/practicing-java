package com.tnas.assignment.exceptionalpress;

public class Book {
	
	private static final int CHARACTERS_PER_PAGE = 700;
	
	private String title;
	
	private String author;
	
	private String content;
	
	private int edition;
	
	public Book(String title, String author, String content, int edition) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.edition = edition;
	}
	
	public int getPages() {
		return (int) Math.round(Math.ceil(this.content.length() / CHARACTERS_PER_PAGE));
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Ttitle: " + title + "\nAuthor: " + author + "\nEdition: " + edition;
	}
	
	public static void main(String[] args) {
		Book book = new Book("Treasure Island", "Rober Louis Stevenson", "Content", 1);
		System.out.println(book.toString());
	}
	
}
