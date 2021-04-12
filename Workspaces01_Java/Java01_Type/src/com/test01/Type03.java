package com.test01;

public class Type03 {

	//실수형 : float, double
	public static void main(String[] args) {
		float f1 = 0.1f;
		float f2 = 9.9f;	//실수형의 기본타입은 double이다.
		System.out.println(f1);
		System.out.println(f2);
	
		float sumF = f1 + f2;
		System.out.println(sumF + " = " + f1 + " + " + f2);
		
		System.out.println("--------------------");
		
		double d1 = 100.04;
		double d2 = 9.06d;
		double sumD = d1 + d2;
		System.out.println(sumD);
	}
}
