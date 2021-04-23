package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	// byType으로 연결할거 있으면 연결하고 아니면 -> byName
	@Autowired
	@Qualifier("lee")
	private Student person;
	
	private int grade;
	
	public School() {
	}
	public School(Student person, int grade) {
		this.person = person;
		this.grade = grade;
	}
	
	public Student getPerson() {
		return person;
	}
	public void setPerson(Student person) {
		this.person = person;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
}
