package com.tnas.assignment.gpacalculator;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class responsible for the interaction with the user. It collects
 * the data of two students and prints in the console the grade
 * average of each one.
 * 
 * @since October 14, 2019
 */
public class Part2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		// Prompting the data of the first student - name and grades
		System.out.println("Prompting data of Student 1:");
		System.out.println("Enter the first name:");
		String firstNameSt1 = scan.next();
		System.out.println("Enter the last name:");
		String lastNameSt1 = scan.next();
		System.out.println("Enter the first homework grade:");
		float hw1St1 = scan.nextFloat();
		System.out.println("Enter the second homework grade:");
		float hw2St1 = scan.nextFloat();
		System.out.println("Enter the first quiz grade:");
		float quiz1St1 = scan.nextFloat();
		System.out.println("Enter the second quiz grade:");
		float quiz2St1 = scan.nextFloat();
		System.out.println("Enter the third quiz grade:");
		float quiz3St1 = scan.nextFloat();
		System.out.println("Enter the first exam grade:");
		float exam1St1 = scan.nextFloat();
		System.out.println("Enter the second exam grade:");
		float exam2St1 = scan.nextFloat();
		UNGStudent student1 = new UNGStudent(firstNameSt1, lastNameSt1, hw1St1, 
				hw2St1, quiz1St1, quiz2St1, quiz3St1, exam1St1, exam2St1);
		
		// Prompting the data of the second student - name and grades
		System.out.println("Prompting data of Student 2:");
		System.out.println("Enter the first name:");
		String firstNameSt2 = scan.next();
		System.out.println("Enter the last name:");
		String lastNameSt2 = scan.next();
		System.out.println("Enter the first homework grade:");
		float hw1St2 = scan.nextFloat();
		System.out.println("Enter the second homework grade:");
		float hw2St2 = scan.nextFloat();
		System.out.println("Enter the first quiz grade:");
		float quiz1St2 = scan.nextFloat();
		System.out.println("Enter the second quiz grade:");
		float quiz2St2 = scan.nextFloat();
		System.out.println("Enter the third quiz grade:");
		float quiz3St2 = scan.nextFloat();
		System.out.println("Enter the first exam grade:");
		float exam1St2 = scan.nextFloat();
		System.out.println("Enter the second exam grade:");
		float exam2St2 = scan.nextFloat();
		UNGStudent student2 = new UNGStudent(firstNameSt2, lastNameSt2, hw1St2, hw2St2, 
				quiz1St2, quiz2St2, quiz3St2, exam1St2, exam2St2);
		
		// Reseting the grade of the student 2
		student2.setGrades(97, 77, 84, 91, 64, 55, 72);
		
		// Calculating averages for each student
		float hmAvgStd1 = student1.calcHW();
		float quizAvgStd1 = student1.calcQuiz();
		float examAvgStd1 = student1.calcExam();
		float gradeAvgStd1 = hmAvgStd1 + quizAvgStd1 + examAvgStd1;
		
		float hmAvgStd2 = student2.calcHW(); 
		float quizAvgStd2 = student2.calcQuiz(); 
		float examAvgStd2 = student2.calcExam();
		float gradeAvgStd2 = hmAvgStd2 + quizAvgStd2 + examAvgStd2;
		
		// Printing the full name and grade average of each student
		System.out.println(String.format("%s - Final Average %f", student1.getFullName(), gradeAvgStd1));
		System.out.println(String.format("%s - Final Average %f", student2.getFullName(), gradeAvgStd2));
		
		scan.close();
	}
}
