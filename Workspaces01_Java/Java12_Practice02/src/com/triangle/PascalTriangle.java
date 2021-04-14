package com.triangle;

import java.util.Scanner;

/*
 * 
 * 				1
 * 			1		1
 * 		1		2		1
 * 		1	3 		3		1
 * 		1	4	6	4	1
 * 		1	5	10	10	5	1
 * ....
 * 
 * 
 * 
 * 
 * 
 */

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("level : ");
		int n = sc.nextInt();
		
		int[][] arr = new int[n][];
		
		arr[0] = new int[] {1};
		for(int i = 1; i < arr.length; i++) {
			arr[i] = new int[i+1];
			
			for(int j = 0; j < arr[i].length; j++) {
				if(j==0 || j == arr[i].length-1) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					
				}
			}
		}
		prn(arr);
		
        sc.close();
        
	}
	
	private static void prn(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for(int j = arr.length; j > i; j--) {
				System.out.print("  ");
			}
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
