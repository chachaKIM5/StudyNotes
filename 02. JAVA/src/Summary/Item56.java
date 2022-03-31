package com.test.java;

import java.util.LinkedList;
import java.util.Queue;

public class Item56 {

	public static void main(String[] args) {
		
		//[SUMMARY] ADT (Queue) (2022. 3. 31. 오후 10:54:27)

		/*
		  
		 Queue
		 - 선입선출
		 - Queue는 인터페이스, 객체를 만들 수 없다
		 - -> LinkedList 활용
				
		*/
	
		Queue<String> queue = new LinkedList<String>() ;
				
		//1. 요소 추가하기
		// - boolean add(T value)
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		
		//2. 요소 개수 확인하기
		// - int size()
		
		System.out.println(queue.size()); //3
		
		
		//3. 요소 읽기
		// - T poll()
		// - 선입선출, 가장 처음 넣은 요소를 꺼내고 삭제한다
		
		System.out.println(queue.poll()); //빨강
		System.out.println(queue.size()); //2
		
		
		//4. queue가 비었는지 확인?
		// - boolean isEmpty()
		
		System.out.println(queue.isEmpty()); //false
		
		
		//5. 요소 확인
		// - 가장 처음 요소를 확인만 하기
		// - T peek()
		System.out.println(queue.peek()); //파랑
		
		
		//6. 전부 지우기
		// - void clear()
		queue.clear();
		System.out.println(queue.size()); //0
	
	
	}
}
