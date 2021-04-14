package com.j05;

public class Beaver extends Animal {
	
	// 생성자를 명시하지 않으면, jvm이 기본생성자를 제공한다.
	// 기본생성자에, 부모 생성자를 호출하지 않으면, 자동으로 부모의 기본생성자를 호출하게 된다.
	// 그래서, animal의 기본생성자를 호출하게 되는데 -> 이 떄, 부모의 기본생성자가 없어서 에러 발생.
	
	public Beaver() {
		
	}
	
	
	public Beaver(String kind, int age) {
		super(kind, age);
	}
	
	public void bark(String bark) {
		super.bark(bark);
	}

}
