package com.tnas.assignment.converter;

public class DistanceConverter extends Converter {

	private static final double KM_PER_MILE = 1.609;
	
	public DistanceConverter() {
		super();
	}

	public DistanceConverter(double value) {
		super(value);
	}

	@Override
	public double convert() {
		return this.getValue() == Double.NaN ? Double.NaN :
			this.getValue() * KM_PER_MILE;
	}

}
