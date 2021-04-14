package com.test01;

import java.util.Arrays;

public class Mtest02 {
	
	public static void main(String[] args) {
		
		//방법 1.
		int[][] a = new int[3][2];						//큰 주소3개 그 주소 안에 주소2개씩
		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = 3;
		a[1][1] = 4;
		a[2][0] = 5;
		a[2][1] = 6;
		
		System.out.println(Arrays.toString(a));			//배열 주소안의 내용 출력
		System.out.println(Arrays.deepToString(a));		//다중배열일떄 주소안의 내용충력
		
		//방법 2.
		int [][] b = new int[3][];						//큰 주소를 3개 만들어놨는데 그 안에주소는 몇개인지 모름
		b[0] = new int[3];								//1번 큰주소 안에 작은주소 3개
		b[1] = new int [5];								//2번 주소 안에 작은주소 5개
		b[2] = new int [1];								//3번 큰 주소 안에 1개
		
		//방법 3.
		int[][] c = new int[][] {
									{1, 2},
									{3, 4 ,5},
									{6, 7, 8, 9},
									{10}
								};
		
		//방법 4.
		int[][] d = {
				{1, 2, 3, 4},
				{5},
				{6, 7, 8},
				{9, 10}
				};
		
		//c가 가진 8 + d가 가진 9 출력
		
		System.out.println(c[2][2] + d[3][0]);
		
		//c의 length
		System.out.println(c.length);
		
		//c 내부 배열의 length
		System.out.println(c[0].length);
		System.out.println(c[1].length);
		System.out.println(c[2].length);
		System.out.println(c[3].length);
		
		System.out.println("-----------------------");
		
		prn(a);
		prn(b);
		prn(c);
		prn(d);
		
		
		String [][] s = {{"Have", "a", "nice", "Day"}, {"너무", "어려워"}, {"일차원", "배열", "이차원", "배열"}};
		
		modi(s);

	}


	public static void modi(String[][] arr) {
		//nice --> good
		//어려워 --> 쉬워
		
		//출력 예)
		//Have a good day
		//너무 쉬워
		//일차원 배열 이차원 배열
		
		

		for(int i = 0; i < arr.length; i++) {

			for(int j = 0; j < arr[i].length; j++) {
				
				if(arr[i][j] == "nice") {
					arr[i][j] = "good";
				}else if(arr[i][j] == "어려워") {
					arr[i][j] = "쉬워";
				}

				if(j == arr[i].length-1) {
					System.out.printf("%s \n", arr[i][j]);
				}else {
					System.out.printf("%s ",arr[i][j]);
				}

				
			}
			
			

		}


		
		
		
		
		
		
	}




	
	public static void prn(int[][] arr) {
		//[
		//	{1, 2, 3, 4},
		//	{5},
		//	{6, 7, 8},
		//	{9, 10}
		//]
		//hint! arr.length, arr[i].length
		System.out.println("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print("     {");	
			for(int j = 0; j < arr[i].length; j++) {
				if(j == arr[i].length-1) {
				System.out.printf("%s", arr[i][j]);
				}else {
					System.out.printf("%s, ",arr[i][j]);
				}
			}
			if(i == arr.length-1) {
			System.out.println("}");	
			}else {
				System.out.println("},");	
			}
		}

		System.out.println("]\n");	

		
		
		
		
	}
}
