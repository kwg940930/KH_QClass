package com.test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.score.Score;

public class MTest02 {

	public static void main(String[] args) {
		Score sc01 = new Score("강씨네", 100, 89, 57);
		Score sc02 = new Score("배수지", 89, 100, 65);
		Score sc03 = new Score("아이유", 66, 49, 100);
		
		Map<Integer, Score> map = new HashMap<Integer, Score>();
		map.put(1,  sc01);
		map.put(3,  sc03);
		map.put(2,  sc02);
		
		//System.out.println(map);
		
		prn(map);
	}
	
	public static void prn(Map<Integer, Score> map) {
		//이름이 "김선호" 인 value를 찾아, 다음과 같이 출력하자.
		//출력결과) 1: 강씨네(82)
		Set<Entry<Integer, Score>> entrySet = map.entrySet();
		
		/*
		 for (Entry<Integer, Score> entry : entrySet) {
		
			if(entry.getValue().getName().equals("강씨네")) {
				System.out.println(entry.getKey() + " : " + entry.getValue().getName() + " (" + entry.getValue().getAvg() + ") ");
			}
		}
		*/
		Iterator<Entry<Integer, Score>> iterator = entrySet.iterator();
		
		while (iterator.hasNext()) {
			Entry<Integer, Score> tmep = iterator.next();
			
			if(tmep.getValue().getName().equals("강씨네")) {
				System.out.println(tmep.getKey() + " : " + tmep.getValue().getName() + " (" + tmep.getValue().getAvg() + ") ");
			}
		}

	}
}
