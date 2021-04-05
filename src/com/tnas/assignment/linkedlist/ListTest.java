package com.tnas.assignment.linkedlist;

public class ListTest {

	private static int NUMBER_OF_ITEMS = 0;
	
	public static void main(String[] args) {
		
		SomeList<LibraryItem> libraryItems = new SomeList("My List");
		SomeList<LibraryItem> reversedLibraryItems = new SomeList("My Reversed List");
		
		Song chandelier = new Song();
		chandelier.setId(++NUMBER_OF_ITEMS);
		chandelier.setTitle("Chandelier");
		chandelier.setType("pop");
		chandelier.setArtist("Sia");
		libraryItems.insertAtFront(chandelier);
		reversedLibraryItems.insertAtEnd(chandelier);
		
		Song sweetHome = new Song();
		sweetHome.setId(++NUMBER_OF_ITEMS);
		sweetHome.setTitle("Sweet Home Chicago");
		sweetHome.setType("blues");
		sweetHome.setArtist("Robert Johnson");
		libraryItems.insertAtFront(sweetHome);
		reversedLibraryItems.insertAtEnd(sweetHome);
		
		Song dynamite = new Song();
		dynamite.setId(++NUMBER_OF_ITEMS);
		dynamite.setTitle("Dynamite");
		dynamite.setType("pop");
		dynamite.setArtist("BTS");
		libraryItems.insertAtFront(dynamite);
		reversedLibraryItems.insertAtEnd(dynamite);
		
		Book walden = new Book();
		walden.setId(++NUMBER_OF_ITEMS);
		walden.setTitle("Walden");
		walden.setAuthor("Thoreau");
		walden.setFiction(false);
		walden.setNumberOfPages(450);
		libraryItems.insertAtFront(walden);
		reversedLibraryItems.insertAtEnd(walden);
		
		Book hamlet = new Book();
		hamlet.setId(++NUMBER_OF_ITEMS);
		hamlet.setTitle("Hamlet");
		hamlet.setAuthor("Shakespeare");
		hamlet.setFiction(true);
		hamlet.setNumberOfPages(320);
		libraryItems.insertAtFront(hamlet);
		reversedLibraryItems.insertAtEnd(hamlet);
		
		Book originSpecies = new Book();
		originSpecies.setId(++NUMBER_OF_ITEMS);
		originSpecies.setTitle("Origin of Species");
		originSpecies.setAuthor("Darwin");
		originSpecies.setFiction(false);
		originSpecies.setNumberOfPages(250);
		libraryItems.insertAtFront(originSpecies);
		reversedLibraryItems.insertAtEnd(originSpecies);
		
		libraryItems.print();
		System.out.println("After removing two last elements ...");
		libraryItems.removeFromEnd();
		libraryItems.removeFromEnd();
		libraryItems.print();
		
		reversedLibraryItems.print();
		System.out.println("Item of index 3 in the reversed list:");
		reversedLibraryItems.searchByIndex(3);

	}

}
