package com.test06;

import java.util.Scanner;

public class Square extends AreaImpl {

	Scanner sc = new Scanner(System.in);
	
	@Override
	public void make() {
		System.out.print("밑변의 길이를 입력해 주세요 : ");
		int width = sc.nextInt();
		System.out.print("높이의 길이를 입력해 주세요 : ");
		int height = sc.nextInt();
		
		double res = (double)(width * height);
		//setResult(res + ""); //문자열로 인식
		//setResult(String.valueOf(res));
		//setResult(Double.toString(res));
		setResult(String.format("%.2f",  res));
	}

	public void print() {
		System.out.printf("사각형의 ");
		super.print();
	}
}
