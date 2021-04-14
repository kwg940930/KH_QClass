package com.singleton;

public class MTest {

	public static void main(String[] args) {
		//Singleton singleton = new Singleton(); //생성자가 private로 선언되어있어서 에러가뜸
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1);
		System.out.println(s1.hashCode());
		
		System.out.println("------");
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		System.out.println(s2.hashCode());
	}
}
