package com.test.java;

import java.util.Stack;

public class Item55 {

	public static void main(String[] args) {
		
		//[SUMMARY] 자료구조, ADT(Stack) (2022. 3. 31. 오후 10:47:44)

		Stack<String> stack = new Stack<String>();
		
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
		 후입선출(Last Input First Output)
		 ex) 메모리 구조, 되돌리기(Ctrl+Z)&다시하기(Ctrl+Y)
		  
		 */
		
		 
		//1. 요소 추가하기(Push)
		// - T push(T value)
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		//2. 요소 개수 확인
		// - int size()
		System.out.println(stack.size()); //3
		
		//3. 요소 읽기
		// - T pop()
		// - 무조건 마지막 값을 꺼내고 삭제한다
		System.out.println(stack.pop()); //노랑
		System.out.println(stack.size());//2
		
		//4. 스택이 비어있는지 확인
		// - stack.size() == 0
		// - boolean isEmpty()
		System.out.println(stack.isEmpty()); //false
		
		
		//5. 요소 확인하기
		// - T peek()
		// - 마지막 값을 확인만 하고 삭제는 X
		System.out.println(stack.peek()); //파랑

	
	
	}
}
