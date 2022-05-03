package com.tnas.assignment.exceptionalpress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

	private static final List<Double> acceptedCoins = Arrays.asList(0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0); 
	
	private List<Book> shelf;
	
	private double locationFactor;
	
	private double cassette;
	
	private double safe;
	
	private String password;

	public VendingMachine(double locationFactor, String password) {
		this.locationFactor = locationFactor;
		this.password = password;
		this.cassette = 0;
		this.safe = 0;
		this.shelf = new ArrayList<Book>();
	}

	public double getCassette() {
		return cassette;
	}

	public void insertCoin(double coin) throws IllegalAccessException {
		
		if (!acceptedCoins.contains(coin)) {
			throw new IllegalAccessException("The given coin is not of the right denomination");
		}
		
		this.cassette += coin;
	}
	
	public double returnCoins() {
		double returnedValue = this.cassette;
		this.cassette = 0;
		return returnedValue;
	}
	
	public void restock(List<Book> books, String password) {
		
		if (this.password.equals(password)) {
			this.shelf = books;
		}
		else {
			throw new InvalidPasswordException("Invalid password for restock");
		}
	}
	
	public double emptySafe(String password) {
		
		if (this.password.equals(password)) {
			double currentValue = this.safe;
			this.safe = 0;
			return currentValue;
		}
		else {
			throw new InvalidPasswordException("Invalid password for emptySafe");
		}
	}
	
	public List<String> getCatalogue() {
		return this.shelf.stream().map(Book::toString).collect(Collectors.toList());
	}
	
	public double getPrice(int index) {
		this.checkIndexBookOnShelf(index);
		return this.calculeBookPrice(index);
	}
	
	public Book buyBook(int index) {
		
		this.checkIndexBookOnShelf(index);
		double price = this.calculeBookPrice(index);
		
		if (price > this.cassette) {
			throw new CassetteException("Not enough money to buy the book");
		}
		
		return this.shelf.get(index);
	}
	
	private void checkIndexBookOnShelf(int index) {
		
		int lastIndex = this.shelf.size() - 1;
		
		if (index < this.shelf.size() || index > lastIndex) {
			throw new IndexOutOfBoundsException(
					"Invalid book index. It must be between [0, " + lastIndex + "]");
		}
	}
	
	private double calculeBookPrice(int index) {
		return this.shelf.get(index).getPages() * index;
	}
}
