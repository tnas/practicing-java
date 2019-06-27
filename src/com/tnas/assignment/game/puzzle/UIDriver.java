package com.tnas.assignment.game.puzzle;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UIDriver {

	private static final int NUMBER_OF_GAMES = 3;
	private static int currentPosition;
	private Game[] games;
	private Scanner scanner;
	
	public UIDriver() {
		this.games = new Game[NUMBER_OF_GAMES];
		currentPosition = -1;
		this.scanner = new Scanner(System.in);
	}
	
	public void addGame(Game newGame) {
		this.games[++currentPosition] = newGame;
	}
	
	private Game currentGame() {
		return this.games[currentPosition];
	}
	
	public void readNameCurrentGame() {
		String name;
		do {
			System.out.println("Please enter the name of your game.");
			name = scanner.nextLine(); 
		}while (!currentGame().setName(name));
	}
	
	public void readGenreCurrentGame() {
		String genre;
		do {
			System.out.println("Please enter the genre for " + currentGame().getName());
			genre = scanner.nextLine();
		}while (!currentGame().setGenre(genre));
	}
	
	public void readRatingCurrentGame() {
		String rating;
		do {
			System.out.println("Please enter the rating for " + currentGame().getName());
			rating = scanner.next();
		}while (!currentGame().setRating(rating));
	}
	
	public void readNumberOfPlayersCurrentGame() {
		int players;
		do {
			System.out.println("Please enter the number of players for " + currentGame().getName());
			players = scanner.nextInt();
		}while (!currentGame().setNumberOfPlayers(players));
	}

	public void readDescriptionCurrentGame() {
		String desc;
		do {
			System.out.println("Please enter the description for " + currentGame().getName());
			desc = scanner.nextLine();
		}while (!currentGame().setDescription(desc));
	}
	
	public void printGames() {
		Arrays.asList(this.games).forEach(Game::toString);
	}
	
	public void close() {
		this.scanner.close();
	}
	
	public static void main(String[] args) {
		
		UIDriver uiDriver = new UIDriver();
		
		IntStream.range(0, UIDriver.NUMBER_OF_GAMES).forEach(n -> {
			uiDriver.addGame(new Game());
			uiDriver.readNameCurrentGame();
			uiDriver.readGenreCurrentGame();
			uiDriver.readRatingCurrentGame();
			uiDriver.readNumberOfPlayersCurrentGame();
			uiDriver.readDescriptionCurrentGame();
		});
		
		uiDriver.printGames();
		uiDriver.close();
	}
}
