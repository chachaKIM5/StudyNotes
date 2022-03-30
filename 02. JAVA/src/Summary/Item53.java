package com.test.java;

import java.util.ArrayList;

public class Item53 {

	public static void main(String[] args) {
		
		//[SUMMARY] 컬렉션, ArrayList (2022. 3. 30. 오후 10:04:54)
		
		/*
		 
 		 컬렉션 종류
		 *legacy > 너무 오래돼서 잘 안 쓰는 종류

			 1. List 계열
			 	- ArrayList
			 	- LinkedList
			 	- Queue
			 	- Stack
			 	- Vector(legacy)
			 	
			 2. Set 계열
			 	- HashSet
			 	- TreeSet
			 	
			 3. Map 계열
			 	- HashMap
			 	- TreeMap
			 	- Properties(legacy)
			 	- HashTable(legacy)
			 		  
		 */
		
		//ArrayList 컬렉션
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		//1. 요소 추가: boolean add(T value)
		// - 추가 성공 시 true, 실패 시 false 반환 
		// - 배열의 마지막에 추가하기 (이어 붙이기)
		list2.add("가");
		list2.add("나");
		list2.add("다");

		
		//2. 요소의 개수: int size()
		list2.size();
		System.out.println(list2.size());
		
		
		//3. 요소의 접근: T get(int index)
		System.out.println(list2.get(0));
		System.out.println(list2.get(list2.size() - 1));
		
		
		//4. 요소의 수정 T set(int index, T newValue)
		System.out.println(list2.set(2, "다라마바사")); //다 //수정 전 값 반환
		System.out.println(list2.get(2)); //다라마바사
		
		
		//5. 요소의 삭제: T remove(int index) / boolean remove(T value)
		//list2.remove(2); //방 번호를 찾아 삭제
		list2.remove("다라마바사"); //값을 찾아 삭제 //값이 여러 개면 첫 번째만 지운다
		
		
		//6. 요소 탐색: 루프
		
		//향상된 반복문 for
		//루프 변수에 의해 통제당했던 기존 for문에 비해, 배열(컬렉션)의 처음-끝을 탐색
		//첨자에 따른 통제가 불가능하다
		
		for (String i : list2) {
			System.out.println(i);
		}
		
		
		//7. 요소의 추가: void add(int index, T value)
		// - 1. 요소 추가의 오버로딩, 값을 삽입하고 right shift 발생
		
		list2.add(1, "한글");
		for (String i : list2) {
			System.out.println(i);
		}
		
		
		//8. 요소의 검색
		// - int indexOf(T value)
		// - int lastIndexOf(T value)
		// - boolean contains(T value)
		
		System.out.println(list2.indexOf("가"));  //0
		System.out.println(list2.contains("가")); //true
		
		
		//9. 요소 초기화: void clear();
		// - 모든 요소 삭제
		
		list2.clear();
		System.out.println(list2.size()); //0
		
		
		//10. 빈 배열 확인: boolean isEmpty()
		
		System.out.println(list2.isEmpty()); //true
	}
}
