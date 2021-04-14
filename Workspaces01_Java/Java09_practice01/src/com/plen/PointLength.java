package com.plen;

import java.util.Scanner;

public class PointLength {
	
	//hint : java.lang.Math
	
	public static void main(String[] args) {
		
		//원점부터 입력한 (x,y) 조표까지의 거리를 구하자
		Scanner sc = new Scanner(System.in);
		System.out.println("x좌표 : ");
		int x = sc.nextInt();
		System.out.println("y좌표 : ");
		int y = sc.nextInt();
		double res = pLength(x, y);
		res = Math.hypot(x,y);

		System.out.printf("(0,0) 부터 (%d, %d) 까지의 거리는 %.2f 입니다.",x,y,res);
		
		
		sc.close();
	}
	
	
	public static int pLength(int i, int j) {
		//Math.pow(a,b) : a^b
		//Math.sqrt(a) : root(a)
		//Math.hypot(a,b) : root(a^2 + b^2)
		Scanner a = new Scanner(System.in);
		
		return 0;
	}

}
