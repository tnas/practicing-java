package com.tnas.assignment.gpacalculator;

/**
 * Class that represents a UNGStudent
 * @since October 14, 2019
 */
public class UNGStudent {

	private String firstName;
	private String lastName;
	private float homework1;
	private float homework2;
	private float quizz1;
	private float quizz2;
	private float quizz3;
	private float exam1;
	private float exam2;
	
	public UNGStudent(String firstName, String lastName, float homework1, float homework2, 
			float quizz1, float quizz2,	float quizz3, float exam1, float exam2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setGrades(homework1, homework2, quizz1, quizz2, quizz3, exam1, exam2);
	}
	
	/**
	 * Method that returns the full name of the student.
	 */
	public String getFullName() {
		return this.firstName.concat(" ").concat(this.lastName);
	}
	
	/**
	 * Method responsible for reseting the grades of the student
	 * @param homework1
	 * @param homework2
	 * @param quizz1
	 * @param quizz2
	 * @param quizz3
	 * @param exam1
	 * @param exam2
	 */
	public void setGrades(float homework1, float homework2, float quizz1, float quizz2,	
			float quizz3, float exam1, float exam2) {
		this.homework1 = homework1;
		this.homework2 = homework2;
		this.quizz1 = quizz1;
		this.quizz2 = quizz2;
		this.quizz3 = quizz3;
		this.exam1 = exam1;
		this.exam2 = exam2;
	}
	
	/**
	 * Method that take the existing homework grades from the object and 
	 * return the weighted average. The weight for the homework average is 25%.
	 * 
	 */
	public float calcHW() {
		return ((this.homework1 + this.homework2)/2)*0.25f;
	}

	/**
	 * Method that take the existing quiz grades from the object and return the weighted average. 
	 * The weight for the quiz average is 32%.   
	 */
	public float calcQuiz() {
		return ((this.quizz1 + this.quizz2 + this.quizz3)/3)*0.32f;
	}
	
	/**
	 * Method that take the existing exam grades from the object and return the weighted average.  
	 * The weight for the exam average is 43%. 
	 */
	public float calcExam() {
		return ((this.exam1 + this.exam2)/2)*0.43f;
	}

	@Override
	public String toString() {
		return "UNGStudent [homework1=" + homework1 + ", homework2=" + homework2 + ", quizz1=" + quizz1 + ", quizz2="
				+ quizz2 + ", quizz3=" + quizz3 + ", exam1=" + exam1 + ", exam2=" + exam2 + "]";
	}
	
}
