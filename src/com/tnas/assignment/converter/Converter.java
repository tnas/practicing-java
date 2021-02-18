package com.tnas.assignment.converter;

public class Converter {

	private double value;
	
	public Converter() {
		this.value = Double.NaN;
	}

	public Converter(double value) {
		this.value = value;
	}

	public double convert() {
		return this.value;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
