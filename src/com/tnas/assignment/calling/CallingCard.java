package com.tnas.assignment.calling;

import java.util.Locale;
import java.util.Scanner;

/**
 * 
 * @author Student's name
 * @since Date
 * 
 * The program calculates the balance of a pre-paid calling card.
 * It receives as input three types of callings:  in the US, to Europe, and to Australia..
 * The user must enter the number of calls and the total of minutes. 
 * The program displays a summary of all callings and the final balance of
 * the calling card.
 *
 */
public class CallingCard {

	// Final variables - constants
	public static final int US = 0;
	public static final int EUROPE = 1;
	public static final int AUSTRALIA = 2;
	public static final double[] centsPerMin = { 0.012, 0.023, 0.064 };
	public static final double feePerCall = 0.49;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		int[] totalCalls = new int[3];
		int[] durationCalls = new int[3];
		double[] totalPrice = { 0, 0, 0 };
		int sumCalls = 0;
		int sumMins = 0;
		double sumPrices = 0;
		
		System.out.println("Fox International Calling Card Calculator");
		
		System.out.print("Enter account holders name: ");
		String holderName = scan.nextLine().trim();
		
		System.out.print("Enter card number: ");
		String cardNumber = scan.nextLine().trim();
		
		System.out.print("Starting balance on card: ");
		Double balance = scan.nextDouble();
		
		System.out.println("-------------------------------------------------");
		
		// Getting data of US calls
		System.out.println("US calls");
		System.out.print("	Total # of US calls: ");
		totalCalls[US] = scan.nextInt();
		System.out.print("	Total duration of ALL US calls in minutes: ");
		durationCalls[US] = scan.nextInt();
		totalPrice[US] = (totalCalls[US] * feePerCall) + (durationCalls[US] * centsPerMin[US]);
		sumCalls += totalCalls[US];
		sumMins += durationCalls[US];
		sumPrices += totalPrice[US];
		
		// Getting data of calls to Europe
		System.out.println("European calls");
		System.out.print("	Total # of calls to Europe: ");
		totalCalls[EUROPE] = scan.nextInt();
		System.out.print("	Total duration of ALL calls to Europe calls in minutes: ");
		durationCalls[EUROPE] = scan.nextInt();
		totalPrice[EUROPE] = (totalCalls[EUROPE] * feePerCall) + (durationCalls[EUROPE] * centsPerMin[EUROPE]);
		sumCalls += totalCalls[EUROPE];
		sumMins += durationCalls[EUROPE];
		sumPrices += totalPrice[EUROPE];
		
		// Getting data of calls to Europe
		System.out.println("Australian calls");
		System.out.print("	Total # of calls to Australia: ");
		totalCalls[AUSTRALIA] = scan.nextInt();
		System.out.print("	Total duration of ALL calls to Australia calls in minutes: ");
		durationCalls[AUSTRALIA] = scan.nextInt();
		totalPrice[AUSTRALIA] = (totalCalls[AUSTRALIA] * feePerCall) + (durationCalls[AUSTRALIA] * centsPerMin[AUSTRALIA]);
		sumCalls += totalCalls[AUSTRALIA];
		sumMins += durationCalls[AUSTRALIA];
		sumPrices += totalPrice[AUSTRALIA];
		
		System.out.println("\n\n------------------------------------------------------------------");
		
		// Displaying the summary
		System.out.println("		Charge Summary\n");
		System.out.println(String.format("%1$20s %2$10s %3$10s %4$10s", "Description", "Calls", "Min", "Total"));
		String lineFormat = "%1$20s %2$10d %3$10d %4$10.2f";
		System.out.println(String.format(Locale.US, lineFormat, "US Charges", totalCalls[US], durationCalls[US], totalPrice[US]));
		System.out.println(String.format(Locale.US, lineFormat, "Euro Charges", totalCalls[EUROPE], durationCalls[EUROPE], totalPrice[EUROPE]));
		System.out.println(String.format(Locale.US, lineFormat, "Aussie Charges", totalCalls[AUSTRALIA], durationCalls[AUSTRALIA], totalPrice[AUSTRALIA]));
		System.out.println(String.format(Locale.US, lineFormat, "Total", sumCalls, sumMins, sumPrices));
		
		System.out.println(String.format(Locale.US, "\n\nCard Balance: $%.2f", balance - sumPrices));
	}
}
