package com.test03;

public class SumX {
	
	/*
	 *  1  2  3  4  5
	 *  6  7  8  9 10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 이렇게 출력하고,
	 * X의 합을 출력하자(X = 1, 5, 7, 9, 13, 17, 19, 21, 25)
	 */
	
	public static void main(String[] args) {
		int num = 1;
		int xSum = 0;
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5 ;j++) {
				System.out.printf("%2d ", num);
				if(i + j == 6 || i == j) {
					xSum += num;
				}
				if(j % 5 == 0) {
				System.out.println();
				}
				num++;
			}
		}
		System.out.println("X의 합 = " + xSum);
	}
}
