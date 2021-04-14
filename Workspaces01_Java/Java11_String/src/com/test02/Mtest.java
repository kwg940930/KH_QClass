package com.test02;

public class Mtest {

	public static void main(String[] args) {
		sTest();
		sBufferTest();
	}
	
	
	//String을 +연산으로 연결할 때, 내부적으로 StringBuilder로 더해준다. (jdk 1.5)
	public static void sTest() {
		// immutable
		String s = "안녕하세요.";
		System.out.println(s.hashCode());
		s += " 저는 ";
		System.out.println(s.hashCode());
		s += "강원기 입니다.";
		System.out.println(s.hashCode());
		
		System.out.println(s);
		
		// 안녕하세요 -> 하이
		System.out.println(s.replace("안녕하세요", "하위"));
		System.out.println(s);
		
		s = s.replace("안녕하세요","하이");
		System.out.println(s);
		
		System.out.println("----------------");
	}
	
	public static void sBufferTest() {
		// mutable
		
		StringBuffer sb = new StringBuffer();
		// method chaining
		System.out.println(sb.hashCode());
		sb.append("안녕하세요").append(" 저는 ").append("강원기입니다");
		
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		sb.replace(0, 5, "하이!");
		System.out.println(sb);
		
		//거꾸로 출력
		sb.reverse();
		System.out.println(sb);
		
	}
	
}
