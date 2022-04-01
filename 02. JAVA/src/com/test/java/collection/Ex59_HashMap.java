package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex59_HashMap {

	public static void main(String[] args) {
		
		//Ex59_HaspMap.java
		
		/*
		 
		 ArrayList
		 - 요소 접근 > 첨자(index) 사용
		 - 순서가 있는 데이터 집합(방번호 == 요소의 순서)
		 - ex) 강의실 6개 > 1강의실, 2강의실, 3강의실, ...
		 - 스칼라 배열(Scalar Array)
		 - 요소 일괄 접근 > 루프(for)
		 - 요소끼리 구분이 불편함 > 식별자만 가지고 판단이 힘듦 > 식별자가 숫자기 때문에
		 - 키(key)는 유일하다, 중복될 수 없다 (**********) 방 번호는 유일, 값은 중복 가능
		 
		 HaspMap
		 - 요소 접근 > 키(Key) 사용
		 - 순서가 없는 데이터 집합 > 방번호 없음
		 - ex) 강의실 6개 > 햇님반, 달님반, 별님반, ...
		 - 요소 일괄 접근 불가능 > 루프 X
		 - 요소끼리 구분이 용이하다 > 의미 있는 단어로 식별자를 설정(국어, 영어, 수학..)
		 - 요소 > 키(key) + 값(value) > 키와 값을 한쌍으로 하는 데이터 구조
		 - 키(key)는 유일하다, 중복될 수 없다 (**********) 값은 중복 가능
		 - 키 값으로는 보편적으로 String을 많이 쓴다 > HashMap의 장점을 부각시키기 때문에
		  
		 */
		
		
		// - String: key의 자료형
		// - Integer: value의 자료형
		
		//방의 이름을 문자열로 적고, 방 안에는 숫자를 넣겠다는 뜻
		
		HashMap<String, Integer> map = new HashMap<String, Integer>(); //숫자 배열
		
		//점수 입력 (국어, 영어, 수학)
		
		//1. 요소 추가
		// - V put(K key, V value)
		map.put("국어", 100); //int 국어 = 100;
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
		
		
		//4. 일괄 탐색 > for > 불가능
		
		
		//5. 요소 수정 > 요소 추가와 같다
		// - V put(K key, V value)
		map.put("국어", 99);
		System.out.println(map.get("국어"));
		
		
		//6. 요소 검색
		// - boolean containsKey(K key)
		// - boolean containsValue(V value)
		System.out.println(map.containsKey("국어")); //배열 안에 국어 점수가 있는지?
		System.out.println(map.containsKey("사회"));
		System.out.println(map.containsValue(90)); //어떤 과목인지는 모르지만 90점이 있는지?
	
		
		//7. 요소 삭제
		// - V remove(K key)
		map.remove("국어");
		System.out.println(map.size());
		
		System.out.println(map.get("과학")); //error 없음, null 값 반환?!
	
		
		//8. 초기화, 빈 배열 확인
		map.clear();
		
		System.out.println(map.isEmpty());
	
	
		
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("빨강");
		a1.add("파랑");
		a1.add("노랑");
		
		System.out.println(a1.get(0)); //페이지 번호 -> 데이터 접근
		
		HashMap<String,String> a2 = new HashMap<String,String>();
		a2.put("red", "빨강");
		a2.put("blue", "파랑");
		a2.put("yellow", "노랑");
	
		//Map == 사전 구조 > Dictionary
		System.out.println(a2.get("red")); //단어 -> 데이터 접근
		
		
		//toString() 오버라이딩 > 덤프
		System.out.println(a1); //[빨강, 파랑, 노랑]
		System.out.println(a2); //[red=빨강, blue=파랑, yellow=노랑]
		
	}//main
}//Ex59
