package com.tnas.assignment.ordersystem;

public enum GiftSize {

	Small("S", 19.99f, 6),
	Medium("M", 29.99f, 9),
	Large("L", 39.99f, 15);
	
	private String id;
	private float flatFee;
	private int numberOfFruits;
	
	private GiftSize(String id, float fee, int fruits) {
		this.id = id;
		this.flatFee = fee;
		this.numberOfFruits = fruits;
	}
	
	public String id() {
		return this.id;
	}
	
	public float flatFee() {
		return this.flatFee;
	}
	
	public int numberOfFruits() {
		return this.numberOfFruits;
	}
	
	public static GiftSize fromId(String id) {
		if (id.equals(Small.id())) return Small;
		else if (id.equals(Medium.id())) return Medium;
		else return Large;
	}
}
