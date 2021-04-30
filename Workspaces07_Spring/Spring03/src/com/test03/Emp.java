package com.test03;

public class Emp {
	private String name;
	private int salary;
	
	
	public Emp(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public Emp() {
	}
	
	
	@Override
	public String toString() {
		return "이름 : " + name + " 월급 : " + salary;
	}

}
