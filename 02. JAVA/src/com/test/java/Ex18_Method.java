package com.test.java;

public class Ex18_Method {

	public static void main(String[] args) {
		
		//Ex18_Method.java
		
		//재귀 메소드, Recursive Method
		// - 메소드가 구현부에서 자기 자신을 호출하는 구조를 가진 메소드
		// - 어렵다!
		// - 파일 디렉토리 구조에서 사용
		
		//m1();
		
		int n = 4;
		int result = m2(n);
		System.out.println(result);
		
		
		
		//팩토리얼 예시
		//4! = 4 x 3 x 2 x 1
		//4! = 24
		
		n = 5;
		result = factorial(n); //5!
		
		System.out.printf("%d! = %d\n", n, result);
		
	} //main
	
	public static void m1() {
		
		System.out.println("안녕하세요");
		System.out.println("홍길동입니다.");
		
		m1(); //재귀 호출
		
		System.out.println("반갑습니다.");
	}
	
	public static int m2(int n) {
		
		System.out.println(n);
		int result = (n == 1) ? 1 : m2(n-1);
		
		return result;
		
	}
	
	public static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n-1);
	}
}
