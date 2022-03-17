package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
	/*
	 
	 문제: 자판기 프로그램을 구현하시오.
	 
	 프로세스
	 1. 엔터만 치면 반복되어야 하므로 while문 안에 무한 루프, readLine()으로 break 걸리는 형태의 자판기
	 2. 조건문 > 번호 1, 2, 3 선택에 따라 음료 이름과 가격 변동
	 3. 넣은 금액 < 음료 가격일 때 "금액이 부족합니다" 표시하기 (생략 가능)
	 4. 결과 출력, 엔터로 계속하기
	 
	 */
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int fee = 0;
		String drink = "";

		while (true) {
		
			System.out.println("===================");
			System.out.println("       자판기");
			System.out.println("===================");
			System.out.println("1. 콜라: 700원");
			System.out.println("2. 사이다: 600원");
			System.out.println("3. 비타500: 500원");
			System.out.println("-------------------");
			System.out.print("금액 투입(원): ");
			int inputCoin = Integer.parseInt(reader.readLine());
			System.out.println("-------------------");
			System.out.print("음료 선택(번호): ");
			int choice = Integer.parseInt(reader.readLine());
			
			switch (choice) {
				case 1:
					drink = "콜라";
					fee = 700;
					break;
				case 2:
					drink = "사이다";
					fee = 600;
					break;
				case 3:
					drink = "비타500";
					fee = 500;
					break;
			}
					
		
			if (inputCoin < fee) {
				System.out.println("금액이 부족합니다.");
			} else {
				System.out.printf("+%s를(을) 제공합니다.\n", drink);
				System.out.printf("+잔돈 %d원을 제공합니다.\n", inputCoin - fee);
			}
			
			System.out.println();
			System.out.print("계속하시려면 엔터를 입력하세요.");
			reader.readLine();
			System.out.println();
	
		}
		
		
	}//main
}