package com.tnas.assignment.selectionsort;


public class TestSuite {
		
	public static void main(String[] args) {
		int[] elements = { 5, 7, 4, 9, 8, 5, 6, 3 };
		SelectionSort selectionSort = new SelectionSort(elements);
		selectionSort.runTraced();
	}
}
