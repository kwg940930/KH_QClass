package com.lotto;

public class Lotto {

	// 로또 "배열"
	// 1 ~ 45 사이의 "중복 없는" 랜덤한 숫자 6개
	// 정렬
	
	
	// 배열
	private int[] make() {
		int[] arr = new int[6];
		
		int index = 0;
		while(index < 6) {
			int insert = (int)(Math.random()*45) + 1;
			
			if(!isSame(arr, insert)) {
				arr[index] = insert;
				index++;
			}
		}
		return arr;
	}
	
	
	// 중복 제거
	private boolean isSame(int[] arr, int insert) {
		boolean same = false;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == insert) {
				same = true;
				break;
			}
		}
		
		
		return same;
	}
	

	
	// 정렬
	private void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length; j++) {
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
				
			}
		}
	}
	
	
	
	
	
	
	public void prn() {
		int[] arr = make();
		//System.out.println(Arrays.toString(arr));
		sort(arr);
		
		System.out.print("{");
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%3d",arr[i]);
		}
		System.out.println("}");
		}
	
	

	 /*
	
	public void prn() {
		int[] lot = new int [6];
		int a;
		Random num = new Random();
			//중복제거
			for(int i = 0; i < lot.length; i++) {
				lot[i] = num.nextInt(45)+1;
				for(int j = 0; j < i; j++) {
					if(lot[i] == lot[j]) {
						i--;
					}
				}
			}
			//정렬
			for(int i = 0; i < lot.length; i++) {
				for(int j = 0; j < i;j++) {
					if(lot[j] > lot[i]) {
						a = lot[i];
						lot[i] = lot[j];
						lot[j] = a;
					}
				}	
			}
			//출력
			for(int i = 0; i < lot.length; i++) {
				System.out.printf("%d ", lot[i]);
			}
	}
	*/
}