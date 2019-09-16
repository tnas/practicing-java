package com.tnas.samples.security;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


/**
 * 
 * Command line operations:
 * javac ./com/tnas/samples/security/FileHandle.java
 * java -cp . com.tnas.samples.security.FileHandle.java
 * 
 * @author nascimenthiago@gmail.com
 *
 */
public class FileHandler {

	public static void main(String[] args) throws IOException {		
		
		// Reading Files
		Scanner scan = new Scanner(new File("../wiki/files/100n50d.txt"));
		
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
		
		scan.close();
		
		// Writing sequential files
		Path file = Paths.get("my-txt-file.txt");
		Files.write(file, "Primeira linha".getBytes(), StandardOpenOption.WRITE);
		//Files.write(file, "Segunda linha".getBytes());
		
		PrintWriter writer = new PrintWriter(new File("my-txt-file.txt"));
		writer.println("Primeira linha");
		writer.println("Segunda linha");
		writer.close();
		
		// Appending text to file
		Files.write(file, "Terceira linha".getBytes(), StandardOpenOption.APPEND);
		
		// Deleting file
		Files.delete(file);
	}
}
