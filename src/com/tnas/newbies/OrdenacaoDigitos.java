package com.tnas.newbies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrdenacaoDigitos {

	public static void main(String[] args) {
		
		// Via CMD 
		// String fileName = "./../resources/files/100n50d.txt";
		
		// Via IDE
		String fileName = "resources/files/100n50d.txt";
		
		try {
			Scanner scan = new Scanner(new File(fileName));
			
			while (scan.hasNext()) {
				System.out.println(scan.next());
			}
			
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
