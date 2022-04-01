package com.test.java;

import java.util.HashMap;

public class Item57 {

	public static void main(String[] args) {
		
		//[SUMMARY] HashMap (2022. 4. 1. 오후 11:01:27)
		
		
		/*
		 
		 HashMap
		 - 키+값 한 쌍으로 데이터를 관리하는 자료구조
		 - 순서가 없는 데이터의 집합
		 - 데이터 중복을 허용한다
		 - 키는 중복될 수 없다
		 
		 - 요소 일괄 접근 불가능 (루프 X)
		 - 의미 있는 단어로 키(요소 접근 식별자)를 설정, 요소 간 구분이 용이하다
		 - 키 값으로는 보편적으로 String을 사용해 HaspMap의 장점을 살릴 수 있다
		 		 
		 */
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		//1. 요소 추가
		// - V put(K key, V value)
		
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		
		
		//2. 요소 개수
		// - int size()
		System.out.println(map.size()); //3
		
		
		//3. 요소 읽기(접근)
		// - V get(K key)
		System.out.println(map.get("국어")); //100
		System.out.println(map.get("영어")); //90
		System.out.println(map.get("수학")); //80

		
		//4. 일괄 탐색(루프) > 불가능!
		
		//5. 요소 수정 > 요소 추가와 같다
		// - V put(K key, V value)
		map.put("국어", 99);
		System.out.println(map.get("국어")); //99
		
		
		//6. 요소 검색
		// - boolean containsKey(K key)
		// - boolean containsValue(V value)
		System.out.println(map.containsKey("국어")); //true
		System.out.println(map.containsKey("사회")); //false
		System.out.println(map.containsValue(90));  //true
		
		
		//7. 요소 삭제
		// - V remove(K key)
		System.out.println(map.size()); //3
		map.remove("국어");
		System.out.println(map.size()); //2
		
		
		//8. 초기화, 빈 배열 확인
		// - void clear()
		// - boolean isEmpty()
		map.clear();
		System.out.println(map.isEmpty()); //true

	
	
	}
}
