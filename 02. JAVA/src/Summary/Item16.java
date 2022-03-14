package com.test.java;

public class Item16 {

	public static void main(String[] args) {
		
		//[SUMMARY] 재귀 메소드 (2022. 3. 14. 오후 10:44:26)
		
		/*
		
		재귀 메소드: 구현부에서 자기 자신을 호출하는 구조를 가진 메소드
		
		cf) 팩토리얼 예시
		4! = 4 x 3 x 2 x 1
		4! = 24
		
		*/
		
		int n = 5;
		int result = factorial(n); //5!
		
		System.out.printf("%d! = %d\n", n, result);
		//출력 결과: "5! = 120"
		
	}//main
	
	public static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n-1);

	}	
}
