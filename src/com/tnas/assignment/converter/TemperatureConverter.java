package com.tnas.assignment.converter;

public class TemperatureConverter extends Converter {

	public TemperatureConverter() {
		super();
	}

	public TemperatureConverter(double value) {
		super(value);
	}

	@Override
	public double convert() {
		return this.getValue() == Double.NaN ? Double.NaN :
			((this.getValue() - 32) * 5)/9 ;
	}

}
