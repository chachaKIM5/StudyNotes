package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex58_Queue {

	public static void main(String[] args) {
		
		//Ex58_Queue.java
		
		//Queue
		//- 선입선출
		//- Queue는 인터페이스, 객체를 만들 수 없다
		
		Queue<String> queue = new LinkedList<String>() ;
		
		//1. 요소 추가하기
		//- boolean add(T value)
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		
		//2. 요소 개수
		//- int size()
		
		System.out.println(queue.size()); //3
		
		
		//3. 요소 읽기 (=꺼내기, 선입선출, 가장 처음 넣은 요소 꺼내기)
		
		System.out.println(queue.poll()); //빨강
		System.out.println(queue.size()); //2
		
		System.out.println(queue.poll()); //파랑
		System.out.println(queue.size()); //1

		System.out.println(queue.poll()); //노랑
		System.out.println(queue.size()); //0

		System.out.println(queue.poll()); //null
		//*** stack은 비어 있을 때 꺼내면 에러, queue는 비어 있을 때 꺼내면 null ***

		
		//4. 비었는지 확인?
		System.out.println(queue.size() == 0);
		System.out.println(queue.isEmpty());
		
		
		//5. 요소 확인 //꺼내는 것 X, 확인만
		queue.add("주황");
		System.out.println(queue.peek()); //주황
		System.out.println(queue.size()); //1
		
		
		//6. 전부 지우기
		queue.clear();
		System.out.println(queue.size()); //0
		
	}
}
