package edu.hofstra.cs.csc017.socialnetwork;

import java.util.List;
import java.util.Scanner;

public class SocialNetworkViewCommand implements SocialNetworkView {

	private static final int EXIT_OPTION = 9;
	private static final String NO_DATA_FOUND_MSG = "No data found.";
	
	private Person loggedInUser;
	private Scanner inputScanner;
	private boolean isActive;
	private int userOption;
	
	public SocialNetworkViewCommand() {
		this.inputScanner = new Scanner(System.in);
		this.isActive = true;
		this.userOption = 0;
	}
	
	@Override
	public Person getLoggedInUser() {
		if (this.loggedInUser == null)
			this.loggedInUser = SocialNetwork.getInstance().getLoggedInUser(); 
		return this.loggedInUser;
	}
	
	@Override
	public int getUserOption() {
		return this.userOption;
	}

	@Override
	public void showMainFeed(List<Content> feed) {
		System.out.println("~~~~The main feed~~~~");
		feed.forEach(p -> System.out.println(
				String.format("%s by user %s", p.getDetails(), p.getAuthor().getFullName())));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void showRecommendedFeed(List<Content> feed) {
		System.out.println("~~~~The recommended feed~~~~");
		feed.forEach(post -> System.out.println(String.format("%s by user %s", 
				post.getDetails(), post.getAuthor().getFullName())));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void showPeople(List<Person> people) {
		System.out.println("~~~~People's List~~~~");
		if (people.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
		else people.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void showRelationships(List<Relationship> relationships) {
		System.out.println("~~~~Relationships List~~~~");
		if (relationships.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
		else relationships.forEach(System.out::println);
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void showFullContent(List<Content> contents) {
		System.out.println("~~~~Content List~~~~");
		if (contents.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
		else contents.forEach(System.out::println);
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public String getPeopleDataSource() {
		System.out.println("Enter file path which has people's data: ");
        return inputScanner.nextLine();
	}

	@Override
	public String getContentDataSource() {
		System.out.println("Enter file path which has content data: ");
        return inputScanner.nextLine();
	}

	@Override
	public String getRelationshipDataSource() {
		System.out.println("Enter file path which has relationhip data: ");
        return inputScanner.nextLine();
	}

	@Override
	public void close() {
		this.inputScanner.close();
	}

	@Override
	public void goodBye() {
		System.out.println("Have a good day.");
	}

	@Override
	public boolean isActive() {
		
		while (true) {
	        System.out.println(String.format("Welcome to Social Network! (Logged in user: %s)", 
	        		getLoggedInUser().getFullName()));
	        System.out.println("Please choose one of the following options:");
	        System.out.println("0. Load standard files from default directory");
	        System.out.println("1. Enter filename for people");
	        System.out.println("2. Enter filename for relationships");
	        System.out.println("3. Enter filename for content");
	        System.out.println("4. View a list of people");
	        System.out.println("5. View a list of relationships");
	        System.out.println("6. View a list of content");
	        System.out.println("7. Print the main feed.");
	        System.out.println("8. Print the recommended feed.");
	        System.out.println(String.format("%d. Exit", EXIT_OPTION));
	        
	        try {
	        	this.userOption = Integer.parseInt(inputScanner.nextLine().trim());
	        	if (this.userOption < 0 || this.userOption > 9) {
	        		System.out.println("Invalid option! Try again!");
	        	}
	        	else {
	        		break;
	        	}
	        } catch(Exception e) {
	        	System.out.println("Invalid option! Try again!");
	        }
		}
		
		if (this.userOption == EXIT_OPTION) this.isActive = false;
        
        return this.isActive;
	}
	
}
