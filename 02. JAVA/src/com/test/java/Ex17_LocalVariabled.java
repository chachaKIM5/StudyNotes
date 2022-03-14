package com.test.java;

public class Ex17_LocalVariabled {

	public static void main(String[] args) {

		// Ex17_LocalVariabled.java

		// 자바 변수의 종류
		// 1. 멤버 변수
		// 2. 지역 변수

		// 지역 변수, Local Variable
		// - 메소드 안에서 선언한 변수
		// - 메소드 영역(=지역 =해당 변수의 지역)
		// - 변수가 선언된 메소드를 변수의 영역(Scope)이라고 생각한다.
		// 		> 지역 변수는 자신의 영역 밖으로 나가지 못한다.
		// 		> 외부 지역에서는 이 지역 변수에 접근할 수 없다. (*****)
		// 		> 변수의 가용 범위
		// - 메소드 매개변수도 지역 변수

		// - 지역 변수의 생명 주기, Life Cycle
		// 		> 어떤 요소가 태어나서(메모리에 생성) ~ 죽기까지(메모리에서 소멸)
		// 		> 생성: 변수 선언문이 실행되는 순간
		// 		> 소멸: 변수 선언문이 포함된 자신의 영역에서 제어가 벗어나는 순간

		int a = 10; // a는 main 메소드의 지역 변수다.
		m1();

		// System.out.println(b);

		int c = 10;

	} // main


	public static void m1() {

		int b = 20; // b는 m1 메소드의 지역 변수다.

		System.out.println(b);
		// System.out.println(a); // a cannot be resolved to a variable

	} // m1
}
