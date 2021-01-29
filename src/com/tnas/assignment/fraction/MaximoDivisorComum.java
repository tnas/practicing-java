package com.tnas.assignment.fraction;

public class MaximoDivisorComum {

	private int num1;
	private int num2;
	
	public MaximoDivisorComum(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int obterPrimeiroNumero() {
		return this.num1;
	}
	
	public int obterSegundoNumero() {
		return this.num2;
	}
	
	public int calcular() {
		
		int a = Math.abs(this.num1);
		int b = Math.abs(this.num2);

		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		MaximoDivisorComum mdc;
		mdc = new MaximoDivisorComum(3, 6);
		System.out.println(String.format("O MDC entre %d e %d é %d", 
				mdc.obterPrimeiroNumero(), mdc.obterSegundoNumero(), mdc.calcular()));
		mdc = new MaximoDivisorComum(15, 25);
		System.out.println(String.format("O MDC entre %d e %d é %d", 
				mdc.obterPrimeiroNumero(), mdc.obterSegundoNumero(), mdc.calcular()));
		mdc = new MaximoDivisorComum(4, 9);
		System.out.println(String.format("O MDC entre %d e %d é %d", 
				mdc.obterPrimeiroNumero(), mdc.obterSegundoNumero(), mdc.calcular()));
	}
}
