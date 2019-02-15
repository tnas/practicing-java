package com.tnas.assignment.fraction;
import java.util.Scanner;

public class FractionTester {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("== F1 ==");
		Fraction f1 = new Fraction(scanner);
		
		System.out.println("== F2 ==");
		Fraction f2 = new Fraction(scanner);
		
		System.out.println();
		
		System.out.println("F1: " + f1);
		System.out.println("F2: " + f2);
		
		System.out.println("F1+F1: " + f1.plus(f1));
		System.out.println("F2+F2: " + f2.plus(f2));
		System.out.println("F1+F2: " + f1.plus(f2));
		System.out.println("F2+F1: " + f2.plus(f1));
		
		System.out.println("F1-F1: " + f1.minus(f1));
		System.out.println("F2-F2: " + f2.minus(f2));
		System.out.println("F1-F2: " + f1.minus(f2));
		System.out.println("F2-F1: " + f2.minus(f1));
		
		System.out.println("F1*F1: " + f1.times(f1));
		System.out.println("F2*F2: " + f2.times(f2));
		System.out.println("F1*F2: " + f1.times(f2));
		System.out.println("F2*F1: " + f2.times(f1));
		
		System.out.println("F1/F1: " + f1.divides(f1));
		System.out.println("F2/F2: " + f2.divides(f2));
		System.out.println("F1/F2: " + f1.divides(f2));
		System.out.println("F2/F1: " + f2.divides(f1));
		
		System.out.println("F1*F1-F2: " + f1.times(f1).minus(f2));
		
		scanner.close();
	}
}
