package com.tnas.assignment.ordersystem;

public class FruitBasket extends Gift {
	
	public static final int ID_TYPE = 1;
	private static final String PREFIX_ID = "FB";
	private static final float CITRUS_FEE = 5.99f;

	private int numberOfFruits;
	
	private boolean hasCitrusFruits;

	public FruitBasket(GiftSize size, boolean hasCitrusFruits) {
		super(PREFIX_ID.concat(String.valueOf(Gift.ID++)), size);
		this.hasCitrusFruits = hasCitrusFruits;
	}

	public int getNumberOfFruits() {
		return numberOfFruits;
	}

	public boolean isHasCitrusFruits() {
		return hasCitrusFruits;
	}

	public void setHasCitrusFruits(boolean hasCitrusFruits) {
		this.hasCitrusFruits = hasCitrusFruits;
	}

	@Override
	public float getPrice() {
		return this.hasCitrusFruits ? 
				super.getPrice() + CITRUS_FEE : super.getPrice();
	}

	@Override
	public String toString() {
		return "FruitBasket [numberFruits=" + getSize().numberOfFruits() + ", haveCitrus=" + hasCitrusFruits
				+ ", size=" + getSize().id() + ", id=" + getId() + ", price=" + getPrice() + "]";
	}
	
}
