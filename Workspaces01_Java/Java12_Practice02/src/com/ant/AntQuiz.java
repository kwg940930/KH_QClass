package com.ant;

import java.util.Scanner;

/*
 * 1
 * 11
 * 12
 * 1121
 * 122111
 * 112213
 * 12221131
 * 1123123111
 * 12213111213113
 */

public class AntQuiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("level :");
		int level = sc.nextInt();

		String s = new String();

		for (int i = 0; i < level; i++) {
			String[] ant = s.split("");
			String tmp = ant[0];

			int cnt = 0;
			s = new String();

			for (int j = 0; j < ant.length; j++) {
				if (tmp.equals(ant[j])) {
					cnt++;
				} else {
					s = s + tmp + cnt;
					tmp = ant[j];
					cnt = 1;
				}
			}
			if (cnt >= 1) {
				s = s + tmp + cnt;
				cnt = 0;
			}
			System.out.println(s);
		}
		sc.close();

	}
}
