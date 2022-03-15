package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
	/*
		 
	프로세스
	1. BufferedReader로 점수 입력받기
	2. int score 변수 선언 및 Integer.parseInt로 입력받은 점수 대입해 변수 초기화
	3. 중첩 if문으로 유효성 검사 및 조건에 따라 성적 출력
		 
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수: ");
		int score = Integer.parseInt(reader.readLine());
		
		if (score >= 0 && score <= 100) {
			
			if (score >= 90) {
				System.out.printf("입력한 %d점은 성적 A입니다.", score);

			} else if (score >= 80 && score < 90) {
				System.out.printf("입력한 %d점은 성적 B입니다.", score);
				
			} else if (score >= 70 && score < 80) {
				System.out.printf("입력한 %d점은 성적 C입니다.", score);
				
			} else if (score >= 60 && score < 70) {
				System.out.printf("입력한 %d점은 성적 D입니다.", score);
				
			} else {
				System.out.printf("입력한 %d점은 성적 F입니다.", score);
			}
			
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}
		
	}//main
}
