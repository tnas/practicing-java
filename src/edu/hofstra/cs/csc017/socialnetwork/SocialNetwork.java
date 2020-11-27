package edu.hofstra.cs.csc017.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SocialNetwork {
	
    private List<Person> persons;
    private List<Relationship> relationships;
    private List<Content> contents;
    private Person loggedInUser;
    private SocialNetworkDataSource dataSource;
    
    private static SocialNetwork _instance;
    
    public static SocialNetwork getInstance() {
    	if (_instance == null) 
    		_instance = new SocialNetwork();
    	return _instance;
    }

    private SocialNetwork() {
    	this.dataSource = new SocialNetworkFileDataSource();
        this.getLoggedInUser();
    }
    
    public void defaultInit() {
    	this.persons = this.dataSource.retrivePeople();
		this.contents = this.dataSource.retrieveContent();
		this.relationships = this.dataSource.retrieveRelationships();
    }
    
    public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	public List<Person> getAllPeople() {
    	return this.persons;
    }

    public List<Relationship> getAllRelationships() {
       return this.relationships;
    }

    public List<Content> getAllContents() {
       return this.contents;
    }
    
    public Person getLoggedInUser() {
    	if (this.loggedInUser == null) {
	    	this.loggedInUser = this.dataSource.retrivePeople().get(0);
    	}
    	return this.loggedInUser;
    }
    
    public List<Content> getMainFeed() {
    	
    	List<Content> listMainFeed = new ArrayList<>();
    	
    	this.relationships.stream()
        		.filter(rel -> rel.isInRelation(this.loggedInUser))
        		.map(rel ->	rel.getFriend(this.loggedInUser))
        		.map(userFriend -> 
        				this.contents.stream()
        				.filter(cont -> cont.getAuthor().equals(userFriend))
        		)
        		.forEach(listOfPosts -> listOfPosts.forEach(listMainFeed::add));
        		
        return listMainFeed;
    }
    
    public List<Content> getRecommendedFeed() {
    	
    	List<Content> listFeed = new ArrayList<>();
    	
    	List<Person> userFriends = this.relationships.stream()
    			.filter(rel -> rel.isInRelation(this.loggedInUser))
    			.map(rel ->	rel.getFriend(this.loggedInUser))
    			.collect(Collectors.toList());
    	
    	userFriends.forEach(friend -> 
    		this.relationships.stream().filter(rel -> 
    			rel.isInRelation(friend) && !rel.isInRelation(this.loggedInUser) && 
    				!userFriends.contains(rel.getFriend(friend))
    		)
    		.map(rel ->	rel.getFriend(friend))
    		.map(friendOfFriend -> this.contents.stream()
				.filter(cont -> cont.getAuthor().equals(friendOfFriend)))
    		.forEach(listOfPosts -> listOfPosts.forEach(listFeed::add)));
    	
    	return listFeed;
    }

}
