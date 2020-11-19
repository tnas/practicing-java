package edu.hofstra.cs.csc017.socialnetwork;

public class Content {

    private Person author;
    private String details;

    public Content(Person author, String details) {
        this.author = author;
        this.details = details;
    }

    @Override
    public String toString() {
        return author.getFullName() + ": " + details;
    }

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
    
}
