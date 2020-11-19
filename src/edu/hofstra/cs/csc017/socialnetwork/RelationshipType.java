package edu.hofstra.cs.csc017.socialnetwork;

public enum RelationshipType {
	FOLLOW, FRIEND, OTHER;
	
	public static RelationshipType fromString(String data) {
		switch (data) {
		case "Friend":
			return FRIEND;
		case "Follow":
			return FOLLOW;
		default:
			return OTHER;
		}
		
	}
}
