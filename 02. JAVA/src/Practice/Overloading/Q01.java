package com.test.java.question.overloading;

public class Q01 {

	public static void main(String[] args) {
		
	/*
	
	 프로세스
	 1. 결과를 출력하는 메소드 5개 선언
	 	(메소드명 sum, 매개변수 int n1 ~ int n1, n2, n3, n4, n5)
	 2. 메소드 바디는 printf(int + int = int 더하기 결과)
	 4. 메인 메소드에서 sum 호출	
		 
	 */
	
	 sum(10);
	 sum(10, 20);
	 sum(10, 20, 30);
	 sum(10, 20, 30, 40);
	 sum(10, 20, 30, 40, 50);
		
	} //main
	
	public static void sum(int n1) {
	System.out.printf("%d = %d\n", n1, n1);
	}
	public static void sum(int n1, int n2) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}
	public static void sum(int n1, int n2, int n3) {
		System.out.printf("%d + %d + %d = %d\n", n1, n2, n3, n1 + n2 + n3);
	}
	public static void sum(int n1, int n2, int n3, int n4) {
		System.out.printf("%d + %d + %d + %d = %d\n", n1, n2, n3, n4, n1 + n2 + n3 + n4);
	}
	public static void sum(int n1, int n2, int n3, int n4, int n5) {
		System.out.printf("%d + %d + %d + %d + %d = %d\n", n1, n2, n3, n4, n5, n1 + n2 + n3 + n4 + n5);
	}
	
}
