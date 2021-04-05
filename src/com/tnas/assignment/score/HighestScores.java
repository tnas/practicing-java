package com.tnas.assignment.score;

/**
 * <your name>
 * 
 * COSC 1336
 * 
 * Programming Assignment 5
 * 
 * Due:  March 19, 2021
 * 
 * A program that prompts the user to enter the number of students 
 * and each student’s name and score and finally displays the student 
 * with the highest score and the student with the second highest score.
 *  
 */

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HighestScores {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		System.out.print("Enter the number of students: ");
		int numberOfStudents = scan.nextInt();
		String[] students = new String[2];
		float[] scores = { Float.MIN_VALUE, Float.MIN_VALUE };
		
		IntStream.rangeClosed(1, numberOfStudents).forEach(n -> {
			System.out.print("Enter a student name: ");
			String student = scan.next();
			System.out.print("Enter a student score: ");
			float score = scan.nextFloat();
			
			if (score > scores[0]) {
				scores[1]   = scores[0];
				students[1] = students[0];
				scores[0]   = score;
				students[0] = student;
			}
		});
		
		System.out.println(String.format("%s's score is: %.1f", students[0], scores[0]));
		System.out.println(String.format("%s's score is: %.1f", students[1], scores[1]));
		
		scan.close();
	}
}
