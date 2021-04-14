package com.test03;

import java.util.HashSet;
import java.util.Set;

public class MTest01 {
	
	// Set : 순서X, 중복X
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("1");
		set.add("3");
		set.add("5");
		set.add("2");
		set.add("4");
		set.add("6");
		set.add("7");
		//set.add(null);
		set.add("3"); // 중복이 없기때문에 3이 하나만 나옴

		
		
		for ( String s : set) {
			System.out.print(s + " ");		// 출력된게 정렬된것처럼 보이지만 정렬된게 아니라 set이 자기 편한대로 가지고 나온값임 null값도 들어가짐
		}
		System.out.println();
		
		findElement(set, "3");
		deleteElement(set, "3");
		
	}
	
	
	
	public static void findElement(Set<String> set, String find) {
		/*
		for(int i = 0; i < set.size(); i++) {
			set.get(i);
		}
		set은 순서가 없어서 가지고 올수가 없다.
		*/
		for(String s : set) {
			if(s.equals(find)) {
				System.out.println(find + " 찾았다!!");
			}
		}// null값이 들어가 있으면 NPE 오류 -> 아무것도 없는데(null 인데) 어떻게 비교를 하냐 멍청아 하고 오류내는것임 / 즉, null값을 저장은 가능하지만 사용하려고 하면 NullPointerException
	}
	
	
	
	public static void deleteElement(Set<String>set, String delete) {
		for(String s : set) {
			if(s.equals(delete)) {
				if(set.remove(s)) {
					System.out.println(delete + " 지웠다!");
					break;		//브레이크가 없으면 3은 중간에 지웠는데 지운 값을 출력시키려니까 에러(예외)가 발생함 이런 예외가 발생하기전에 브레이크를 사용하여 나오면 에러 안남 / Exception in thread "main" java.util.ConcurrentModificationException에러
				}
			}
		}
	}
	
}
