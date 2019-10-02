package com.tnas.assignment.collegeadmin;

public class Course {

	private int id;
	private String subject;
	private int credits;
	private int courseNumber;
	private int courseSection;
	private String status;
	private String instructor;
	
	public Course() {
	}

	public Course(int id, String subject, int credits, int courseNumber, 
			int courseSection, String status, String instructor) {
		this();
		this.id = id;
		this.subject = subject;
		this.credits = credits;
		this.courseNumber = courseNumber;
		this.courseSection = courseSection;
		this.status = status;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseNumber;
		result = prime * result + courseSection;
		result = prime * result + credits;
		result = prime * result + id;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Course other = (Course) obj;
		if (courseNumber != other.courseNumber)
			return false;
		if (courseSection != other.courseSection)
			return false;
		if (credits != other.credits)
			return false;
		if (id != other.id)
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", subject=" + subject + ", credits=" + credits + ", courseNumber=" + courseNumber
				+ ", courseSection=" + courseSection + ", status=" + status + ", instructor=" + instructor + "]";
	}
	
}
