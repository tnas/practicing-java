package com.tnas.digitalindia.txtformatter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtFormatter {

	private static final String configFilePath = "./resources/txt/";
	private static final String processedFilePath = "./resources/processed/";
	
	public static void main(String[] args) throws IOException {

		List<Path> files = 
		Files.walk(Paths.get(configFilePath)).filter(s -> s.toString().endsWith(".txt")).map(Path::getFileName).sorted()
				.collect(Collectors.toList());
		
		for (Path path : files) {
			
			String fileName = processedFilePath.concat(path.toString());
			Path pathFileName = Paths.get(fileName);
			System.out.println("Processing file " + path.toString());
			
			List<String> lines = new ArrayList<>();
			Stream<String> stream = Files.lines(Paths.get(configFilePath.concat(path.toString())));
			lines = stream.collect(Collectors.toList());
			stream.close();
			
			File file = new File(fileName);
			file.createNewFile();
			
			for (String line : lines) {
				
				String formattedLine = new String();
				String[] letters = line.split("");
				
				for (int pos = 0; pos < letters.length; ++pos) {
					if (pos % 2 == 0 || letters[pos].equals(" ")) 
						formattedLine = formattedLine.concat(letters[pos]);
				}
				
				Files.write(pathFileName, formattedLine.getBytes(), StandardOpenOption.APPEND);
			}
		}

	}

}
