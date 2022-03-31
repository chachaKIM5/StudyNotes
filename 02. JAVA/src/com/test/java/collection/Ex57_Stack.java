package com.test.java.collection;

import java.util.Stack;

public class Ex57_Stack {

	public static void main(String[] args) {
		
		//Ex57_Stack.java
		
		/*
		 
		 자료구조(컬렉션)
		 - 데이터를 저장하는 공간의 구조
		 - ex) 배열 > 선형 구조
		 - 물리적인 특징을 가지고 있는 종류
		 - 추상적인(사용법) 특징을 가지고 있는 종류
		 - 물리적, 추상적 특징을 가지고 있는 종류
		 
		 ADT
		 - Abstract Data Type, 추상적 자료형
		 - Stack, Queue
		 - 특징: 물리적인 특성(X), 사용법의 특성(O)
		 
		 Stack
		 - 후입선출 (LIFO, Last Input First Output)
		 - 저장소에 나중에 들어간 요소가 먼저 나온다
		 ex) 메모리 구조(Stack)
		 ex) 되돌리기(Ctrl+Z), 다시하기(Ctrl+Y)
		 ex) 인터넷 브라우저의 뒤로가기 목록
		 
		 Queue
		 - 선입선출 (FIFO, First Input First Output)
		 - 저장소에 먼저 들어간 요소가 먼저 나온다
		 ex) 줄서기
		  
		 */
		
		//m1();
		m2();
	}

	private static void m2() {					//stack 메소드 5
		
		Stack<String> stack = new Stack<String>();

		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		//5. 요소 확인하기 (읽기, 삭제 X, 가장 끝 요소 확인)
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
	}


	private static void m1() {	 				//stack 메소드 1~4

		Stack<String> stack = new Stack<String>(); 
		
		//후입선출
		
		//1. 요소 추가하기 (Push, Push Down)
		//- T push(T value)
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		//2. 요소 개수 확인
		//- int size()
		System.out.println(stack.size());
		
		//3. 요소 읽기 (꺼내기 == 삭제하기)
		//- T pop()
		//- 무조건 마지막 값을 꺼낸다
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		//4. 스택이 비어있는지 확인
		System.out.println(stack.size() == 0);
		System.out.println(stack.isEmpty());

		if (!stack.isEmpty()) {
			System.out.println(stack.pop());
			System.out.println(stack.size());
		}
		
		
		
	}
}
