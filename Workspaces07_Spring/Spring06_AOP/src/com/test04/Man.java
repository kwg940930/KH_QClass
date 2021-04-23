package com.test04;

public class Man implements Student {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 뉴스본다.");
		// 실행 시키면 쉬는날이었다. 가 출력됨 (에러가 발생해서) 해당 코드는 String타입의 t는 null이라서 길이가 없어서 예외가 발생한다.
		//String t = null;
		//t.length();
		return "스프링 연습";
	}

}
