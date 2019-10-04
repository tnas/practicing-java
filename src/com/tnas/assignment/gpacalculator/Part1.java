package com.tnas.assignment.gpacalculator;

import java.util.Locale;
import java.util.Scanner;

/**
 * This class represents the UNG GPA Calculator. It is responsible for 
 * interact with the user in order to get data to be used for
 * the GPA calculus.
 * 
 * @since October 4 2019
 *
 */
public class Part1 {
	
	/**
	 * Method that prints the Quality Points chart in the console.
	 */
	private static void showQualityPointsChart() {
		System.out.println("--------- Quality Points Chart ---------");
		System.out.println("A  4.00		A- 3.67");
		System.out.println("B+ 3.33		B  3.00		B- 2.67");
		System.out.println("C+ 2.33		C  2.00		C- 1.67");
		System.out.println("D+ 1.33		D  1.00		F  0.00");
		System.out.println("----------------------------------------");
	}
	
	public static void main(String[] args) {
		
		// Prompting the full name of the user and the respective major
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		System.out.println("Welcome to the UNG GPA Calculator");
		
		System.out.println("Enter your full name:");
		String fullName = scan.nextLine().trim();
		int indexNameSeparator = fullName.indexOf(" ");
		String firstName = fullName.substring(0, indexNameSeparator);
		String lastName = fullName.substring(indexNameSeparator).trim();
		
		System.out.println("Enter your major:");
		String major = scan.nextLine().trim();

		// Getting the data of course 1
		System.out.println("Enter the course name 1:");
		String courseName1 = scan.nextLine();
		System.out.println("Enter the number of credits:");
		int credits1 = scan.nextInt();
		System.out.println("Enter your grade according to the Quality Points chart below:");
		showQualityPointsChart();
		float grade1 = scan.nextFloat();
		scan.nextLine(); // Consuming newline left-over
		
		// Getting the data of course 2
		System.out.println("Enter the course name 2:");
		String courseName2 = scan.nextLine();
		System.out.println("Enter the number of credits:");
		int credits2 = scan.nextInt();
		System.out.println("Enter your grade according to the Quality Points chart below:");
		showQualityPointsChart();
		float grade2 = scan.nextFloat();
		scan.nextLine(); // Consuming newline left-over
		
		// Getting the data of course 3
		System.out.println("Enter the course name 3:");
		String courseName3 = scan.nextLine();
		System.out.println("Enter the number of credits:");
		int credits3 = scan.nextInt();
		System.out.println("Enter your grade according to the Quality Points chart below:");
		showQualityPointsChart();
		float grade3 = scan.nextFloat();
		scan.nextLine(); // Consuming newline left-over
		
		// Getting the data of course 4
		System.out.println("Enter the course name 4:");
		String courseName4 = scan.nextLine();
		System.out.println("Enter the number of credits:");
		int credits4 = scan.nextInt();
		System.out.println("Enter your grade according to the Quality Points chart below:");
		showQualityPointsChart();
		float grade4 = scan.nextFloat();
			
		scan.close();
		
		double sumGrades  = credits1*grade1 + credits2*grade2 + credits3*grade3 +credits4*grade4;
		int sumCredits = credits1 + credits2 + credits3 + credits4;
		System.out.println(String.format("%s - %.2f", lastName, sumGrades/sumCredits));		
	}
}

