package com.tnas.assignment.collegeadmin;

public enum Option {

	INIT,
	ADD_STUDENT,
	REMOVE_STUDENT,
	SEARCH_STUDENT_BY_ID,
	SEARCH_STUDENT_BY_LASTNAME,
	SEARCH_COURSE_BY_ID,
	SEARCH_COURSE_BY_NAME,
	LIST_ALL_STUDENTS,
	ADD_COURSE,
	REMOVER_COURSE_BY_ID,
	SET_COURSE_TO_STUDENT,
	UNSET_COURSE_FROM_STUDENT,
	EXIT,
	INVALID;
	
	public static Option getOptionById(int opt) {
		switch(opt) {
		case 0 : return INIT;
		case 1 : return ADD_STUDENT;
		case 2 : return REMOVE_STUDENT;
		case 3 : return SEARCH_STUDENT_BY_ID;
		case 4 : return SEARCH_STUDENT_BY_LASTNAME;
		case 5 : return SEARCH_COURSE_BY_ID;
		case 6 : return SEARCH_COURSE_BY_NAME;
		case 7 : return LIST_ALL_STUDENTS;
		case 8 : return ADD_COURSE;
		case 9 : return REMOVER_COURSE_BY_ID;
		case 10 : return SET_COURSE_TO_STUDENT;
		case 11 : return UNSET_COURSE_FROM_STUDENT;
		case 12 : return EXIT;
		default : return INVALID;
		}
	}
}
