package com.test01;

public class MTest {
	
	private static String str = "The String class represents character strings.";
	
	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(s + 1 + 2);
		System.out.println(1 + 2 + s);
		System.out.println(s);
		
		//s = 1 + 2 + s;
		System.out.println(s);
		
		String h = "Hello";
		System.out.println(h);
		
		System.out.println(s == h);
		
		String newS = new String("Hello");
		System.out.println(newS);
		
		System.out.println(s == newS);
		
		System.out.println("---------------------------");
		
		//1. str의 길이
		test01();
		
		//2. str 전체 대문자
		test02();
		
		//3. str 전체 소문자
		test03();
		
		//4. str에서 첫번쨰로 나오는 c의 위치(인덱스)
		test04();
		
		//5. class 단어를 찾아서 java로 바꿔서
		test05();
		
		//6. character 단어를 찾아서 대문자로 변환 후, 전체 출력
		test06();
		
		//7. str을 char[]로 출력하되, 'c' 만 출력하자.
		//그리고, c의 갯수를 출력
		test07();
		
		//8. str을 char[]로 출력하되, 대문자만 출력하자.
		//그리고, 대문자의 갯수를 출력
		test08();
		
		//9. str 사이의 공백 제거 후 출력
		test09();
		
		//10. 전체를 역순으로 출력
		test10();
		
	}

	private static void test01() {
		//1. str의 길이
		System.out.println("1." + str.length());
	}

	
	private static void test02() {
		//2. str 전체 대문자
		System.out.println("2." + str.toUpperCase());
	}

	
	private static void test03() {
		//3. str 전체 소문자
		System.out.println("3." + str.toLowerCase());
	}

	
	private static void test04() {
		//4. str에서 첫번쨰로 나오는 c의 위치(인덱스)
		System.out.println("4." + str.indexOf("c"));
	}

	
	private static void test05() {
		//5. class 단어를 찾아서 java로 바꿔서
		System.out.println("5." + str.replaceAll("class","java"));
	}

	
	private static void test06() {
		//6. character 단어를 찾아서 대문자로 변환 후, 전체 출력
		String target = "character";
		int start = str.indexOf(target);
		int end = start + target.length();
		String upper = str.substring(start,end);
		upper = upper.toUpperCase();
		System.out.println("6." + str.replace(target,upper));
	}

	
	private static void test07() {
		//7. str을 char[]로 출력하되, 'c' 만 출력하자.
		//그리고, c의 갯수를 출력
		char[] ch = str.toCharArray();
		int count = 0;
		System.out.print("7.");
		for(int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
			}
		System.out.println();
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == 'c') {
				System.out.print(ch[i]);
				count++;
			}
		}
		System.out.println("\nc의 갯수 = " + count);
		
	}

	
	private static void test08() {
		//8. str을 char[]로 출력하되, 대문자만 출력하자.
		//그리고, 대문자의 갯수를 출력
		char[] ch = str.toCharArray();
		int count = 0;
		System.out.print("8.");
		for(int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
			}
		System.out.println();
		for(int i = 0; i < ch.length; i++) {
			//if(ch[i] >= 'A' && ch[i] <= 'Z') {
			if(Character.isUpperCase(ch[i])) {
				System.out.print(ch[i]);
				count++;
			}
		}
		System.out.println("\n대문자의 갯수 = " + count);
	}

	
	private static void test09() {
		//9. str 사이의 공백 제거 후 출력
		str.trim(); // 앞뒤 공백 제거
		System.out.println("9." + str.replace(" ", ""));
		
	}

	
	private static void test10() {
		//10. 전체를 역순으로 출력
		
		int arrIndex = 0;
		System.out.print("10.");
		char[] ch = new char[str.length()];
				
				for(int i = str.length()-1; i >= 0; i--) {
					ch[i] = str.charAt(arrIndex);
					arrIndex++;
				};
		System.out.print(ch);
		/*my code
		System.out.print("10.");
		char[] ch = str.toCharArray();
		char[] backcopy = new char[ch.length];
		for(int i = 0; i < ch.length; i++) {
			backcopy[i] = ch[i];
			}
			for(int j = ch.length-1; j >= 0; j--) {
				System.out.print(backcopy[j]);
			
		}
		*/
	}

}
