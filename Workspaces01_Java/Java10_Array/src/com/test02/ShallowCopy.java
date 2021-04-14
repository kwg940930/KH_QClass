package com.test02;

import java.util.Arrays;

public class ShallowCopy {
	
	//얕은 값 복사(주소값 복사)
	public static void main(String[] args) {
		
		int[] original = {10, 20, 30, 40, 50};
		int[] copy = original;
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		System.out.println(original);
		System.out.println(copy);
		
		copy[2] = 300;
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		
		
	}

}
