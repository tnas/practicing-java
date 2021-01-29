package com.tnas.assignment.ordersystem;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program offers an Order System in which a user might select
 * two types of gifts: {@link FruitBasket} and {@link SweetsBasket}.
 * The main attributes of each type of gift are stored in the system, 
 * but the user can define some of them.
 * 
 * Additional information may be found on my LinkedIn:
 * {@link https://www.linkedin.com/in/thiagonascimentorodrigues/} 
 * 
 * @author What's my name?
 * 
 * @since January 29, 2021
 *
 */
public class OrderSystem {

	private void displayMenu() {
		System.out.println("    MENU");
		Arrays.asList(OrderSystemOption.values()).forEach(o -> 
			System.out.println(String.format("%d: %s", o.id(), o.description())));
	}
	
	private OrderSystemOption getOption(Scanner scan) {
		
		OrderSystemOption opt = null;
		System.out.println("\nEnter your selection: ");
		
		try {
			opt = OrderSystemOption.fromId(scan.nextInt());
		}
		catch (InputMismatchException ie) {
			System.out.println("Invalid Option!");
			scan.next();
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		return opt;
	}
	
	private Gift orderGift(Scanner scan) {
		
		Gift gift = null;
		int optBasket = 0;
		String optSize = null;
		
		System.out.println("Do you want Fruit Basket (1) or Sweet Basket (2): ");
		optBasket = scan.nextInt();
		
		System.out.println("What size do you want: S, M, or L:");
		optSize = scan.next();
		
		if (optBasket == FruitBasket.ID_TYPE) {
			System.out.println("Do you want citrus fruits included? true/false:");
			boolean optCitrus = scan.nextBoolean();
			gift = new FruitBasket(GiftSize.fromId(optSize), optCitrus);
		}
		else if (optBasket == SweetsBasket.ID_TYPE) {
			System.out.println("Do you want nuts included? true/false:");
			boolean optNuts = scan.nextBoolean();
			gift = new SweetsBasket(GiftSize.fromId(optSize), optNuts);
		}
		
		return gift;
	}
	
	private void changeFruitGift(Scanner scan, FruitBasket gift) {
		System.out.println(String.format("Current gift size is: %s. What size do you want? S, M, or L:", 
				gift.getSize().id()));
		String optSize = scan.next();
		
		System.out.println(String.format("Current basket citrus=%s. Do you want citrus fruits included? true/false: ", 
				gift.isHasCitrusFruits()));
		boolean optCitrus = scan.nextBoolean();
		
		gift.setSize(GiftSize.fromId(optSize));
		gift.setHasCitrusFruits(optCitrus);
	}
	
	private void changeSweetGift(Scanner scan, SweetsBasket gift) {
		System.out.println(String.format("Current gift size is: %s. What size do you want? S, M, or L:", 
				gift.getSize().id()));
		String optSize = scan.next();
		
		System.out.println(String.format("Current basket nuts=%s. Do you want nuts included? true/false: ", 
				gift.hasNuts()));
		boolean optCitrus = scan.nextBoolean();
		
		gift.setSize(GiftSize.fromId(optSize));
		gift.setHasNuts(optCitrus);
	}
	
	public static void main(String[] args) {
		
		OrderSystem orderSystem = new OrderSystem();
		Scanner scan = new Scanner(System.in);
		OrderSystemOption opt = null;
		Gift gift = null;
		
		/*
		 * Main loop of the program. It's a command line
		 * interface between system and user.
		 */
		while (opt != OrderSystemOption.EXIT) {
			
			orderSystem.displayMenu();
			opt = orderSystem.getOption(scan);
			if (opt == null) continue;
			
			switch (opt) {
			
			case ORDER:
				gift = orderSystem.orderGift(scan);
				break;
				
			case CHANGE:
				if (gift == null) {
					System.out.println("No gift has been ordered yet\n");
				}
				else {
					if (gift instanceof FruitBasket)
						orderSystem.changeFruitGift(scan, (FruitBasket) gift);
					else
						orderSystem.changeSweetGift(scan, (SweetsBasket) gift);
				}
				break;
				
			case DISPLAY:
				System.out.println(gift == null ? "No gift has been ordered yet\n" : gift.toString().concat("\n"));
				break;
				
			case EXIT:
				System.out.println("\nThank you for using the program. Goodbye!");
				break;

			default:
				// Invalid option.
			}
		}
		
		scan.close();
	}
}
