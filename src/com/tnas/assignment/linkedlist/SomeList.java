package com.tnas.assignment.linkedlist;

import java.util.NoSuchElementException;

public class SomeList<T extends LibraryItem> {

	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string used in printing

	// constructor creates empty List with "my list" as the name
	public SomeList() {
		this.name = "my list";
	}

	// constructor creates an empty List with a name
	public SomeList(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	// insert item in front
	public void insertAtFront(T insertItem) {
		if (isEmpty()) {
			firstNode = lastNode = new ListNode<T>(insertItem);
		} else {
			firstNode = new ListNode<T>(insertItem, firstNode);
		}
	}
	
	/**
	 * Insert item in end
	 */
	public void insertAtEnd(T insertItem) {
		if (isEmpty()) {
			firstNode = lastNode = new ListNode<T>(insertItem);
		} else {
			ListNode<T> newNode = new ListNode<T>(insertItem);
			this.lastNode.nextNode = newNode;
			this.lastNode = newNode;
		}
	}

	// remove first node from List
	public T removeFromFront() throws NoSuchElementException {
		if (isEmpty()) { // throw exception if List is empty
			throw new NoSuchElementException(name);
		}

		T removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {
			firstNode = firstNode.nextNode;
		}

		return removedItem; // return removed node data
	}
	
	/**
	 *  Remove last node from List
	 */
	public T removeFromEnd() throws NoSuchElementException {
		
		if (isEmpty()) { // throw exception if List is empty
			throw new NoSuchElementException(name);
		}

		T removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {
			ListNode<T> aux;
			for (aux = firstNode; aux.nextNode != lastNode; aux = aux.nextNode);
			aux.nextNode = null;
			lastNode = aux;
		}

		return removedItem; // return removed node data
	}
	
	public void searchByIndex(int index) {
		
		if (isEmpty()) { // throw exception if List is empty
			throw new NoSuchElementException("Index: " + index);
		}
		else if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		
		int count;
		ListNode<T> aux;
		for (aux = firstNode, count = 0; count != index; aux = aux.nextNode, ++count);
		System.out.println(aux.data);
	}

	// determine whether list is empty
	public boolean isEmpty() {
		return firstNode == null; // return true if list is empty
	}

	// output list contents
	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s\n ", name);
			return;
		}

		System.out.printf("%s of size %d is: ", name, size());
		ListNode<T> current = firstNode;
		System.out.println();

		// while not at end of list, output current node's data
		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
			System.out.println();
		}

		System.out.println();
	}

	// returns the number of items in the list
	public int size() {
		int count = 0;
		ListNode<T> current = firstNode;
		while (current != null) {
			count++;
			current = current.nextNode;
		}
		return count;
	}

}
