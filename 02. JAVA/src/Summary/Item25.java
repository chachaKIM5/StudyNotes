package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Item25 {

	public static void main(String[] args) throws Exception {

		//[SUMMARY] switch문, 조건문 (2022. 3. 16. 오후 10:37:33)
		
		/*
		switch (조건) {
			case 값:
				실행문;
				break;
			[case 값:
				실행문;
				break;] X N
			[default:
				실행문;
				break;]
		*/
		
		
		//예시
		//요구사항] 인터넷 쇼핑몰의 상품 구매 > 패키지 옵션
		//1. 노트북 + USB C타입 케이블 + 마우스패드
		//2. 노트북 + USB C타입 케이블
		//3. 노트북
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("선택(1~3): ");
		String input =  reader.readLine();

		switch (input) {
			case "1":
				System.out.println("마우스패드");
			case "2":
				System.out.println("USB C타입 케이블");
			case "3":
				System.out.println("노트북");
				break;
		}
		
		
	}
}
