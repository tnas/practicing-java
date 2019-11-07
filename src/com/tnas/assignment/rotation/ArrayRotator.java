package com.tnas.assignment.rotation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayRotator {

	public static void rotateArary(Integer[] numbers, Integer rotationCount) {
		IntStream.range(1, rotationCount+1).forEach(r -> {
			int firstElement = numbers[0];
			IntStream.range(0, numbers.length-1).forEach(n -> numbers[n] = numbers[n + 1]);
			numbers[numbers.length-1] = firstElement;
			String ordinal = r == 1 ? "st" : r == 2 ? "nd" : r == 3 ? "rd" : "th";
			System.out.print(String.format("After %d%s rotation the array contents are ", r, ordinal));
			Arrays.asList(numbers).forEach(n -> System.out.print(n + " "));
			System.out.println("\n");
		});
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		double maxNumber = 100.0;
		double minNumber = 1.0;
		int arraySize = 7;
		
		Integer[] numbers = new Integer[arraySize];
		IntStream.range(0, arraySize)
			.forEach(i -> numbers[i] =  (int) (Math.random()*((maxNumber-minNumber)+1)+minNumber));
		
		System.out.print("The random generated integers in array are: ");
		Arrays.asList(numbers).forEach(n -> System.out.print(n + " "));
		
		int sumEvenPositions = 
				IntStream.range(0, arraySize).filter(n -> n % 2 == 0).map(n -> numbers[n]).sum();
		System.out.print("\n\nSum of numbers at even indexes =  " + sumEvenPositions);
		
		
		int avgOddPositions = (int)
				IntStream.range(0, arraySize).filter(n -> n % 2 == 1).map(n -> numbers[n]).average().getAsDouble(); 
		System.out.print("\n\nAverage of numbers at odd indexes =  " + avgOddPositions);
		
		System.out.print("\n\nEnter rotation count: ");
		int rotationCount = scan.nextInt();
		scan.close();
		
		System.out.println(String.format("\nCalling rotateArray with rotation count as %d ....\n", rotationCount));
		ArrayRotator.rotateArary(numbers, rotationCount);
	}
}
