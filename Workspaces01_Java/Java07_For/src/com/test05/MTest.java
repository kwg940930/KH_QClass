package com.test05;

public class MTest {
	public static void main(String[] args) {
		/*
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
		
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
		*/
		for (int i = 0; i <= 5; i++) {
	         for (int j = 0; j <= i; j++) {
	            System.out.print(" ");
	         }
	         for(int k = 1; k <= 5-i; k++) {
	            System.out.print(k);
	         }
	         System.out.println();
	            
	      }
	}

}
