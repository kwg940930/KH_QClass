package com.test02;

public class TypeToType02 {
	public static void main(String[] args) {
		//형변환
		//묵시적 형 변환 (upCasting : 작은 타입에서 큰 타입으로 형 변환 - promotion)
		byte b1 = (byte) 100;	//(byte)생략가능
		int i1 = b1;			//형변환
		System.out.println(i1);
		
		//명시적 형 변환 (downCasting : 큰 타입에서 작은타입으로 형 변환 - casting)
		int i2 = 100;
		byte b2 = (byte)i2;		//형변환
		System.out.println(b2);
		
		
	}

}
