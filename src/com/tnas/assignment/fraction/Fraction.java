package com.tnas.assignment.fraction;

import java.util.Scanner;

public class Fraction {

	private static final String E_DEN_ZERO = "Denominator cannot be zero.";
	private static final String E_DIV_ZERO = "Cannot divide by zero.";
	
	private int numerator;
	private int denominator;
	
	public Fraction() {
		this.numerator   = 0;
		this.denominator = 1;
	}
	
	public Fraction(int n, int d) {
		if (d == 0) 
			throw new RuntimeException(E_DEN_ZERO);
		this.numerator   = n;
		this.denominator = d;
	}
	
	public Fraction(Scanner scanner) {
		System.out.print("Enter numerator: ");
		this.numerator = scanner.nextInt();
		System.out.print("Enter denominator: ");
		this.denominator = scanner.nextInt();
		
		if (this.denominator == 0)
			throw new RuntimeException(E_DEN_ZERO);
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	Fraction plus(Fraction f) {
		int commonDenominator = this.denominator * f.getDenominator();
		int addNumerator = (commonDenominator/this.denominator*this.numerator) +
			(commonDenominator/f.getDenominator()*f.getNumerator());
		int[] frac = { addNumerator, commonDenominator };
		frac = simplifyFraction(frac);
		return new Fraction(frac[0], frac[1]);
	}
	
	Fraction minus(Fraction f) {
		int commonDenominator = this.denominator * f.getDenominator();
		int addNumerator = (commonDenominator/this.denominator*this.numerator) -
			(commonDenominator/f.getDenominator()*f.getNumerator());
		int[] frac = { addNumerator, commonDenominator };
		frac = simplifyFraction(frac);
		return new Fraction(frac[0], frac[1]);
	}
	
	Fraction times(Fraction f) {
		int num = this.numerator * f.getNumerator();
		int den = this.denominator * f.getDenominator();
		int[] frac = { num, den };
		frac = simplifyFraction(frac);
		return new Fraction(frac[0], frac[1]);
	}
	
	Fraction divides(Fraction f) {
		
		if (f.getNumerator() == 0)
			throw new RuntimeException(E_DIV_ZERO);
		
		Fraction frac = new Fraction(f.getDenominator(), f.getNumerator());
		return this.times(frac);
	}
	
	@Override
	public String toString() {
		if (this.denominator == 1) {
			return String.format("%d", this.numerator);
		}
		else {
			return String.format("%d/%d (%.3f)", this.numerator, this.denominator, 
					(double) this.numerator/this.denominator);
		}
	}
	
	private int[] simplifyFraction(int[] f) {
		
		long gcd = gcd(f[0], f[1]);
		f[0] /= gcd;
		f[1] /= gcd;
		
		return f;
	}
	
	private long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	@SuppressWarnings("unused")
	private long lmc(long a, long b) {
		return a * (b / gcd(a, b));
	}
		
}
