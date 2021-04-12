package com.test04;

public class Student {
	
	public static void main(String[] args) {

		Student.getAvg(Student.getSum(100, 40, 77));
		
	}
		/*
		 * Student 클래스 안에서 만들어주세요.
		 * 1. 과목 파라미터 세개를 넣어주면 총점을 리턴하는 getSum 이라는 이름의 메소드를 만들자.
		 * 2. 총 합 파라미터 한개를 가진 getAvg라는 이름의 메소드를 만드는데, 리턴은 평균을 리턴한다.
		 * 3. main 메소드에서 위의 메소드들을 호출하여 각각 sum 변수와 avg 변수에 리턴되는 값을 담고,
		 * 	  해당 병소들을 출력하자. 
		 * 
		 * + 평균은 소수점 둘쨰자리까지만 출력하자.
		 */
		
		public static int getSum(int kor, int eng, int math) {
		
			int sum = kor + eng + math;
			
			System.out.printf("국어 = %d 영어 = %d 수학 = %d 총점 = %d\n", kor, eng, math, sum);
			
			return sum;
	}
		
		public static double getAvg(int sum) {
			double avg = (double)sum/3;
			System.out.printf("평균 = %2.2f", avg);
			
			return avg;
	}
		
}
