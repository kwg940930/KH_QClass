package com.test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MTest01 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i = 111; i < 116; i++) {
			// map.put(k, v)
			map.put(i,  i+"abc");
		}
		System.out.println(map);
		System.out.println(map.get(111));
		map.put(111, "115abc");
		System.out.println(map);
		
		
		prn(map);
	}
	
	
	
	public static void prn(Map<Integer, String> map) {
		//value만 뺴오는방법
		Collection<String> values = map.values();
		System.out.println(values);
		
		//key만 뺴오는방법
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		
		//Entry : Key와 Value를 같이 관리
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		// Entry<K,V>라는 객체들을 Set으로 관리하겠다.
		// Map은 key를 통해 value를 가지고 올 수 있음. (map.get(key) -> value)
		// Entry는 key와 value를 각각 가지고 올 수 있음. *entry.getKey(), entry.getValue())
		
		for (Entry<Integer, String> entry : entrySet) {
			System.out.printf("%d : %s\n", entry.getKey(), entry.getValue());
		}
		
		
	}
	
	
	
}



