package com.tnas.assignment.productcases;

public abstract class Product {
	
	private static final int ITENS_PER_CASE = 12;
	
	private State localization;
	private int numberOfCases;
	
	public abstract String getDescription();
	public abstract double getPricePerUnit();

	public double getSubtotal() {
		return this.numberOfCases * ITENS_PER_CASE * getPricePerUnit(); 
	}
	
	public double getTotalCost() {
		return getSubtotal() * (getLocalization().getTax() / 100 + 1); 
	}
	
	public State getLocalization() {
		return localization;
	}

	public void setLocalization(State localization) {
		this.localization = localization;
	}

	public int getNumberOfCases() {
		return numberOfCases;
	}

	public void setNumberOfCases(int numberOfCases) {
		this.numberOfCases = numberOfCases;
	}
	
}
