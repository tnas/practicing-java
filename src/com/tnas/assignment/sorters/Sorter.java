package com.tnas.assignment.sorters;

import java.util.stream.IntStream;

public class Sorter {

	private static final int RANDOM_FACTOR = 1000;
	int size;
	int[] sequence;
	int[] sortedSequence;
			
	public void loadSequence(int size) {
		this.size = size;
		this.sequence = new int[size];
		this.sortedSequence = new int[size];
		IntStream.range(0, size).forEach(i -> this.sequence[i] = (int) (Math.random() * RANDOM_FACTOR));
	}
	
	public void runBubbleSort() {
		
		IntStream.range(0, size).forEach(i -> this.sortedSequence[i] = this.sequence[i]);
		
		int pass = 0;
		
		while (pass < this.size - 1) {
			
			int item = this.size - 1;
			
			while (item > pass) {
				
				if (this.sortedSequence[item] < this.sortedSequence[item - 1]) {
					this.swap(item, item - 1, this.sortedSequence);
				}
				
				item -= 1;
			}
			
			pass++;
		}
	}
	
	public void runSelectionSort() {
		
		IntStream.range(0, size).forEach(i -> this.sortedSequence[i] = this.sequence[i]);
		
		int pass = 0;
		
		while (pass < this.size - 1) {
			
			int position = pass;
			int item = pass + 1;
			
			while (item < this.size) {
				
				if (this.sortedSequence[position] > this.sortedSequence[item]) {
					position = item;
				}
				
				item++;
			}
			
			if (pass != position) {
				this.swap(pass, position, this.sortedSequence);
			}
			
			pass++;
		}
	}
	
	public void runInsertionSort() {
		
		IntStream.range(0, size).forEach(i -> this.sortedSequence[i] = this.sequence[i]);
		
		int ordered = 0;
		int pass = ordered;
		
		while (pass < this.size - 1) {
			
			int item = pass + 1;
			
			while (item > 0 && this.sortedSequence[item] < this.sortedSequence[item - 1]) {
				this.swap(item - 1, item, this.sortedSequence);
				item--;
			}
			
			pass++;
		}
	}
	
	public void printOriginalSequence() {
		System.out.print("Original: ");
		for (int e : this.sequence) {
			System.out.print(e + " ");
		}
	}
	
	public void printSortedSequence() {
		System.out.print("Sorted:   ");
		for (int e : this.sortedSequence) {
			System.out.print(e + " ");
		}
	}
	
	private void swap(int from, int to, int[] array) {
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

}
