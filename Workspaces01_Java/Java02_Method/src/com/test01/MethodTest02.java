package com.test01;

public class MethodTest02 {
	
	public static void main(String[] args) {
		//method 호출 방법
		//1. static method 
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		//MethodTest01.privateMethod();		-> private method는 해당 class 내에서만 사용가능 하기떄문에 (not visible)
		//MetiodTest01.abc();				-> abc는 만든적이 없다. (undefined)
		
		
		
		//2. non-static method
		//class(참조타입) 변수 = new class();
		//변수.method();
		MethodTest01 method01 = new MethodTest01();
		method01.nonStaticMethod();
		
		//objectaid
		//UML : Unified Modeling Languege
		
		
		
	}

}
