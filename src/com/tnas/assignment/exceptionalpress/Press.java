package com.tnas.assignment.exceptionalpress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Press {

	private static final Pattern titlePattern = Pattern.compile("^Title:\\s(.+)$");
	private static final Pattern authorPattern = Pattern.compile("^Author:\\s(.+)$");
	
	private Map<String, List<Book>> shelf;
	
	private int shelfSize;
	
	private Map<String, Integer> edition;
	
	private String pathToDir;
	
	public Press(String pathToBookDir, int shelfSize) {
		
		this.shelfSize = shelfSize;
		this.pathToDir = pathToBookDir;
		this.shelf = new HashMap<>();
		this.edition = new HashMap<>();
		
		Stream.of(new File(pathToBookDir).listFiles()).forEach(f -> {
			this.shelf.put(f.getName(), new ArrayList<>());
			this.edition.put(f.getName(), 0);
		});
	}
	
	public List<String> getCatalogue() {
		return this.shelf.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
	}
	
	public Book print(String bookID, int edition) throws IllegalAccessException, IOException {
		
		this.checkBookID(bookID);
		
		String content = "";
		String title = "";
		String author = "";
		Boolean startContent = Boolean.FALSE;
		
		try (Scanner scanner = new Scanner(new File(this.pathToDir.concat(bookID)), StandardCharsets.UTF_8)) {
			
			scanner.useDelimiter("\\n");
			
			while (scanner.hasNext()) {
				
				String line = scanner.next();
				
				if (line.startsWith("Title")) {
					
					Matcher matcher = titlePattern.matcher(line);
					
					if (matcher.find()) {
						title = matcher.group(1);
					}
					else {
						throw new IllegalArgumentException("Title out of the expected pattern");
					}
				}
				else if (line.startsWith("Author")) {
					
					Matcher matcher = authorPattern.matcher(line);
					
					if (matcher.find()) {
						author = matcher.group(1);
					}
					else {
						throw new IllegalArgumentException("Author out of the expected pattern");
					}
				}
				else {
					if (line.contains("START OF THE PROJECT GUTENBERG EBOOK")) {
						startContent = Boolean.TRUE;
						line = scanner.next();
					}
					
					if (startContent) {
						content = content.concat(line);
					}
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Book printedBook = new Book(title, author, content, edition);
		this.shelf.get(bookID).add(printedBook);
		this.edition.put(bookID, edition);
		
		return printedBook;
	}
	
	public List<Book> request(String bookID, int amount) throws IllegalAccessException, IOException {
		
		this.checkBookID(bookID);
		int numAvailableBooks = this.shelf.get(bookID).size();
		int nextEdition = this.edition.get(bookID) + 1;
		List<Book> requestedBooks = new ArrayList<>();
		
		if (amount < numAvailableBooks) {
			IntStream.range(0, amount).forEach(i -> requestedBooks.add(this.shelf.get(bookID).remove(0)));
		}
		else if (amount > numAvailableBooks) {
			
			requestedBooks.addAll(this.shelf.get(bookID));
			this.shelf.put(bookID, new ArrayList<>());
			int diffAmount = amount - numAvailableBooks;
			
			for (int i = 0; i < diffAmount; i++) {
				requestedBooks.add(this.print(bookID, nextEdition));	
			}
			
			while (this.shelf.get(bookID).size() < this.shelfSize) {
				this.print(bookID, nextEdition);	
			}
		}
		else {
			requestedBooks.addAll(this.shelf.get(bookID));
			this.shelf.put(bookID, new ArrayList<>());
			
			for (int i = 0; i < this.shelfSize; i++) {
				requestedBooks.add(this.print(bookID, nextEdition));	
			}
		}
		
		return requestedBooks;
	}
	
	private void checkBookID(String bookID) throws IllegalAccessException {
		
		if (!this.shelf.containsKey(bookID)) {
			throw new IllegalAccessException("Invalid bookID: " + bookID);
		}
	}
	
}


