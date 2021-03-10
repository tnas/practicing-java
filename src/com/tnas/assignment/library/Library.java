package com.tnas.assignment.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private static int NUMBER_OF_ITEMS = 0;
	
	public static void main(String[] args) {
		
		List<LibraryItem> libraryItems = new ArrayList<>();
		
		Song chandelier = new Song();
		chandelier.setId(++NUMBER_OF_ITEMS);
		chandelier.setTitle("Chandelier");
		chandelier.setType("pop");
		chandelier.setArtist("Sia");
		libraryItems.add(chandelier);
		
		Song sweetHome = new Song();
		sweetHome.setId(++NUMBER_OF_ITEMS);
		sweetHome.setTitle("Sweet Home Chicago");
		sweetHome.setType("blues");
		sweetHome.setArtist("Robert Johnson");
		libraryItems.add(sweetHome);
		
		Song dynamite = new Song();
		dynamite.setId(++NUMBER_OF_ITEMS);
		dynamite.setTitle("Dynamite");
		dynamite.setType("pop");
		dynamite.setArtist("BTS");
		libraryItems.add(dynamite);
		
		Book walden = new Book();
		walden.setId(++NUMBER_OF_ITEMS);
		walden.setTitle("Walden");
		walden.setAuthor("Thoreau");
		walden.setFiction(false);
		walden.setNumberOfPages(450);
		libraryItems.add(walden);
		
		Book hamlet = new Book();
		hamlet.setId(++NUMBER_OF_ITEMS);
		hamlet.setTitle("Hamlet");
		hamlet.setAuthor("Shakespeare");
		hamlet.setFiction(true);
		hamlet.setNumberOfPages(320);
		libraryItems.add(hamlet);
		
		Book originSpecies = new Book();
		originSpecies.setId(++NUMBER_OF_ITEMS);
		originSpecies.setTitle("Origin of Species");
		originSpecies.setAuthor("Darwin");
		originSpecies.setFiction(false);
		originSpecies.setNumberOfPages(250);
		libraryItems.add(originSpecies);
		
		Video avengers = new Video();
		avengers.setId(++NUMBER_OF_ITEMS);
		avengers.setTitle("Avengers");
		avengers.setGenre("Action");
		avengers.setRate("PG13");
		avengers.setDuration(160);
		libraryItems.add(avengers);
		
		Video hiddenFigures = new Video();
		hiddenFigures.setId(++NUMBER_OF_ITEMS);
		hiddenFigures.setTitle("Hidden Figures");
		hiddenFigures.setGenre("Historical Drama");
		hiddenFigures.setRate("PG");
		hiddenFigures.setDuration(175);
		libraryItems.add(hiddenFigures);
		
		Video citzenKane = new Video();
		citzenKane.setId(++NUMBER_OF_ITEMS);
		citzenKane.setTitle("Citizen Kane");
		citzenKane.setGenre("drama");
		citzenKane.setRate("PG");
		citzenKane.setDuration(90);
		libraryItems.add(citzenKane);

		libraryItems.forEach(it -> {
			System.out.println("Library item number " + it.getId());
			it.print();
			System.out.println();
		});
		
		System.out.println("The total number of items in the library is " + NUMBER_OF_ITEMS);
	}

}
