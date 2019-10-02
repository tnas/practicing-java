package com.tnas.assignment.collegeadmin;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {

	private String studentId;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthDate;
	private String email;
	private CourseCollection courses;
	
	public Student() {
		this.courses = new CourseCollection();
	}

	public Student(String firstName, String lastName, GregorianCalendar birthDate) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.setIdAndEmail();
	}

	public void addCourseTo(Course course) {
		this.courses.add(course);
	}
	
	public boolean removerCourseFrom(int idCourse) {
		return this.courses.remove(idCourse);
	}
	
	private void setIdAndEmail() {
		this.studentId = this.firstName.substring(0, 2)
				.concat(String.valueOf(this.birthDate.get(Calendar.YEAR)))
				.concat(this.lastName.substring(this.lastName.length() - 2));
		this.email = this.firstName.concat(".").concat(this.lastName)
				.concat("@pa2.com");
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CourseCollection getCourses() {
		return courses;
	}

	public void setCourses(CourseCollection courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + String.format("%d-%d-%d", birthDate.get(Calendar.DAY_OF_MONTH),
						birthDate.get(Calendar.MONTH), birthDate.get(Calendar.YEAR)) + 
				", email=" + email + "]";
	}
	
	public void printCourses() {
		if (this.courses != null) this.courses.showAll();
	}
	
	
}
