package edu.hofstra.cs.csc017.socialnetwork;

import java.util.List;

public interface SocialNetworkView {

	Person getLoggedInUser();
	
	int getUserOption();
	
	void showMainFeed(List<Content> feed);
	
	void showRecommendedFeed(List<Content> feed);
	
	void showPeople(List<Person> people);
	
	void showRelationships(List<Relationship> relations);
	
	void showFullContent(List<Content> contentList);
	
	void goodBye();
	
	String getPeopleDataSource();
	
	String getContentDataSource();
	
	String getRelationshipDataSource();
	
	boolean isActive();
	
	void close();
}
