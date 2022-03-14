package com.test.java.question.overloading;

public class Q03 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스
	 1. 결과를 반환하는 메소드 5개 선언
	 	(메소드명 positive, 매개변수 int n1 ~ n1, n2, n3, n4, n5)
	 2. 메소드 바디에 int count 선언 및 0으로 초기화,
	 	조건 연산자로 count = n1 ~ n5 > 0일 경우 증감 연산자로 +1씩... int count값 반환
	 3. 메인 메소드에서 positive 호출, printf(양수: %d개\n)
	 
	 */

	int count = positive(10);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30, 40);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30, 40, 50);
	System.out.printf("양수: %d개\n", count);

	} //main

	public static int positive(int n1) {

	int count = 0;
	count = (n1 > 0) ? ++count : count; 

	return count;
	}

	public static int positive(int n1, int n2) {

	int count = 0;

	count = (n1 > 0) ? ++count : count; 
	count = (n2 > 0) ? ++count : count; 

	return count;
	}

	public static int positive(int n1, int n2, int n3) {

	int count = 0;

	count = (n1 > 0) ? ++count : count; 
	count = (n2 > 0) ? ++count : count; 
	count = (n3 > 0) ? ++count : count; 

	return count;
	}

	public static int positive(int n1, int n2, int n3, int n4) {

	int count = 0;

	count = (n1 > 0) ? ++count : count; 
	count = (n2 > 0) ? ++count : count; 
	count = (n3 > 0) ? ++count : count; 
	count = (n4 > 0) ? ++count : count; 

	return count;
	}

	public static int positive(int n1, int n2, int n3, int n4, int n5) {

	int count = 0;

	count = (n1 > 0) ? ++count : count; 
	count = (n2 > 0) ? ++count : count; 
	count = (n3 > 0) ? ++count : count; 
	count = (n4 > 0) ? ++count : count; 
	count = (n5 > 0) ? ++count : count; 

	return count;
	}
}