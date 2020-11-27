package edu.hofstra.cs.csc017.socialnetwork;

import java.util.List;

public interface SocialNetworkDataSource {

	List<Person> retrivePeople(String param);
	
	List<Person> retrivePeople();

	List<Content> retrieveContent(String param);
	
	List<Content> retrieveContent();

	List<Relationship> retrieveRelationships(String param);
	
	List<Relationship> retrieveRelationships();
}