package edu.hofstra.cs.csc017.socialnetwork;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SocialNetwork {
	
	private static final String DEFAULT_DIR = 
			Paths.get("").toAbsolutePath().toString().concat("/resources/edu.hofstra.cs.csc017.socialnetwork/");
	private static final String DEFAULT_CONTENT_FILE = DEFAULT_DIR.concat("content.txt");
	private static final String DEFAULT_PEOPLE_FILE = DEFAULT_DIR.concat("people.txt");
	private static final String DEFAULT_RELATIONSHIPS_FILE = DEFAULT_DIR.concat("relationships.txt");
	private static final String NO_DATA_FOUND_MSG = "No data found.";
	private static final String SPLIT_CHARACTER = "\\|";
	
    private ArrayList<Person> persons;
    private ArrayList<Relationship> relationships;
    private ArrayList<Content> contents;

    public SocialNetwork() {
        this.persons = new ArrayList<>();
        this.relationships = new ArrayList<>();
        this.contents = new ArrayList<>();
    }
    
    public void readPeopleFile(String filePath) {
    	readFile(filePath).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            this.persons.add(new Person(details[0], details[1], details[2], Integer.parseInt(details[3])));
    	});
    }
    
    public void readContentFile(String filePath) {
    	readFile(filePath).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            this.contents.add(new Content(new Person(details[0], details[1]), details[2]));
    	});
    }
    
    public void readRelationshipFile(String filePath) {
    	readFile(filePath).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            Relationship relationship = new Relationship(new Person(details[0], details[1]), 
            		new Person(details[2], details[3]), RelationshipType.fromString(details[4]));
            this.relationships.add(relationship);
    	});
    }

    public void listAllPeople() {
        if (persons.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
        this.persons.forEach(System.out::println);
    }

    public void listAllRelationships() {
        if (relationships.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
        this.relationships.forEach(System.out::println);
    }

    public void listAllContents() {
        if (contents.isEmpty()) System.out.println(NO_DATA_FOUND_MSG);
        this.contents.forEach(System.out::println);
    }
    
    public void loadDefaultData() {
    	this.readPeopleFile(DEFAULT_PEOPLE_FILE);
		this.readContentFile(DEFAULT_CONTENT_FILE);
		this.readRelationshipFile(DEFAULT_RELATIONSHIPS_FILE);
		System.out.println("Data input successful!");
    }
    
    public Person getLoggedInUser() {
    	this.readPeopleFile(DEFAULT_PEOPLE_FILE);
    	Person loggedInUser = this.persons.get(0);
    	this.persons.clear();
    	return loggedInUser;
    }
    
    public void printMainFeed(Person user) {
    	this.relationships.stream()
    		.filter(rel -> rel.isInRelation(user))
    		.map(rel ->	rel.getFriend(user))
    		.map(userFriend -> 
    				this.contents.stream()
    				.filter(cont -> cont.getAuthor().equals(userFriend))
    		)
    		.forEach(listOfPosts -> listOfPosts.forEach(p -> System.out.println(
    				String.format("%s by user %s", p.getDetails(), p.getAuthor().getFullName())))
    		);
    }
    
    public void printRecommendedFeed(Person user) {
    	List<Person> userFriends = this.relationships.stream()
    			.filter(rel -> rel.isInRelation(user))
    			.map(rel ->	rel.getFriend(user))
    			.collect(Collectors.toList());
    	
    	userFriends.forEach(friend -> 
    		this.relationships.stream().filter(rel -> 
    			rel.isInRelation(friend) && !rel.isInRelation(user) && 
    				!userFriends.contains(rel.getFriend(friend))
    		)
    		.map(rel ->	rel.getFriend(friend))
    		.map(friendOfFriend -> this.contents.stream()
				.filter(cont -> cont.getAuthor().equals(friendOfFriend)))
    		.forEach(listOfPosts -> listOfPosts.forEach(post -> System.out.println
    				(String.format("%s by user %s", post.getDetails(), post.getAuthor().getFullName()))))
    		);
    }

    private List<String> readFile(String filePath) {
    	
        List<String> lines = new ArrayList<>();
        
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath(filePath));
        } catch (Exception e) {
            System.err.println(String.format("File %s not found!", filePath));
        }
        
        return lines;
    }
}
