package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int row = Integer.parseInt(reader.readLine());
		
		
		for (int i=1 ; i<=row ; i++) {
			
			for (int j=1 ; j<=i-1 ; j++) {
				System.out.print(" ");
			}
			
			for (int k=row ; k>=i ; k--) {
				System.out.print("*");
			} 
			
			System.out.println();
		}
		
		//가장 바깥쪽 for문: 줄바꿈의 역할
		//두번째 for문: j가 i-1가 될 때까지 ++하며 공백을 찍는다
		//세번째 for문: 현재 값 row, row=k가 i가 될 때까지 --하며 별을 찍는다
		
	} //main
}
