package com.lotto;

import java.util.Random;

public class MyLotto {

	public static void main(String[] args) {
		int[] lot = new int[7];
		int a;
		Random num = new Random();
		
		// 랜덤 숫자 생성 및 중복 제거
		for (int i = 0; i < lot.length; i++) {
			lot[i] = num.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lot[i] == lot[j]) {
					i--;
				}
			}
		}
		// 정렬 (버블정렬)
		for (int i = 0; i < lot.length-1; i++) {
			for (int j = 0; j < i; j++) {
				if (lot[j] > lot[i]) {
					a = lot[i];
					lot[i] = lot[j];
					lot[j] = a;
				}
			}
		}
		// 출력
		for (int i = 0; i < lot.length-1; i++) {
			System.out.printf("%d ", lot[i]);
		}
		System.out.println("/ Bonus : " + lot[6]);
	}

}
