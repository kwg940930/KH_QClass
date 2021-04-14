package com.test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCal {
	
	public int calculation() {
		int res = 0;
		
		while(true) {
			try {
					res = inputNum() / inputNum();
					break;
					
			} catch(InputMismatchException e) {
				//e.printStackTrace(); //무슨 에러인지 보여줌
				System.out.println("잘못 입력하셨습니다. 숫자만 입력해주세요.");
			} catch(ArithmeticException e) {
				System.out.println("0으로는 나눌수 없습니다. 다시 입력해주세요.");
			} finally {
				System.out.println("계산 완료");
			}
		//System.out.println(res);
		}
		
		
		return res;
	}
	
	
	
	
	
	
	
	
	public int inputNum() {
		int n = 0;
		System.out.println("숫자만 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		return n;
	}

}
