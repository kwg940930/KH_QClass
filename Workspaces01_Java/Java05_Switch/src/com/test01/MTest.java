package com.test01;

public class MTest {

	public static void main(String[] args) {
		
		prn01();
		prn02();
		
	}

	
	//if는 가장 위의 조건부터 순차적으로 모든 코드를 읽지만
	//swich는 해당 식/값에 맞는 case로 jumping 한다. -> 컴파일러가 작업하기 수월하다.
	//fall through
	
	
	
	public static void prn01() {
		int i = 2;
		
		switch(i) {
		case 1:
			System.out.println("1 입니다.");
			break;
		case 2:
			System.out.println("2 입니다.");
			break;
		case 3:
			System.out.println("3 입니다.");
			break;
		default:
			System.out.println("1, 2, 3 모두 아닙니다.");	
		}
	}
	
	public static void prn02() {
		int i = 5;
		
		switch(i) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("홀수입니다.");
			break;
		case 2: case 4: case 6: case 8: case 10: //컨트롤 + 쉬프트 + f 누르면 아래로 일자로 정리됨
			System.out.println("짝수입니다.");
			break;
		}
	}	
}
