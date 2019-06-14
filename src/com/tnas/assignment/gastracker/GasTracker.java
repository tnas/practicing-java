package com.tnas.assignment.gastracker;

import java.util.Locale;
import java.util.Scanner;

public class GasTracker {

	private static final int FILL_UP_NUMBER = 5;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		double totalGallons = 0;
		double totalMiles = 0;
		double miles, gallons;
		
		for (int fillUp = 1; fillUp <= FILL_UP_NUMBER; ++fillUp) {
			
			System.out.println(String.format("Please enter the number of miles driven for fill-up %d", fillUp));
			miles = scan.nextDouble();
			
			System.out.println(String.format("Please enter the number of gallons for fill-up %d", fillUp));
			gallons = scan.nextDouble();
			
			System.out.println(String.format("You drove %.2f miles and used %.2f gallons. "
					+ "You averaged %.2f miles per gallon on fillup %d", miles, gallons, miles/gallons, fillUp));
			
			totalMiles += miles;
			totalGallons += gallons;
		}
		
		System.out.println(String.format("You drove a total of %.2f miles and used %.2f gallons. "
				+ "You averaged %.2f miles per gallon for the %d fill-ups", 
				totalMiles, totalGallons, totalMiles/totalGallons, FILL_UP_NUMBER));
		
		scan.close();
	}
}
