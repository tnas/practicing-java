package com.tnas.assignment.lottery;

import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int ticketSize = 6;
		int numberOfTickets;
				
		try {
			System.out.println("Enter the number of tickets to buy: ");
			numberOfTickets = scanner.nextInt();
					
			int[][]lottery = new int[numberOfTickets][ticketSize];
					
			for (int i = 0; i < numberOfTickets; ++i) {
						
				for (int j = 0; j < ticketSize; ++j) {
							
					System.out.println(String.format(
					"Enter your number %d for the ticket %d: ", 
						j, i));
					lottery[i][j] = scanner.nextInt();	
				}
			}
		} catch (Exception e) {
			System.out.println("Internal error.");
			e.printStackTrace();
		}
				
		scanner.close();
	}
}
