package com.test02;

public class Gugudan {
	
	public static void main(String[] args) {
		//1. 2단 부터 9단까지 전체 출력
		//gugu01();
		//guguWhile01();
		//2. 아규먼트로 들어온 값의 단만 출력
		//gugu02(5);
		guguWhile02(5);
	}
		public static void gugu01() {
			for(int i = 2; i < 10; i++) {
				System.out.println(i + "단");
				for(int j = 1; j < 10; j++) {

					System.out.printf("%d * %d = %d\n",i ,j ,i*j);
				}
				System.out.println();
		}
	}
		
		public static void gugu02(int dan) {
			
			for(int i = dan; i < 10;) {
				System.out.println(i + "단");
				
				for(int j = 1; j < 10; j++) {

					System.out.printf("%d * %d = %d\n",dan ,j ,dan*j);
				}
				System.out.println();
				break;
		}
			
			/*
			 * System.out.println(i + "단");
			 * for(int j = 1; j < 10; j++){
			 * 		System.out.printf("%d * %d = %d\n",dan ,j ,dan*j);
			 * }
			 */
			
	}
		
		
		
		public static void guguWhile01() {
			int i = 2;
			while(i<10) {
				System.out.println(i + "단");
				int j = 1;
				while(j<10) {
				System.out.printf("%d * %d = %d\n",i ,j ,i*j);
				j++;
				}
				i++;
				System.out.println();
			}

		}
		
		
		public static void guguWhile02(int dan) {
			
			int i = dan;
			while(i < 10) {
				System.out.println(dan + "단");
				int j = 1;
				while(j<10) {
				System.out.printf("%d * %d = %d\n",dan ,j ,dan*j);
				j++;
				}
				
				
				System.out.println();
				break;
			}
		}
		
}
