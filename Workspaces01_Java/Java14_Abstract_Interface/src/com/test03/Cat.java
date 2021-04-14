package com.test03;

// extends : class가 class 상속
// implements : class가 interface 상속
public class Cat implements Animal {

	@Override
	public void bark() {
		System.out.println("야옹");

	}

	@Override
	public void eat(String feed) {
		System.out.println("고양이가 " + feed + "");

	}

}
