package com.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {
	
	Scanner sc = new Scanner(System.in);

	
	@Override
	public void make() {
		System.out.print("밑변의 길이를 입력해 주세요 : ");
		int width = sc.nextInt();
		System.out.print("높이의 길이를 입력해 주세요 : ");
		int height = sc.nextInt();
		
		double res = (double)(width * height) / 2;
		setResult(res + "");
	}

	public void print() {
		
		System.out.print("삼각형의 ");
		super.print();

	}
}
