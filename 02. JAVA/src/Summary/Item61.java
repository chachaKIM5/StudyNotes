package com.test.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Item61 {

	public static void main(String[] args) {
		
		//[SUMMARY] Map 탐색하기(loop), iterator (2022. 4. 4. 오후 11:49:54)
		
		
		//Map -> 순서 없음 -> 루프 사용 어려움
		//Map 루프 돌리는 방법? keySet을 iterator로 돌린다
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");	
		map.put("five", "다섯");
		
		Set<String> set = map.keySet(); //HashMap의 key들로만 구성된 Set
		Collection<String> values = map.values(); //value들로만 구성된 Collection
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			
			String key = iter.next();
			System.out.println(key + ": " + map.get(key));
		}
		
	}
}
