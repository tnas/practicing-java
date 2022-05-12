package com.tnas.assignment.sorters;

import java.util.Scanner;

public class SorterTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the array size: ");
		int arraySize = scanner.nextInt();
		
		Sorter sorter = new Sorter();
		sorter.loadSequence(arraySize);
		sorter.printOriginalSequence();
		
		System.out.println("\n=== Bubble Sort ===");
		sorter.runBubbleSort();
		sorter.printSortedSequence();
		
		System.out.println("\n=== Selection Sort ===");
		sorter.runSelectionSort();
		sorter.printSortedSequence();
		
		System.out.println("\n=== Insertion Sort ===");
		sorter.runInsertionSort();
		sorter.printSortedSequence();
		
		scanner.close();
	}

}
