package com.test02;

import java.util.Random;

public class RandomCube {

	public static void main(String[] args) {
		/*
		 * 1 ~ 9 사이의 난수로 이루어진
		 * 5 * 5 형태의 숫자들을 출력하고,
		 * 전체 난수의 합,
		 * 전체 난수의 평균,
		 * X의 합
		 * 을 구하자.
		 */
		
	prnCube();
	
		
		
	}
	
	/*
	  public static void prnCube(){
	  
	  int ranSum = 0;
	  int ranCount = 0;
	  double ranAvg = 0;
	  int xSum = 0;
	  
	  for(int i = 0; i < 5; i++){
	  for(int j = 0; j < 5; j++){
	  ranCount++; //난수의 갯수 세기
	  
	  int random = (int)(Math.random()*(9)) + 1; // 1~9의 난수 발생
	  System.out.printf("%d",random);
	  
	  ranSum += random;
	  
	  if((i==j) || (i + j ==6)){
	  xSum += random;
	  
	  }
	  System.out.println();
	  }
	  
	  ranAvg = (double)ranSum / ranCount;
	  
	  System.out.println("전체 난수의 합 : " + ranSum);
	  System.out.println("전체 난수의 평균 : " + ranAvg);
	  System.out.println("X의 합 : " + xSum);
	  }
	 
	*/
	
	
	public static void prnCube() {
		Random ran = new Random();
		
		int sum = 0;
		int x = 0;
		int count = 0;
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				
				count++;
				
				int random = ran.nextInt(9) + 1;

				System.out.print(random + " ");
				sum += random;
				
				if(i + j == 6 || i == j) {
					x += random;
				}
			}
			System.out.println();
		}
		
		double avg = (double)sum / count;
		System.out.println("전체 난수의 합 = " + sum);
		System.out.printf("전체 난수의 평균 = %.2f\n", avg);
		
		System.out.println("X의 합 = " + x);
	}
}
