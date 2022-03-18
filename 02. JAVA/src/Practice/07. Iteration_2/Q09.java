package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {
	
	/*
	 
	 문제: 행 개수를 입력하면 첫줄 aa, 5번째 줄 abcdeedcba.. ~ 출력되는 영문자 찍기
	  
	 */
		
	//a=97, z=122
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		int row = Integer.parseInt(reader.readLine());
		
		for (int i=1 ; i<=row ; i++) {
			for (int j=row-1 ; j>=i ; j--) {
				System.out.print(" ");
			}
			for (int k=97 ; k<=i+96 ; k++) {
				System.out.print((char)(k));
			}
			for (int l=96+i ; l>=97 ; l--) {
				System.out.print((char)(l));
			}
			System.out.println();
		} 
		
		//첫번째 for문: 줄바꿈
		//두번째 for문: 입력된 행 개수-1개 -> 점점 줄어드는 공백 출력
		//세번째, 네번째 for문: 알파벳 출력(올바르게 & 뒤집어서)
		
	}
}
