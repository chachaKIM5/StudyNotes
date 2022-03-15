package com.test.java;

public class Item24 {

	public static void main(String[] args) {
		
		//[SUMMARY] 중첩 if문 (2022. 3. 15. 오후 10:18:17)
		
		/* 
		 
		조건
		1. (score >= 0 && score <= 100)
			1.1 (score >= 60)
			1.2 else절
		2. 1의 불만족
		
		*/
		
		int score = 70;
		
		if (score >= 0 && score <= 100) {
				
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		
		} else {
			System.out.println("점수는 0~100 사이로 입력하세요.");
		}
	}
}
