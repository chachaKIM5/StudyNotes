package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
	
	/*
	
	프로세스
	1. BufferedReader로 근무년수 입력받기
	2. int career 변수 선언 및 Integer.parseInt 이용 입력받은 값 대입
	3. 중첩 if문으로 유효성 검사 및 조건에 따라 출력
		 
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("근무 년수: ");
		int career = Integer.parseInt(reader.readLine());
		
		if (career >= 1) {
			
			if (career < 5) {
				System.out.printf("%d년차 초급 개발자입니다.\n", career);
				System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.\n", 5 - career);

			} else if (career >= 5 && career < 10) {
				System.out.printf("%d년차 중급 개발자입니다.\n", career);
				System.out.printf("당신은 %d년 전까지 초급 개발자였습니다.\n", career - 4);
				System.out.printf("앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.\n", 10 - career);
				
			} else if (career >= 10) {
				System.out.printf("%d년차 고급 개발자입니다.\n", career);
				System.out.printf("당신은 %d년전까지 중급 개발자였습니다.\n", career - 9);
			}
		} else {
			System.out.println("입력한 값이 올바르지 않습니다. 1 이상의 값을 입력하시오.");
		}

		
	}//main

}
