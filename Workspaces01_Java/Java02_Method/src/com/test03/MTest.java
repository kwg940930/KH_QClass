package com.test03;

public class MTest {
	
	public static void main(String[] args) {
		int mySum = MyCalc.sum(10, 2);
		System.out.println(mySum);
		
		MyCalc.sub(10, 3);
		
		/*
		 * mul메소드 호출하는데
		 * 아규먼트는 10,3
		 * 호출해서 리턴된 결과 값을
		 * console에 출력하자.
		 */
		
		
		
		double myMul = MyCalc.mul(10, 3);
		System.out.println(myMul);
		System.out.println(MyCalc.mul(10, 3));
		
		
		
		
		MyCalc clac = new MyCalc();
		clac.div(10, 3);
	}
		

}
