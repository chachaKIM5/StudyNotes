package com.test.java.collection;

import java.util.TreeMap;

public class Ex71_TreeMap {

	public static void main(String[] args) {
		
		//Ex71_TreeMap.java
		
		//Tree + Map
		// - 이진트리 구조의 Map
		// - 자동 정렬 + 범위 검색(추출) 용이
		
		TreeMap<String,String> map = new TreeMap<String,String>();
		
		map.put("white", "흰색");
		map.put("black", "검은색");
		map.put("yellow", "노란색");
		map.put("red", "빨간색");
		map.put("blue", "파란색");
	
		System.out.println(map.size());
		System.out.println(map);
	
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println(map.firstEntry()); //MyHashMap > Item, black=검은색 한 쌍 형태로 반환
		System.out.println(map.lastEntry());

		System.out.println(map.headMap("m"));
		System.out.println(map.tailMap("m"));
		System.out.println(map.subMap("r", "w"));
		
		
		//Collection 마무리 정리
		
		/*
		 
		 *** 길이 가변
		 
		 처음 선택(1, 5, 7) > 상황에 맞춰(2, 3, 4, 6, 8)
		 
		 List
		 1. ArrayList > 배열이 필요할 때, 삽입/삭제(X)
		 2. LinkedList > ArrayList 대체재 + 삽입/삭제(O)
		 3. Stack > 스택 구조
		 4. Queue > 큐 구조
		 
		 Set
		 5. HastSet > 중복값 배제 집합이 필요할 때
		 6. TreeSet > 중복값 배제 집합 + 정렬 필요할 때
		 
		 Map
		 7. HashMap > 키+값 형태의 배열이 필요할 때
		 8. TreeMap > 키+값 형태의 배열 + 정렬 필요할 때
		 
		  
		 */
	}
}
