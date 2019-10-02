package com.tnas.assignment.collegeadmin;

public class StudentCollection {

	private Student[] students = new Student[1000];
	private int manyItems = 0; 
		
	public void add(Student student) {
		for (int i = 0; i < this.manyItems; ++i) {
			if (students[i] == null) {
				this.students[i] = student;
				return;
			}
		}
		this.students[this.manyItems++] = student; 
	}
	
	public void showAll() {
		int nullCounter = 0;
		for (int i = 0; i < this.manyItems; ++i) {
			if (students[i] == null) {
				++nullCounter;
			}
			else {
				System.out.println(this.students[i].toString());
				this.students[i].printCourses();
			}
		}
		if (nullCounter == this.manyItems)
			System.out.println("There is no any enrolled student.");
	}
	
	public Student searchById(String id) {
		for (int i = 0; i < this.manyItems; ++i) {
			if (students[i] != null && students[i].getStudentId().equals(id))
				return students[i];
		}
		return null;
	}
	
	public Student searchByLastName(String lastname) {
		for (int i = 0; i < this.manyItems; ++i) {
			if (students[i] != null && students[i].getLastName().equals(lastname))
				return students[i];
		}
		return null;
	}
	
	public boolean removeById(String id) {
		for (int i = 0; i < this.manyItems; ++i) {
			if (students[i] != null && students[i].getStudentId().equals(id)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
}
