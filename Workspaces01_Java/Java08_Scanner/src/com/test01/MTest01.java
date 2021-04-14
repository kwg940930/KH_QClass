package com.test01;

import java.util.Scanner;

public class MTest01 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void test01() {
		//Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력해 주세요 : ");
		int a = sc.nextInt();
		System.out.println("입력받은 a의 값 : " + a);
		
		System.out.print("숫자를 한번 더 입력해 주세요 : ");
		int b = sc.nextInt();
		System.out.println("입력받은 b의 값 : " + b);
		
		int sum = a + b;
		System.out.println("두 숫자의 합은 " + sum + "입니다.");
		
		
	}
	
	
	
	public static void test02() {
		//Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력해 주세요. (공백 포함 가능)");
		String input = sc.nextLine();
		System.out.println("엽력하신 문자열 : " + input);
		
	}
	
	
	
	public static void test03() {
		//Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력해 주세요. (공백 포함 불가)");
		String input = sc.next();
		System.out.println("입력하신 문자열 : " + input);
		String input2 = sc.next();
		System.out.println("next test : " + input2);
		String input3 = sc.next();
		System.out.println("next test2 : " + input3);
		String inputLine = sc.nextLine();
		System.out.println("nextLine test : " + inputLine);
		
		
	}
	
	
	
	public static void test04() {
		//Scanner sc = new Scanner(System.in);
		System.out.println("이름 : ");
		String name = sc.next();
				sc.nextLine();
		System.out.println("별명 : ");
		String nicname = sc.nextLine();
		System.out.println("이름 : " + name + "\n별명 : " + nicname);
		
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		test01();
		//test02();
		//test03();
		test04();
		
		
		
		
		sc.close();
	}
	
}
