package com.test.java;

public class Item15 {

	public static void main(String[] args) {
		
		//[SUMMARY] Swap (2022. 3. 14. 오후 10:36:10)
		
		/*
		 
		  1. 빈 공간 추가해 이용하기
		  2. 비트 연산자 이용하기
		  
		 */
		
		// 빈 공간 추가해 이용하기 (Method swap1)
		int n1 = 10;
		int n2 = 20;
		
		swap1(n1, n2);
		
		
		//비트 연산자 이용하기 (Method swap2)
		
		int n3 = 50;
		int n4 = 100;
		
		swap2(n3, n4);

	} //main
	
	

	public static void swap1(int n1, int n2) {		
		
		int temp;
		
		temp = n1;
		n1 = n2;
		n2 = temp;
		
		System.out.printf("n1 = %d\nn2 = %d\n", n1, n2);
		
	}


	
	public static void swap2(int n3, int n4) {
		
		n3 = n3 ^ n4;
		n4 = n3 ^ n4;
		n3 = n3 ^ n4;
		
		System.out.printf("n3 = %d\nn4 = %d", n3, n4);
	}
	
}
