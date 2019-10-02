package com.tnas.assignment.collegeadmin;

import java.util.LinkedList;

public class CourseCollection {

	private LinkedList<Course> coursesList;
	
	public CourseCollection() {
		this.coursesList = new LinkedList<>();
	}
	
	public void add(Course course) {
		this.coursesList.add(course);
	}
	
	public boolean remove(int id) {
		return this.coursesList.removeIf(c -> c.getId() == id);
	}
	
	public Course searchById(int id) {
		return this.coursesList.stream().filter(c -> c.getId() == id)
				.findAny().orElse(null);
	}
	
	public Course searchBySubject(String subject) {
		return this.coursesList.stream().filter(c -> c.getSubject().equals(subject))
				.findAny().orElse(null);
	}
	
	public void showAll() {
		this.coursesList.forEach(System.out::println);
	}
	
}
