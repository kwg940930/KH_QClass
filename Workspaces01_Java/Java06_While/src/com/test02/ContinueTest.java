package com.test02;

public class ContinueTest {
	
	public static void main(String[] args) {
		prn();
	}
	
	public static void prn() {
		int i = 0;
		
		while(i < 10) {
			i++;
			if(i % 2 == 0) {
				continue; // 얘를 만나면 밑에 내용을 뛰어넘고 다음 반복으로...
			}
			
			System.out.println(i);
		}
	}

}
