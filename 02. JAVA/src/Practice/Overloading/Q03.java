package com.test.java.question.overloading;

public class Q03 {

	public static void main(String[] args) {
		
	/*
	
	프로세스
	 1. 결과를 반환하는 메소드 5개 선언
	 	(메소드명 positive, 매개변수 int n1 ~ n1, n2, n3, n4, n5)
	 2. 메소드 바디는 조건 연산자로 result = n1~n5 >= 0일 경우 +1씩... int result값 반환
	 3. 메인 메소드에서 sum 호출, printf(양수: %d개)

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
		int result = (n1 > 0) ? 1 : 0 ;
		
		return result;
	}

	public static int positive(int n1, int n2) {
		int result = (n1 > 0) ? 1 : 0 ;		
			result = (n2 > 0) ? (result + 1) : result;	
		
		return result;
	}
	
	public static int positive(int n1, int n2, int n3) {
		int result = (n1 > 0) ? 1 : 0 ;	
			result = (n2 > 0) ? (result + 1) : result;
			result = (n3 > 0) ? (result + 1) : result;
		
		return result;
	}
	
	public static int positive(int n1, int n2, int n3, int n4) {
		int result = (n1 > 0) ? 1 : 0 ;	
			result = (n2 > 0) ? (result + 1) : result;
			result = (n3 > 0) ? (result + 1) : result;
			result = (n4 > 0) ? (result + 1) : result;
		
		return result;
	}
	
	public static int positive(int n1, int n2, int n3, int n4, int n5) {
		int result = (n1 > 0) ? 1 : 0 ;	
			result = (n2 > 0) ? (result + 1) : result;
			result = (n3 > 0) ? (result + 1) : result;
			result = (n4 > 0) ? (result + 1) : result;
			result = (n5 > 0) ? (result + 1) : result;
		
		return result;
	}
}
