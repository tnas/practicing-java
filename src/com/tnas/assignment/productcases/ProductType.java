package com.tnas.assignment.productcases;

public enum ProductType {
	
	COMPUTER_MEMORY, KEYBOARD, MOUSE;
	
	public static ProductType fromId(int id) {
		if (id == 0) return COMPUTER_MEMORY;
		else if (id == 1) return KEYBOARD;
		else if (id == 2) return MOUSE;
		else throw new RuntimeException("Unavailable Product!"); 
	}
}
