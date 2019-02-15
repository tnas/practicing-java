package com.tnas.assignment.plantgrow;
import java.util.Scanner;

public class PlantTracker {

	private static final int DEAD_PLANT = -1;
	private static final int SMALLEST_HEIGHT = 0;
	private static final int NUMBER_OF_MONTHS = 12;
	private static final String STRING_HEADER_FORMAT =
			"%1$-10s %2$-5s %3$-5s %4$-10s %5$-3s";
	private static final String STRING_GROWTH_FORMAT =
			"%1$-10d %2$-5d %3$-5d %4$-13d %5$-3d";
	
	public static void main(String[] args) {

		int[] newGrowth = new int[NUMBER_OF_MONTHS];
		int[] avgTemp   = { 46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47 };
		int[] avgRain   = { 5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4 };
		int minTemp, maxTemp, minRainFall, plantHeight;
		
		// Setting plant initial height
		plantHeight = SMALLEST_HEIGHT;
		
		// Reading the tolerances of the plant from the user
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter minimum temperature for plant: ");
		minTemp = scanner.nextInt();
		
		System.out.print("Enter maximum temperature for plant: ");
		maxTemp = scanner.nextInt();
		
		System.out.print("Enter minimum rainfall for plant: ");
		minRainFall = scanner.nextInt();
	
		scanner.close();
		
		// Printing the heading of the plant growth
		System.out.println(String.format(STRING_HEADER_FORMAT, 
				"Month", "Temp", "Rain", "Growth", "Height"));
		
		// Printing the monthly plant growth 
		 for (int month = 0; month < NUMBER_OF_MONTHS; ++month) {
			 
			 if (avgTemp[month] < minTemp || avgTemp[month] > maxTemp) {
				 newGrowth[month] = DEAD_PLANT; // plant dies
			 }
			 else {
				 newGrowth[month] = avgRain[month] - minRainFall;
			 }
			 
			 plantHeight += newGrowth[month];
			 
			 if (plantHeight < SMALLEST_HEIGHT) {
				 plantHeight = SMALLEST_HEIGHT;
			 }
			 
			 System.out.println(String.format(STRING_GROWTH_FORMAT, month, 
					 avgTemp[month], avgRain[month], newGrowth[month], plantHeight));
		 }
	}
}
