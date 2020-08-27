package com.tnas.assignment.productcases;

public class ProductFactory {
	
	public static Product getProduct(ProductType type) {
		
		switch (type) {
		
		case COMPUTER_MEMORY:
			return new ComputerMemory();
			
		case KEYBOARD:
			return new Keyboard();
			
		case MOUSE:
			return new Mouse();
			
		default:
			throw new RuntimeException("Unavailable Product!");
		}
	}
}
