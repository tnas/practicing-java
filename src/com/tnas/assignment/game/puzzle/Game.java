package com.tnas.assignment.game.puzzle;

import java.util.Arrays;
import java.util.List;

public class Game {

	private static List<String> validGenres = Arrays.asList("Puzzle", "Shooter", "Arcade");
	private static List<String> validRatings = Arrays.asList("E", "T", "M");
	private static String validGenresText = new String();
	private static String validRatingsText = new String();
	private static int  MIN_PLAYERS = 1;
	private static int  MAX_PLAYERS = 10;
	
	static {
		validGenres.forEach(s ->  validGenresText = 
				validGenresText.concat(String.valueOf(s).concat(", ")));
		validGenresText = validGenresText.replaceFirst(",\\s$", "");	
		
		validRatings.forEach(s ->  validRatingsText = 
				validRatingsText.concat(String.valueOf(s).concat(", ")));
		validRatingsText = validRatingsText.replaceFirst(",\\s$", "");
	}
	
	private String name;
	
	private String genre;
	
	private String rating;
	
	private int numberOfPlayers;
	
	private String description;

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("You must enter a name.");
			return false;
		}
		this.name = name;
		return true;
	}

	public String getGenre() {
		return genre;
	}

	public boolean setGenre(String genre) {
		if (!validGenres.stream().anyMatch(genre::equalsIgnoreCase)) {
			System.out.println(String.format("Invalid genre. Valid choices are %s", validGenresText));
			return false;
		}
		this.genre = genre;
		return true;
	}

	public String getRating() {
		return rating;
	}

	public boolean setRating(String rating) {
		if (!validRatings.stream().anyMatch(rating::equalsIgnoreCase)) {
			System.out.println(String.format("Invalid rating. Valid choices are %s", validRatingsText));
			return false;
		}
		this.rating = rating;
		return true;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public boolean setNumberOfPlayers(int numberOfPlayers) {
		if (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS) {
			System.out.println(String.format(
					"Invalid number of players. This must be between %d and %d", MIN_PLAYERS, MAX_PLAYERS));
			return false;
		}
		this.numberOfPlayers = numberOfPlayers;
		return true;
	}

	public String getDescription() {
		return description;
	}

	public boolean setDescription(String description) {
		if (description == null || description.trim().isEmpty()) {
			System.out.println("You must enter a description.");
			return false;
		}
		this.description = description;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Game name = %s genre = %s, rating = %s, numPlayers = %d\nDescription = %s", 
				name, genre, rating, numberOfPlayers, description);
	}
	
}
