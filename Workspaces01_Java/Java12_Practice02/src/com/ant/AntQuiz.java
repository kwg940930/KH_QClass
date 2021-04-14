package com.ant;

import java.util.Scanner;

/*
 * [00]1
 * [01]1 1
 * [02]1 2
 * [03]1 1 2 1
 * [04]1 2 2 1 1 1
 * [05]1 1 2 2 1 3
 * [06]1 2 2 2 1 1 3 1
 * [07]1 1 2 3 1 2 3 1 1 1
 * [08]1 2 2 1 3 1 1 1 2 1 3 1 1 3
 * [09]1 1 2 2 1 1 3 1 1 3 2 1 1 1 3 1 1 2 3 1
 * [10]1 2 2 2 1 2 3 1 1 2 3 1 2 1 1 3 3 1 1 2 2 1 3 1 1 1
 * ......
 * 
 */





public class AntQuiz {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("level : ");
		int n = sc.nextInt();
		
		int count;
		
		int[][] arr = new int[n][];
		
		arr[0] = new int[] {1};
		for(int i = 1; i < arr.length; i++) {
			count = 1;
			arr[i] = new int[i + 1];

			
			for(int j = 0; j < arr[i].length; j++) {
				if(j==0) {
					arr[i][j] = 1;
				}else if( j != 0) {
					for(int k = 1; k < arr[i].length; k++) {
				
						if(arr[i-1][k-1] == arr[i-1][k]) {
							count++;
						}
					}
				}
				arr[i][j] = count;
			}
			
			
			

		}
		prn(arr);
		
        sc.close();
        
	}
	
	private static void prn(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	
}
