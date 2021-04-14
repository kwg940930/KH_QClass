package com.j04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MTest {

	public static void main(String[] args) {
		
		// Person 타입의 값 5개를 받을 수 있는 배열을 만들고,
		// 좋아하는 연예인(캐릭터 ..) 5명을 널자.
		
		Person[] people = new Person[5];
		
		people[0] = new Person("강호동", 50, 'M');
		people[1] = new Person("배수지", 28, 'F');
		people[2] = new Person("아이린", 26, 'F');
		people[3] = new Person("아이유", 28, 'F');
		people[4] = new Person("타블로", 35, 'M');
		
		
		// 반복문을 사용하여 전체 출력 하는데, 나이가 35인 사람은 이름만 출력하자
		/*
		for(int i = 0; i < people.length; i++) {
			if(people[i].getAge() == 28) {
				System.out.println(people[i].getName());
			}else {
				System.out.println(people[i]);
			}
		}
		*/
		
		for(Person p : people) {
			if(p.getAge() == 28) {
				System.out.println(p.getName());
			} else {
				System.out.println(p);
			}
		}
		
		// array : 같은 타입의 여러개의 값을 효과적으로 관리하기 위한 객체	/ 타입 고정				/ 크기 고정
		// collection : 여러개의 값을 효과적으로 관리하기 위한 객체 		/ 타입 가변 (generic<>)	/ 크기 가변
		
		// List<Person> list = Array.asList(people);
		List<Person> list = new ArrayList<Person>();
		list.addAll(Arrays.asList(people));
		//System.out.println(list);
		
		
		Set<Person> set = new HashSet<Person>();
		set.addAll(list);	
		//System.out.println(set);
		
		
		Map<String, Person> map = new HashMap<String, Person>();
		for(int i = 0; i < people.length; i++) {
			map.put(people[i].getName(), people[i]);	
		}
		System.out.println(map);
		
		/*
		 * 				Collection
		 * List			Set			Map
		 * O			X			X			순서
		 * O			X			k:X v:O		중복
		 */
		
		// map을 반복해서 가지고 와서,
		// age가 28인 사람의 key와 value를 각각 출력하는데, 
		// key를 출력하고 value가 가지고 있는 age만 출력하자.
		// 단, iterator와 entry를 사용하자!
		Set<Entry<String, Person>> entrySet = map.entrySet();
		
		// Iterator : collection 내부의 값을 읽어드리는 표준화된 방법
		Iterator<Entry<String, Person>> entryIr = entrySet.iterator();
		while(entryIr.hasNext()) {
			Entry<String, Person> entry = entryIr.next();
			
			if(entry.getValue().getAge() == 28) {
				System.out.println(entry.getKey() + " : " + entry.getValue().getAge());
			}
		}
	}
}
