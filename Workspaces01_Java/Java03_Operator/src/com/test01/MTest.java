package com.test01;

public class MTest {
	
	//public static int ten = 10;			//전역변수
	
	//상수 : 변수 앞에 final
	public static final int TEN = 10;		//상수는 대문자로 쓰는게 국룰 (myten이다 하면 MY_TEN)
	
	
	public static void main(String[] args) {
		
		// 전역변수 지역변수의 이름이 같으면 지역변수가 우선!
		int ten = 100;		//지역변수
		System.out.println(ten);
		System.out.println(op01(TEN,3));
		System.out.println(op02());
		
		op03(TEN, 3);
		op04();
		
		String five = (op05()) ? "재밌다." : "즐겁다.";
		System.out.println(five);
		op06();
		op07();
	}
	
	
	public static String op01(int a, int b) {
		//1.사칙연산
		System.out.printf("%d + %d = %d\n",a, b, a + b);
		
		System.out.printf("%d - %d = %d\n",a, b, a - b);
		
		System.out.printf("%d * %d = %d\n",a, b, a * b);
		
		System.out.printf("%d / %d = 의 %d...%d\n",a, b, a / b, a % b);
		
		return "사직연산 끝!\n";
				
	}
	
	
	
	
	public static String op02() {
		//2.대입연산 ( +=, -=, *=, /=)
		int res = 0;
		System.out.println("res : " + res);
		res = res + 10;
		System.out.println("res : " + res);
		res = res - 5;
		System.out.println("res : " + res);
		res += 5;
		System.out.println("res : " + res);
		res *= 2;
		System.out.println("res : " + res);
		
		
		return null;
	}
	
	
	
	
	
	public static void op03(int a, int b) {
		//3.증감연산 ( ++, --) 변수의 앞 뒤에 증가/증감 연산자를 붙이게 되면, 변수가 가진 값을 1씩 증가/증감 하게된다.
		//전위연산 : 연산자를 변수 앞에 붙여서 연산을 먼저 하게 되고, 값을 나중에 리턴한다.
		//후위연산 : 연산자를 변수 뒤에 붙여서 값을 먼저 리턴하고, 연산을 나중에 하게 된다.
		
		System.out.println(a);
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);
		// a = 12 b = 3
		int result = a++ + --b + b++ + ++a;
		//12(13) + 2 + 2(3) + 14 = 30
		// a = 14 b = 3
		System.out.println(result);
		System.out.println("a : " + a + ",b : " + b);
	}
	public static void op04() {
		//4.논리연산 : &(and), |(or)
		
		System.out.println(true & true);		// 참 그리고 참 : 참
		System.out.println(true & false);		// 참 그리고 거짓 : 거짓
		System.out.println(false & true);		// 거짓 그리고 참 : 거짓
		System.out.println(false & false);		// 거짓 그리고 거짓 : 거짓
		System.out.println("--------------------");
		System.out.println(true | true);		//참 또는 참 : 참
		System.out.println(true | false);		//참 또는 거짓 : 참
		System.out.println(false | true);		//거짓 또는 참 : 참
		System.out.println(false | false);		//거짓 또는 거짓 :거짓
		System.out.println("--------------------");
		System.out.println(true && true);		//참 그리고 참
		System.out.println(true && false);		//참 그리고 거짓
		System.out.println(false && true);		//거짓 그리고 참
		System.out.println(false && false);		//거짓 그리고 거짓
		System.out.println("--------------------");
		System.out.println(true || true);		//참 또는 참
		System.out.println(true || false);		//참 또는 거짓
		System.out.println(false || true);		//거짓 또는 참
		System.out.println(false || false);		//거짓 또는 거짓
		System.out.println("--------------------");
		int a = 2;
		int b = 3;
		System.out.println((a > b) && (b > a));
		System.out.println("--------------------");
	}
	
	
	public static boolean op05() {
		//5. 삼항연산
		//(조건)?참일때 리턴값 : 거짓일때 리턴값;
		int a = TEN;
		int b = 7;
		int result = (a > b) ? a - b : b - a;
		
		System.out.println(result);
		
		//삼항연산자는 중첩가능
		String res = (a > b) ? "a가 b보다 크다" : (a < b) ? "a가 b보다 작다" : "a와 b는 같다";
		System.out.println(res);
		return false;
	}
	
	public static void op06() {
		// 6. 비교연산 (>,<,>=,<=,==)
		System.out.println(true == false);
		System.out.println(TEN != 3);
	}
	
	
	public static void op07() {
		// 7. 비트연산 (&, |, ^, ~, <<, >>, ...) : 값을 0, 1 비트 상태에서 연산한 결과를 리턴
		
		int a = 10;
		// 0000 0000 0000 0000 0000 0000 0000 1010
		int b = 2;
		// 0000 0000 0000 0000 0000 0000 0000 0010
		
		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(~a);
		
		System.out.println("-------------------");
		
		int c = 10;
		// 0000 0000 0000 0000 0000 0000 0000 1010
		System.out.println(c >> 2);		// 오른쪽으로 2칸 가시오
		// 00 0000 0000 0000 0000 0000 0000 0000 10
		System.out.println(Integer.toBinaryString(c>>2));		// 오른쪽으로 2칸가고 2진수로 바꿔주세요.
		
		System.out.println(c << 4);		// 왼쪾으로 4칸 가시오
		System.out.println(Integer.toBinaryString(c<<4));
		
		
	}
	
	
	
	

}
