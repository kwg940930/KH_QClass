package com.score;

//자바의 모든 class는 object메소드를 상속받고있다.

public class MTest {
	
	public static void main(String[] args) {
		Score lee = new Score();
		lee.setName("이순신");
		lee.setKor(85);
		lee.setEng(44);
		lee.setMath(100);
		
		System.out.println(lee);
		
		Score hong = new Score("홍길동", 100, 87, 0);
		
		System.out.println(lee);
		System.out.println(hong);
	}

}
