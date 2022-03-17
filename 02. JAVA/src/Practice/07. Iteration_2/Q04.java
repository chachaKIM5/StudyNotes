package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 문제: 최대 9자리 정수를 입력받아 각 자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
		 
		 프로세스
		 1. BufferedReader로 숫자 입력받기
		 2. Math.pow() 이용해 9자릿수 -> 1자릿수까지 반복문
		 	해당 자릿수가 존재하는지 없는지 구한다 -> 존재한다면 짝수인지, 홀수인지 판단
		 3. 짝수는 짝수끼리, 홀수는 홀수끼리 누적 변수에 더한다
		 4. 출력
		 5. 전체를 if문으로 감싸서 9자리 이하 숫자 유효성 검사하기 (생략 가능)
		
		 
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력: ");
		int input = Integer.parseInt(reader.readLine());
		
		int evenSum = 0;
		int oddSum = 0;

		int i = 8;
		
		if (input >= 1 && input < 1000000000) {
			while (i >= 0) {
				
				int position = (int)(Math.pow(10, i)); 	// i=8일 때 position은 100000000 (9자리) 
				int num = input / position;
	
				
				if (num < 1) { 							// num이 1보다 작다 = (자릿수 <= i)
					i--;
					continue;
					
				} else if (num >= 1 && num < 10) {
					if (num % 2 == 0) {
						evenSum += num;
					} else {
						oddSum += num;
					}
					
				input -= num * position;
				i--;
				}
			}
			System.out.printf("짝수의 합: %d\n", evenSum);
			System.out.printf("홀수의 합: %d", oddSum);
			
			
		} else if (input >= 1000000000) {
			System.out.println("9자리 이하 숫자를 입력하세요.");
		}
			

	}
}
