package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 문제: 최대 숫자를 입력하면 1~최대 숫자까지
	 	  369 게임 과정을 출력하시오. (1 2 짝 4 5 짝 7 8 짝 ... ~ 최대 3자리수)
	 
	 1. 자릿수를 one, ten, hundred로 분해해서 각 자리에서 3의 배수가 나오면 "짝"을 출력
	 	3의 배수는 (숫자 % 3 == 0)으로 계산
	 	이때 0 % 3 = 0임을 주의한다
	 	
	 2. 가장 바깥에 유효성 검사를 위해 if문 (입력 숫자는 1과 999 사이)로 설정
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대 숫자: ");
		
		int max = Integer.parseInt(reader.readLine());
		int num = 1;
		
		int one; 		//일의 자리
		int ten; 		//십의 자리
		int hundred; 	//백의 자리
		
		
		if (max <= 999 && max > 0) {
		
			while (num <= max) {
				
				if (num <= 9) { 						//한자리수일 때
					if (num % 3 == 0) {
						System.out.print("짝 ");
					} else {
						System.out.printf("%d ", num);
					}
	
				} else if (num > 9 && num <= 99) {		//두자리수일 때
					ten = num / 10;
					one = num - (ten * 10);
					
					if ((ten % 3 == 0) || ((one % 3 == 0) && (one != 0))) {
						System.out.print("짝 ");
					} else {
						System.out.printf("%d ", num);
					}
				
				} else if (num >= 100 && num <= 999) {	//세자리수일 때
					hundred = num / 100;
					ten = (num - (hundred * 100)) / 10;
					one = num - ((hundred * 100) + (ten * 10));
					
					if ((hundred % 3 == 0) || ((ten % 3 == 0) && (ten != 0)) || ((one % 3 == 0) && (one != 0))) {
						System.out.print("짝 ");
					} else {
						System.out.printf("%d ", num);
					}
						
				} num++;
	
			}
		} else {
			System.out.println("3자리보다 작은 양수를 입력하세요.");
		}
		
	}
}
