package com.tnas.assignment.gpacalculator;

import java.util.ArrayList;
import java.util.List;
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
public class GPACalculator {
	
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
		String[] fullName = scan.nextLine().split(" ");
		String firstName = fullName[0].trim();
		String lastName = fullName[1].trim();
		
		System.out.println("Enter your major:");
		String major = scan.nextLine().trim();
		
		List<Course> courses = new ArrayList<>();
		boolean hasMoreCourses = true;
		
		while (hasMoreCourses) {
			
			System.out.println("Enter the course name:");
			String courseName = scan.nextLine();
			
			System.out.println("Enter the number of credits:");
			int credits = scan.nextInt();
			
			System.out.println("Enter your grade according to the Quality Points chart below:");
			showQualityPointsChart();
			float grade = scan.nextFloat();
			
			courses.add(new Course(courseName, credits, grade));
			
			System.out.println("Are there more courses to be added? (y/n)");
			hasMoreCourses = scan.next().equals("y");
			scan.nextLine(); // Consuming newline left-over
		}
		
		scan.close();
		
		double sumGrades  = courses.stream().mapToDouble(c -> c.grade_ * c.credits_).sum();
		int sumCredits = courses.stream().mapToInt(c -> c.credits_).sum();
		System.out.println(String.format("%s, your GPA is %.2f", lastName, sumGrades/sumCredits));		
	}
}

class Course {
	String name_;
	int credits_;
	float grade_;
	public Course(String name, int credits, float grade) {
		name_ = name;
		credits_ = credits;
		grade_ = grade;
	}
}
