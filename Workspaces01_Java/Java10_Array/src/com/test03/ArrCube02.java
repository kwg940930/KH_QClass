package com.test03;

public class ArrCube02 {
	/*
	 *   1  2  3  4  5
	 *  10  9  8  7  6
	 *  11 12 13 14 15
	 *  20 19 18 17 16
	 *  21 22 23 24 25
	 *  
	 *  모양을 이차원 배열 사용하여 출력하자.
	 */
	
	public static void main(String[] args) {
		
		int[][] a = new int[5][5];
		/*
		int cnt = -5;
		for(int i = 0; i < 5; i++) {
			if(i%2==0) {
				cnt+=5;
				
				for(int j = 0; j < 5; j++) {
					cnt ++;
					a[i][j] = cnt;		
					System.out.printf("%d ", a[i][j]);	
				}
					
			}else if(i%2==1) {
				cnt+=5;
				
				for(int j = 4; j >= 0; j--) {
					a[i][j] = cnt;
					cnt--;
					System.out.printf("%d ", a[i][j]);	
				}
				
			}
			System.out.println();
		
		}
		*/
	
		
		int cnt = 1;
		for(int i = 0; i < a.length; i++) {
			if(i%2==0) {
				
				for(int j = 0; j < a[i].length; j++) {
					a[i][j] = cnt++;		
				}	
				
			}else if(i%2==1) {

				for(int j = a.length-1; j >= 0; j--) {
					a[i][j] = cnt++;
					}
			}
		}
		for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a[i].length; j++) {
						System.out.printf("%3d", a[i][j]);
			}
			System.out.println();
		}

		
		
		
		
		
	}
		
		
	
	
}
