package com.tnas.assignment.statistics;

public enum StatisticsOption {

	QUIT("Quit de program"),
	POPULATION_GROWTH("To get population growth in percentages from each consecutive year"),
	MIN_MURDER_RATES("To get the year where the minimum murder rates occurred"),
	MAX_MURDER_RATES("To get the year where the maximum murder rates occurred"),
	MIN_ROBBERY_RATES("To get the year where the minimum robbery rates occurred"),
	MAX_ROBBERY_RATES("To get the year where the maximum robbery rates occurred");
	
	private String description;
	
	private StatisticsOption(String desc) {
		this.description = desc;
	}

	public String getDescription() {
		return this.description;
	}
}
