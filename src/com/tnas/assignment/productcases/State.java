package com.tnas.assignment.productcases;

public enum State {

	CT(7.5),
	VT(7.8),
	WI(6.8),
	CA(7.2),
	WA(6.4);	
	
	private double tax;
	
	private State(double tax) {
		this.tax = tax;
	}
	
	public double getTax() {
		return this.tax;
	}
	
	public static State fromId(int id) {
		if (id == 0) return CT;
		else if (id == 1) return VT;
		else if (id == 2) return WI;
		else if (id == 3) return CA;
		else if (id == 4) return WA;
		else throw new RuntimeException("Invalid State!");
	}
}
