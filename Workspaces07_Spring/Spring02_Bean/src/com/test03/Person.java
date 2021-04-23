package com.test03;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHello() {
		System.out.printf("내가 좋아하는 걸그룹 %s 은(는) 평균나이는 %d 살 입니다. \n", name, age);
	}

}
