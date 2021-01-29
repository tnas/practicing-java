package com.tnas.assignment.fraction;

public class Fracao {
	
	private int num;
	private int den;
	
	public Fracao(int n, int d) {
		this.num   = n;
		this.den = d;
	}
	
	public int obterNumerador() {
		return num;
	}

	public int obterDenominador() {
		return den;
	}
	
	Fracao somar(Fracao f) {
		int denComum = this.den * f.obterDenominador();
		int novoNum = (denComum/this.den*this.num) +
			(denComum/f.obterDenominador()*f.obterNumerador());
		return new Fracao(novoNum, denComum);
	}
	
	Fracao subtrair(Fracao f) {
		int denComum = this.den * f.obterDenominador();
		int novoNum = (denComum/this.den*this.num) -
			(denComum/f.obterDenominador()*f.obterNumerador());
		return new Fracao(novoNum, denComum);
	}
	
	Fracao multiplicar(Fracao f) {
		int num = this.num * f.obterNumerador();
		int den = this.den * f.obterDenominador();
		return new Fracao(num, den);
	}
	
	Fracao dividir(Fracao f) {
		Fracao frac = new Fracao(f.obterDenominador(), f.obterNumerador());
		return this.multiplicar(frac);
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d", this.num, this.den);
	}
	
	public static void main(String[] args) {
		
		Fracao f1 = new Fracao(1, 2);
		Fracao f2 = new Fracao(3, 4);
		
		System.out.println("F1: " + f1);
		System.out.println("F2: " + f2);
		
		System.out.println("F1+F2: " + f1.somar(f2));
		System.out.println("F1-F2: " + f1.subtrair(f2));
		System.out.println("F1*F2: " + f1.multiplicar(f2));
		System.out.println("F1/F2: " + f1.dividir(f2));
	}
}
