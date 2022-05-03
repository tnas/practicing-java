package com.tnas.assignment.exceptionalpress;

import java.io.IOException;

public class PressTest {

	public static void main(String[] args) throws IllegalAccessException, IOException {
		
		Press press = new Press("D:/MyProjects/practicing-java/resources/press-shelf/", 3);
		press.getCatalogue().stream().forEach(System.out::println);
		
		Book wounderland = press.print("11-0.txt", 5);
		System.out.println(wounderland.toString());
		Book pridePrejudice = press.print("1342-0.txt", 3);
		System.out.println(pridePrejudice.toString());
		Book frankenstein = press.print("84-0.txt", 2);
		System.out.println(frankenstein.toString());
		
		VendingMachine machine = new VendingMachine(2.0, "xulambs");
		machine.restock(press.request("11-0.txt", 10), "xulambs");

	}
}
