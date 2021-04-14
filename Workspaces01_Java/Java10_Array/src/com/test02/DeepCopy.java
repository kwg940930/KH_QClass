package com.test02;

import java.util.Arrays;

public class DeepCopy {
	//새로운 객체 생성해서, 값만 복사
	public static void main(String[] args) {
		int[] original = {10, 20, 30, 40, 50};
		
		//1. 배열 인덱스의 값을 가져와서 복사
		int[] copy01 = new int[original.length];
		for(int i = 0; i < original.length; i++) {
			copy01[i] = original[i];
		}
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy01));
		System.out.println(original);
		System.out.println(copy01);
		System.out.println(original == copy01);

		copy01[2] = 300;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy01));
		
		System.out.println("-------------------");
		//2. original에게 요청하여 복사
		int[] copy02 = original.clone();
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy02));
		
		
		copy02[2] = 3000;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy02));
		
		System.out.println(original);
		System.out.println(copy02);
		
		System.out.println("-------------------");
		//3. System.arrayCopy 사용
		int[] systemArr = new int[10];
		Arrays.fill(systemArr,  100);
		System.out.println(Arrays.toString(systemArr));
		
		//					원본,	   시작,  복사본,   시작, 갯수
		System.arraycopy(original,  0, systemArr,  1,  3);
		System.out.println(Arrays.toString(systemArr));
		
		
		
		
	}

}
