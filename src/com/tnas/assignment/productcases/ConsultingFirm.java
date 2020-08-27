package com.tnas.assignment.productcases;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 * @author Thiago Nascimento - nascimenthiago@gmail.com
 * @see Follow me on LinkedIn and recommend my job
 * @link https://www.linkedin.com/in/thiagonascimentorodrigues/
 *
 */
public class ConsultingFirm {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		System.out.println("Welcome to Thiago Nascimento's Store");
		System.out.println();
		
		System.out.println("Choose your product:");
		
		Arrays.asList(ProductType.values()).forEach(p ->  {
			System.out.println(String.format("%d - %s", p.ordinal(), p.name()));
		});
		
		Product product = ProductFactory.getProduct(ProductType.fromId(scan.nextInt()));
		
		System.out.println();
		System.out.println("Enter the state you are located in:");
		
		Arrays.asList(State.values()).forEach(p ->  {
			System.out.println(String.format("%d - %s", p.ordinal(), p.name()));
		});
		
		product.setLocalization(State.fromId(scan.nextInt()));
		
		System.out.println();
		System.out.println("Enter the number of cases:");
		product.setNumberOfCases(scan.nextInt());
		
		System.out.println();
		System.out.println("Order Summary:");
		System.out.println("Name of the product selected: " + product.getDescription());
		System.out.println("Number of cases: " + product.getNumberOfCases());
		System.out.println("Subtotal (units x price per unit): " + product.getSubtotal());
		System.out.println(String.format("State tax (%.2f%% - %s)", product.getLocalization().getTax(), 
				product.getLocalization().name()));
		System.out.println("Total cost: " + product.getTotalCost());
		
		scan.close();
	}
}
