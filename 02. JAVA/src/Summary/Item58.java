package com.test.java;

import java.util.HashSet;
import java.util.Iterator;

public class Item58 {

	public static void main(String[] args) {
		
		//[SUMMARY] HashSet (2022. 4. 1. 오후 11:37:31)
		
		/*
		 
		 HashSet
		 - 데이터 중복을 허락하지 않는 자료구조
		 - 순서가 없는 데이터의 집합
		 - 식별자가 없다 > 방과 방을 구분할 수 없다
		 
		 - 요소 일괄 접근 불가능 (루프 X)
		 		 
		 */
	
		
		HashSet<String> set = new HashSet<String>();
		
		
		//1. 요소 추가하기
		// - boolean add(V value)
		// - 겉모습이 같은 경우 > HashCode가 같으면 중복 불가능, HashCode가 다르면 중복 가능
		System.out.println(set.add("사과")); //true
		set.add("바나나");
		set.add("딸기");
		System.out.println(set.add("바나나")); //false = 중복 값 추가 불가능
		
		
		//2. 요소 개수 확인
		// - int size()
		System.out.println(set.size()); //3
		
		
		//3. 덤프(dump)
		System.out.println(set); //[사과, 바나나, 딸기]
		
		
		//4. 요소 삭제
		// - boolean remove(V value)
		System.out.println(set.remove("바나나")); //true
		System.out.println(set);
		
		//5. 요소 탐색
		// - 식별자 없기 때문에 Iterator(컬렉션 탐색 도구) 사용
		// - boolean iter.hasNext() 가져올 요소 남았는지/없는지?
		// - T iter.next() 다음 요소 확인
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next()); //사과\n딸기
		}
		System.out.println(set); //[사과, 딸기]
	}
}
