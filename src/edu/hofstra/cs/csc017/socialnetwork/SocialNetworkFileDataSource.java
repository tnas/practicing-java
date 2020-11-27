package edu.hofstra.cs.csc017.socialnetwork;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SocialNetworkFileDataSource implements SocialNetworkDataSource {
	
	private static final String SPLIT_CHARACTER = "\\|";
	private static final String DEFAULT_DIR = 
			Paths.get("").toAbsolutePath().toString().concat("/resources/edu.hofstra.cs.csc017.socialnetwork/");
	private static final String DEFAULT_CONTENT_FILE = DEFAULT_DIR.concat("content.txt");
	private static final String DEFAULT_PEOPLE_FILE = DEFAULT_DIR.concat("people.txt");
	private static final String DEFAULT_RELATIONSHIPS_FILE = DEFAULT_DIR.concat("relationships.txt");
	
    @Override
	public List<Person> retrivePeople(String param) {
    	List<Person> persons = new ArrayList<>();
    	readFile(param).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            persons.add(new Person(details[0], details[1], details[2], Integer.parseInt(details[3])));
    	});
    	return persons;
    }
    
    @Override
	public List<Content> retrieveContent(String param) {
    	List<Content> contents = new ArrayList<>();
    	readFile(param).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            contents.add(new Content(new Person(details[0], details[1]), details[2]));
    	});
    	return contents;
    }
    
    @Override
	public List<Relationship> retrieveRelationships(String param) {
    	List<Relationship> relationships = new ArrayList<>();
    	readFile(param).forEach(line -> {
    		String[] details = line.split(SPLIT_CHARACTER);
            Relationship relationship = new Relationship(new Person(details[0], details[1]), 
            		new Person(details[2], details[3]), RelationshipType.fromString(details[4]));
            relationships.add(relationship);
    	});
    	return relationships;
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

	@Override
	public List<Person> retrivePeople() {
		return this.retrivePeople(DEFAULT_PEOPLE_FILE);
	}

	@Override
	public List<Content> retrieveContent() {
		return this.retrieveContent(DEFAULT_CONTENT_FILE);
	}

	@Override
	public List<Relationship> retrieveRelationships() {
		return this.retrieveRelationships(DEFAULT_RELATIONSHIPS_FILE);
	}
}
