package com.tnas.assignment.gamefootball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FootballGame {
	
	private static int TOUCHDOWN = 6;
	private static List<Integer> validScores = Arrays.asList(0, 1, 2, 3, TOUCHDOWN);
	private static List<Integer> validScoresAfterTowchdown = Arrays.asList(0, 1, 2);
	private static String winnerMessageFormat = "%s defeated %s by a score of %d to %d.";
	private static String NO = "N";
	private static int MAX_SCORE_NUMBER = 1000;
	private static final int NUMBER_OF_QUARTERS = 4;
	private static String validScoresText = new String();
	static {
		validScoresText = validScoresText.concat("(");
		validScores.forEach(s ->  validScoresText = 
				validScoresText.concat(String.valueOf(s).concat(", ")));
		validScoresText = validScoresText.replaceFirst(",\\s$", ")");
	}
	
	private enum Team { HOME, VISITOR };
	private Scanner scanner;
	private String[] teamNames;
	private int[] homeScore;
	private int nextHomeScore;
	private int[] visitorScore;
	private int nextVisitorScore;
	private int currentQuarter;
	
	public FootballGame() {
		this.scanner       = new Scanner(System.in);
		this.teamNames     = new String[Team.values().length];
		this.homeScore     = new int[MAX_SCORE_NUMBER];
		this.visitorScore  = new int[MAX_SCORE_NUMBER];
		this.nextHomeScore = this.nextVisitorScore 
						   = this.currentQuarter = 1;
	}
	
	public void startGame() {
		
		getHomeTeamName();
		getVisitorTeamName();
		String changeQuarterOption;
		
		while (this.currentQuarter <= NUMBER_OF_QUARTERS) {
			
			getScoreHomeTeam();
			getScoreVisitorTeam();
			
			System.out.println(
					String.format("Do you want to enter another score for quarter %d?", 
							this.currentQuarter));
			changeQuarterOption = scanner.next();
			
			if (changeQuarterOption.equalsIgnoreCase(NO)) ++this.currentQuarter;
		}
	}
	
	public void endGame() {
		
		this.scanner.close();
		
		int count, homeFinalScore, visitorFinalScore;
		homeFinalScore = visitorFinalScore = 0;
		
		for (count = 0; count < this.nextHomeScore; ++count) 
			homeFinalScore += this.homeScore[count];
		
		for (count = 0; count < this.nextVisitorScore; ++count) 
			visitorFinalScore += this.visitorScore[count];
		
		if (homeFinalScore > visitorFinalScore) {
			System.out.println(String.format(winnerMessageFormat, 
					getTeamName(Team.HOME), getTeamName(Team.VISITOR),
					homeFinalScore, visitorFinalScore));
		}
		else if (homeFinalScore < visitorFinalScore) {
			System.out.println(String.format(winnerMessageFormat, 
					getTeamName(Team.VISITOR), getTeamName(Team.HOME),
					visitorFinalScore, homeFinalScore));
		}
		else {
			System.out.println(String.format("The teams tied by a score of %d.", 
					homeFinalScore));
		}
	}
	
	private void getHomeTeamName() {
		System.out.println("Please enter the name for the home team.");
		this.teamNames[Team.HOME.ordinal()] = this.scanner.next();
	}
	
	private void getVisitorTeamName() {
		System.out.println("Please enter the name for the visitor team.");
		this.teamNames[Team.VISITOR.ordinal()] = this.scanner.next();
	}
	
	private void getScoreHomeTeam() {
		do {
			System.out.println(String.format("Please enter the score for %s.", 
					getTeamName(Team.HOME)));
		} while (!this.addScore(Team.HOME, scanner.nextInt()));
		if (isLastScoreTouchdown(Team.HOME)) getScoreHomeTeam();
	}
	
	private void getScoreVisitorTeam() {
		do {
		System.out.println(String.format("Please enter the score for %s.", 
				getTeamName(Team.VISITOR)));
		} while (!this.addScore(Team.VISITOR, scanner.nextInt()));
		if (isLastScoreTouchdown(Team.VISITOR)) getScoreVisitorTeam();
	}
	
	private String getTeamName(Team team) {
		return this.teamNames[team.ordinal()];
	}
	
	private boolean isValidScore(int score) {
		return validScores.contains(score);
	}
	
	private boolean isLastScoreTouchdown(Team team) {
		if (team == Team.HOME)
			return this.homeScore[this.nextHomeScore-1] == TOUCHDOWN;
		else 
			return this.visitorScore[this.nextVisitorScore-1] == TOUCHDOWN;
	}
	
	private boolean addScore(Team team, int score) {
		
		if (!isValidScore(score)) {
			System.out.println(String.format("Invalid score. Please enter a valid score %s.", 
					validScoresText));
			return false;
		}
		else if (isLastScoreTouchdown(team)) {
			if (!validScoresAfterTowchdown.contains(score)) {
				System.out.println("You entered an invalid score for an extra point.");
				score = 0;
			}
		}
		
		switch (team) {
		case HOME:
			this.homeScore[this.nextHomeScore++] = score;
			break;
		case VISITOR:
			this.visitorScore[this.nextVisitorScore++] = score;
			break;
		default:
			break;
		}
		
		return true;
	}
}
