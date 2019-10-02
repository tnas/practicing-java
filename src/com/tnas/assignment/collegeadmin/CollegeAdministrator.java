package com.tnas.assignment.collegeadmin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CollegeAdministrator {

	private static void showMenu() {
		System.out.println("Enter one of the following options: ");
		System.out.println("1 - Add a new student");
		System.out.println("2 - Remove a student by id");
		System.out.println("3 - Search a student by id");
		System.out.println("4 - Search a student by the last name");
		System.out.println("5 - Search a course by id");
		System.out.println("6 - Search a course by name");
		System.out.println("7 - Show the information of all students");
		System.out.println("8 - Add course");
		System.out.println("9 - Remover course by Id");
		System.out.println("10 - Set course to Student");
		System.out.println("11 - Unset course from student");
		System.out.println("12 - Exit");
	}
	
	private static Student getStudent(Scanner scan) throws ParseException {
		System.out.println("Enter the Student's first name");
		String firstName = scan.next();
		System.out.println("Enter the Student's last name");
		String lastName = scan.next();
		System.out.println("Enter the Student's birth date (MM-dd-yyyy)");
		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime((new SimpleDateFormat("MM-dd-yyyy")).parse(scan.next()));
		return new Student(firstName, lastName, birthDate);
	}
	
	private static Course getCourse(Scanner scan) throws ParseException {
		System.out.println("Enter the ID's course (number)");
		int id = scan.nextInt();
		System.out.println("Enter the Subject's course");
		String subject = scan.next();
		System.out.println("Enter the number of credits (number)");
		int credit = scan.nextInt();
		System.out.println("Enter the course's number");
		int number = scan.nextInt();
		System.out.println("Enter the Section's course (number)");
		int section = scan.nextInt();
		System.out.println("Enter the Status's course");
		String status = scan.next();
		System.out.println("Enter the Instructor's course");
		String instructor = scan.next();
		return new Course(id, subject, credit, number, section, status, instructor);
	}
	
	public static void main(String[] args) throws ParseException {
		
		CourseCollection availableCourses = new CourseCollection();
		StudentCollection enrolledStudents = new StudentCollection();
		Student student;
		Course course;
		
		Scanner scan = new Scanner(System.in);
		Option opt = Option.INIT;
		
		System.out.println("Welcome to the College Administrator System!");
		
		while (opt != Option.EXIT) {
			
			showMenu();	
			opt = Option.getOptionById(scan.nextInt());
			
			switch (opt) {
			
			case ADD_STUDENT :
				enrolledStudents.add(getStudent(scan));
				System.out.println("New student added!");
				break;
			case REMOVE_STUDENT :
				System.out.println("Enter the Student's ID: ");
				if (enrolledStudents.removeById(scan.next())) System.out.println("Student removed with success!");
				else System.out.println("There is no student with such an ID.");
				break;
			case SEARCH_STUDENT_BY_ID :
				System.out.println("Enter the Student's ID: ");
				student = enrolledStudents.searchById(scan.next());
				if (student == null) {
					System.out.println("There is no student with such an ID.");
				}
				else {
					System.out.println(student.toString());
					student.printCourses();
				}
				break;
			case SEARCH_STUDENT_BY_LASTNAME :
				System.out.println("Enter the Student's last name: ");
				student = enrolledStudents.searchByLastName(scan.next());
				if (student == null) {
					System.out.println("There is no student with such a last name.");
				}
				else {
					System.out.println(student.toString());
					student.printCourses();
				}
				break;
			case SEARCH_COURSE_BY_ID :
				System.out.println("Enter the Course's ID: ");
				int idCourse = scan.nextInt();
				course = availableCourses.searchById(idCourse);
				if (course == null) System.out.println("There is no course with such an id.");
				else System.out.println(course.toString());
				break;
			case SEARCH_COURSE_BY_NAME :
				System.out.println("Enter the Course's name (subject): ");
				String subject = scan.next();
				course = availableCourses.searchBySubject(subject);
				if (course == null) System.out.println("There is no course with such a name.");
				else System.out.println(course.toString());
				break;
			case LIST_ALL_STUDENTS :
				enrolledStudents.showAll();
				break;
			case ADD_COURSE :
				availableCourses.add(getCourse(scan));
				System.out.println("New course added!");
				break;
			case REMOVER_COURSE_BY_ID :
				System.out.println("Enter the ID of the course to be removed: ");
				if (availableCourses.remove(scan.nextInt())) System.out.println("Course removed with success.");
				else System.out.println("There is no course with such an id.");
				break;
			case SET_COURSE_TO_STUDENT :
				System.out.println("Enter the Student's ID: ");
				String idStudent = scan.next();
				System.out.println("Enter the Course's ID: ");
				idCourse = scan.nextInt();
				student = enrolledStudents.searchById(idStudent); 
				if (student == null) {
					System.out.println("There is no student with such an ID.");
				}
				else {
					course = availableCourses.searchById(idCourse);
					if (course == null) {
						System.out.println("There is no course with such an ID.");
					}
					else {
						student.addCourseTo(course);
						System.out.println("Course added to student with sucess!");
					}
				}
				break;
			case UNSET_COURSE_FROM_STUDENT :
				System.out.println("Enter the Student's ID: ");
				idStudent = scan.next();
				System.out.println("Enter the Course's ID: ");
				idCourse = scan.nextInt();
				student = enrolledStudents.searchById(idStudent); 
				if (student == null) {
					System.out.println("There is no student with such an ID.");
				}
				else {
					if (student.removerCourseFrom(idCourse)) {
						System.out.println("Course removed from the student with sucess!");
					}
					else {
						System.out.println("There is no course with such an ID set to this student.");
					}
				}
				break;
			case EXIT :
				System.out.println("The system has been closed!");
				break;
			default :
				System.out.println("Invalid Option!");
				showMenu();
			}
		}
		
		scan.close();
	}
}
