package com.tnas.assignment.selectionsort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	private static final int MAX_NUMBER = 100;
	private int numberOfElements;
	private int[] elements;
	
	public SelectionSort(int numberOfelements) {
		this.numberOfElements = numberOfelements;
		this.elements = new int[numberOfelements];
		this.elements = new Random().ints(this.numberOfElements, 0, MAX_NUMBER).toArray();
	}
	
	public void run() {
		
		for (int index = 0; index < this.numberOfElements - 1; ++index) {
			
			int indexMinimal = index;
			
			for (int idxMin = index + 1; idxMin < this.numberOfElements; ++idxMin) 
				if (elements[idxMin] < elements[indexMinimal]) indexMinimal = idxMin;
			
			int swap = elements[indexMinimal];
			elements[indexMinimal] = elements[index];
			elements[index] = swap;
		}
	}
	
	public String toString() {
		return Arrays.toString(this.elements);
	}
	
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort(20);
		System.out.println("Array before sorting:");
		System.out.println(selectionSort);
		selectionSort.run();
		System.out.println("Array after sorting:");
		System.out.println(selectionSort);
	}
}
