package com.test04;

public class StarPrn {
	
	/*
	 * ＊
	 * ＊＊
	 * ＊＊＊
	 * ＊＊＊＊
	 * ＊＊＊＊＊
	 */
	public void prn01() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	/*
	 * ＊＊＊＊＊
	 * ＊＊＊＊
	 * ＊＊＊
	 * ＊＊
	 * ＊
	 */
	public void prn02() {
		for(int i = 1; i <= 5; i++) {
			
			for(int j = 5; j >= i; j--) {

				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	/*
	 *         ＊
	 *        ＊＊
	 *      ＊＊＊
	 *    ＊＊＊＊
	 *  ＊＊＊＊＊
	 */
	public void prn03() {
		for(int i = 5; i >= 0; i--) {
			for(int j = i-1; j >= 0; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 5-i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}
	
	
	
	
	
	
	
	/*
	 * ＊＊＊＊＊
	 *   ＊＊＊＊
	 *    ＊＊＊
	 *     ＊＊
	 *       ＊
	 */
	public void prn04() {
		for(int i = 1; i <= 5; i++) {
			for(int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for(int j = 5; j > i - 1; j--) {
				//j=1;j<6-i;j++
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	/*
	 * 		 ＊			4 / 1
	 *     ＊＊＊		3 / 3
	 *   ＊＊＊＊＊		2 / 5
	 *  ＊＊＊＊＊＊＊	1 / 7
	 * ＊＊＊＊＊＊＊＊＊ 0 / 9
	 */
	public void prn05() {
		for(int i = 1; i <= 5; i++) {
			
			for(int k = 1; k <= 5-i; k++) {
				//k=4-i;k>=0;j--
				System.out.print(" ");
			}
			
			
			for(int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
