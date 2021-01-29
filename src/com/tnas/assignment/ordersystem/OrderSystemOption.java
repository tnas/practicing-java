package com.tnas.assignment.ordersystem;

public enum OrderSystemOption {

	ORDER(1, "Order a Gift Basket"),
	CHANGE(2, "Change Gift Basket"),
	DISPLAY(3, "Display Gift"),
	EXIT(9, "Exit program");
	
	private int id;
	
	private String description;
	
	private OrderSystemOption(int id, String desc) {
		this.id = id;
		this.description = desc;
	}
	
	public int id() {
		return id;
	}
	
	public String description() {
		return this.description;
	}
	
	public static OrderSystemOption fromId(int id) {
		if (id == ORDER.id()) return ORDER;
		else if (id == CHANGE.id()) return CHANGE;
		else if (id == DISPLAY.id()) return DISPLAY;
		else if (id == EXIT.id()) return EXIT;
		else throw new RuntimeException("Invalid Option!");
	}
}
