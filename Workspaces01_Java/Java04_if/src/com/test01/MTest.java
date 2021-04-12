package com.test01;

public class MTest {

	public static void main(String[] args) {
		prn01();
		prn02(false, false);
	}
	
	public static void prn02(boolean ring, boolean married) {
		if(ring) {
			if(married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("연인이 있으시군요!");
			}
		}else {
			if(married) {
				System.out.println("결혼하셨군요!");
			}else {
				System.out.println("솔로이시군요!");
			}
		}
		
		if(ring && married) {
			System.out.println("결혼하셨군요!");
		}else if(ring || married) {
			System.out.println("연인이 있으시군요!");
		}else {
			System.out.println("솔로이시군요!");
		}
		
		
		
		
		
	}
	
	public static void prn01() {
		int i = 10;
		int j = 20;
		
		if(i < j) { // 만약 조건이 참이라면
			System.out.println();
			System.out.println("i가 j보다 작습니다");
		}else {  // 막약 위의 조건이 참이 아니라면
		System.out.println("i가 j보다 작지 않습니다");
		}
		
		if( i ==2 ) {
			System.out.println("i는 2입니다.");
		}else if ( i == 3 ) {
			System.out.println("i는 3입니다.");
		}else if ( i == 4 ) {
			System.out.println("i는 4입니다");
		}else if ( i == 5 ) {
			System.out.println("i는 5입니다");
		}else {
			System.out.println("i는 2, 3, 4, 5 모두 아닙니다");
		}
	}
	
}
