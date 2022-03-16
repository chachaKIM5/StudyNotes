package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {

		/*
		 
		프로세스
		1. BufferedReader로 영문자 1개 입력받기
		2. char input = "reader.readLine()".charAt(0)으로 char형으로 바꿔 대입
		3. 중첩 if문 통해 유효성 검사(영문자인가?), 소문자면 대문자로, 대문자면 소문자로 출력
		  참고) 	'A' ~ 'Z' : 65 ~ 90
				'a' ~ 'z' : 97 ~ 122
		  
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자: ");
		char input = reader.readLine().charAt(0);

		if ((input >= 65 && input <= 90) || (input >= 97 && input <= 122)) {

			if (input >= 65 && input <= 90) {
				System.out.printf("'%c'의 소문자는 '%c'입니다.\n", input, input + 32);

			} else if (input >= 97 && input <= 122) {
				System.out.printf("'%c'의 대문자는 '%c'입니다.\n", input, input - 32);

			}

		} else {
			System.out.println("영문자만 입력하시오.");
		}


	} // main
}
