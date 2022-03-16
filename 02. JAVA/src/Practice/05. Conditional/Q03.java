package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {

	/*
		
	프로세스
	1. BufferedReader로 점수 입력받기
	2. String letter 변수 선언 및 입력받은 값 대입해 변수 초기화
	3. 중첩 if문으로 유효성 검사 및 조건에 따라 출력
		 
	*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("문자: ");
		String letter = reader.readLine();


		if (letter.equals("f") || letter.equals("F")
			|| letter.equals("m") || letter.equals("M")
			|| letter.equals("s") || letter.equals("S") 
			|| letter.equals("b") || letter.equals("B")) {

			if (letter.equals("f") || letter.equals("F")) {
				System.out.println("Father");

			} else if (letter.equals("m") || letter.equals("M")) {
				System.out.println("Mother");

			} else if (letter.equals("s") || letter.equals("S")) {
				System.out.println("Sister");

			} else if (letter.equals("b") || letter.equals("B")) {
				System.out.println("Brother");
			}

		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		}

	}// main
}
