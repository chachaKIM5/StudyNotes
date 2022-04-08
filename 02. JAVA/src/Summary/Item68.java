package com.test.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Item68 {

	public static void main(String[] args) {

		//[SUMMARY] 람다식(Lambda), 익명객체 (2022. 4. 9. 오전 12:17:42)
		
		/*
		 
		  람다식
		   - 함수형 프로그래밍을 지원하는 표현식
		   - 인터페이스를 상속하는 익명 객체를 간소화시킨 기술 -> 코드 단축!
		  
		   - 기본 형식
		     인터페이스 변수 = 람다식;
		     MyInterface m1 = () -> {};
		     
		   - (매개변수) -> {실행코드} 
		   		- (매개변수): 메소드의 매개변수 리스트와 동일
		   		- -> (화살표, Arrow): 코드블럭 호출 역할
		   		- {실행 블럭}: 메소드의 구현부(body)
		   		
		   		
		   - 실행문 1줄일 경우 중괄호{}를 생략할 수 있다
	 	   - 매개변수의 자료형을 생략할 수 있다
		   - 매개변수가 1개일 경우 소괄호()도 생략할 수 있다
		   - 실행문에 return만 적혀 있을 경우 return도 생략할 수 있다
		   
		 */
		
		m1_Lambda_Comparator_Example();
		
		//1. 매개변수 X, 반환값 X
		
		NoParameterNoReturn pr1 = new NoParameterNoReturn() {
			@Override
			public void call() {
				System.out.println("pr1");
			}
		};
		
		
		//실행문 1줄일 경우 중괄호{}를 생략할 수 있다
		NoParameterNoReturn pr2 = () -> System.out.println("pr2");
		
		
		pr1.call(); //pr1
		pr2.call(); //pr2
		
		
		
		//2. 매개변수 O, 반환값 X
		// 	 매개변수 O(여러 개), 반환값 X
		
		//매개변수의 자료형을 생략할 수 있다
		//매개변수가 1개일 경우 소괄호()도 생략할 수 있다
		ParameterNoReturn pr3 = num -> System.out.println(num);
		MultiParameterNoReturn pr4 = (name, num) -> System.out.printf("이름: %s, 나이: %d\n", name, num);

		pr3.call(300); //300
		pr4.call("김승연", 27); //이름: 김승연, 나이: 27
		
		
		
		//3. 매개변수 X, 반환값 O
		
		//실행문에 return만 적혀 있을 경우 return도 생략할 수 있다
		NoParameterReturn pr5 = () -> { return 100; };
		NoParameterReturn pr6 = () -> 200;
			
		System.out.println(pr5.call()); //100	
		System.out.println(pr6.call()); //200
		
	}

	private static void m1_Lambda_Comparator_Example() {
		
		//Comparator 예시로 알아보는 람다식 활용
		//난수가 들어간 ArrayList 정렬하기
		
		Random rnd = new Random();

		ArrayList<Integer> nums = new ArrayList<Integer>();

		for(int i=0 ; i<10 ; i++) {
			nums.add(rnd.nextInt(20) + 1);
		}

		System.out.println(nums); //[11, 12, 12, 2, 1, 8, 17, 19, 4, 5]

		//오름차순 정렬
		nums.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		System.out.println(nums); //[1, 2, 4, 5, 8, 11, 12, 12, 17, 19]


		//내림차순 정렬, 위 정렬식이 한 줄로 단축!
		nums.sort((o1, o2) -> o2 - o1);
		System.out.println(nums); //[19, 17, 12, 12, 11, 8, 5, 4, 2, 1]
		
		
		
		
		
	}
}

interface NoParameterNoReturn {
	void call();
}


interface ParameterNoReturn {
	void call(int num);
}


interface MultiParameterNoReturn {
	void call(String name, int age);
}

interface NoParameterReturn {
	int call();
}