package com.tnas.assignment.gamefootball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FootballGame {
	
	private static List<Integer> validScores = Arrays.asList(0, 1, 2, 3, 6);
	private static final int NUMBER_OF_QUARTERS = 4;
	
	private enum Team { HOME, VISITOR };
	private Scanner scanner;
	private String[] teamNames;
	private int[] homeScore;
	private int nextHomeScore;
	private int[] visitorScore;
	private int nexVisitorScore;
	private int currentQuarter;
	
	public void startGame() {
		this.scanner       = new Scanner(System.in);
		this.teamNames     = new String[Team.values().length];
		this.homeScore     = new int[Integer.MAX_VALUE];
		this.visitorScore  = new int[Integer.MAX_VALUE];
		this.nextHomeScore = this.nexVisitorScore 
						   = this.currentQuarter = 1;
	}
	
	public void getHomeTeamName() {
		System.out.println("Please enter the name for the home team.");
		this.teamNames[Team.HOME.ordinal()] = this.scanner.next();
	}
	
	public void getVisitorTeamName() {
		System.out.println("Please enter the name for the visitor team.");
		this.teamNames[Team.VISITOR.ordinal()] = this.scanner.next();
	}
	
	public void getScoreHomeTeam() {
		
	}
	
	public void getScoreVisitorTeam() {
		
	}
	
	public void finishGame() {
		this.scanner.close();
	}
}
