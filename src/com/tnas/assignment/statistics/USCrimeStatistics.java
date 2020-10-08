package com.tnas.assignment.statistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class USCrimeStatistics {

	private final USCrime[] crimes;

	public USCrimeStatistics(USCrime[] crimes) {
		this.crimes = crimes;
	}

	public void getPopulationGrouth() {
		System.out.println("Population Grouth in Percentages:");
		float rateNextYear, rateCurrYear;
		int nextYear, currYear;
		for (int pos = 0; pos < this.crimes.length - 1; ++pos) {
			rateNextYear = this.crimes[pos + 1].getPopulation();
			rateCurrYear = this.crimes[pos].getPopulation();
			nextYear = this.crimes[pos + 1].getYear();
			currYear = this.crimes[pos].getYear();
			float rate = ((rateNextYear - rateCurrYear) / rateCurrYear) * 100;
			System.out.println(String.format("%d-%d: %.4f%%", currYear, nextYear, rate));
		}
	}

	public void getMaxMurderYear() {
		System.out.println("Year where the maximum Murder rates occurred:");
		USCrime max = Arrays.stream(this.crimes).max(Comparator.comparing(USCrime::getMurderRate))
				.orElseThrow(NoSuchElementException::new);
		System.out.println(String.format("Year: %d - Rate: %.2f%%", max.getYear(), max.getMurderRate()));
	}

	public void getMinMurderYear() {
		System.out.println("Year where the minimum Murder rates occurred:");
		USCrime min = Arrays.stream(this.crimes).min(Comparator.comparing(USCrime::getMurderRate))
				.orElseThrow(NoSuchElementException::new);
		System.out.println(String.format("Year: %d - Rate: %.2f%%", min.getYear(), min.getMurderRate()));
	}
	
	public void getMaxRobberyYear() {
		System.out.println("Year where the maximum Robbery rates occurred:");
		USCrime max = Arrays.stream(this.crimes)
				.max(Comparator.comparing(USCrime::getRobberyRate))
				.orElseThrow(NoSuchElementException::new);
		System.out.println(String.format("Year: %d - Rate: %.2f%%", max.getYear(), max.getRobberyRate()));
	}

	public void getMinRobberyYear() {
		System.out.println("Year where the minimum Robbery rates occurred:");
		USCrime min = Arrays.stream(this.crimes).min(Comparator.comparing(USCrime::getRobberyRate))
				.orElseThrow(NoSuchElementException::new);
		System.out.println(String.format("Year: %d - Rate: %.2f%%", min.getYear(), min.getRobberyRate()));
	}
}
