package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 문제: 첫줄은 *로 시작, 입력받은 행만큼 개수가 늘어나는 별찍기 
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		
		int row = Integer.parseInt(reader.readLine());
		
		
		for (int i=0 ; i<row ; i++) {
			
			for (int j=row-1 ; j>i ; j--) {
				System.out.printf(" ");
			}
			for (int k=1 ; k<=2 * i + 1 ; k++) {
			 	System.out.printf("*");
			}
			
			System.out.println();
		}
		
	 //첫 for문은 줄바꿈 용도
	 //두번쨰 for문은 j=row-1가 i보다 작아지기 직전까지 반복해서 공백 출력
	 //세번째 for문은 별을 2 * i +1개 출력하는 식
		
		
	}//main
}
