package com.test01;

public class MTest03 {
	/*1번
	 * a b c d e f
	 * g h i j k l
	 * m n o p q r
	 * s t u v w x
	 * y z
	 * 출력!
	 * 단, 일차원 배열에, 반복문을 사용하여 알파벳을 저장한 후에 출력하자.
	 * char[] ar = {'a','b','c' ... 'z'}; 금지
	 */
	public static void main(String[] args) {
		char[] alp = new char [26];

		for(int i = 0; i < alp.length; i++) {
			alp[i] = (char)('a'+ i);
			System.out.printf("%s ",alp[i] ); //System.out.println(Array.toString(alp));
				if((i+1) % 6 == 0) {
					System.out.println();
				}
				
		}
		System.out.println("\n------------------");
		
		/*
		 * 		char[] alp = new char [26];

		for(int i = 0; i < alp.length; i++) {
			alp[i] = (char)('a'+ i);
			System.out.println(Array.toString(alp));
				
				for(int i = 1; i<=alp.length; i++){
				System.out.print(ch[i-1] + " ");
				if(i%6 == 0){
				System.out.println();
				}
		}
		 */
		
		
		
		
		
		
		
		
		
		//2번 -> 1번에서 만든 배열을 거꾸로 출력하자.

		



		int tmp = 1;
		 for(int i = alp.length; i > 0; i--){
		  		System.out.printf("%s ",alp[i-1]);
		  		if(tmp % 6 == 0){
		 			System.out.println();
		 		}
		 tmp ++;
		 }
		 
		
		
		
			System.out.println("\n------------------");
		
		
		
		
		
		
		
		
		//3번 -> 1번에서 만든 배열을 대문자로 바꾸어 출력.

		  int cnt = 1;
		  for(int i = 0; i < alp.length; i++){
		  		alp[i] = Character.toUpperCase(alp[i]);
		  		System.out.printf("%s ", alp[i]);
		  
		  		if(cnt % 6 == 0){
		  			System.out.println();
		 		}
		  		cnt++;
		  }


		
		
	}

}
