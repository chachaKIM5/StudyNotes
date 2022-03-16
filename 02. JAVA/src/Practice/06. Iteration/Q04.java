package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
	
	/*
	 
	 프로세스 설계
	 1. 누적 변수인 짝수 개수, 짝수 합, 홀수 개수, 홀수 합 변수 선언 및 초기화
	 2. BufferedReader로 입력 횟수(int enter)먼저 입력받기
	 3. for 반복문으로 루프 변수 <= 입력받은 횟수(enter)일 때 루프 변수 +1씩 증가하며 실행문 반복
	 4. 실행문에서 숫자 입력받고 짝수, 홀수 판단 후 (1)의 변수에 더해 주기
	 5. 결과문 출력
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int even = 0;
		int evenSum = 0;
		
		int odd = 0;
		int oddSum = 0;
		
		System.out.printf("입력 횟수: ");
		int enter = Integer.parseInt(reader.readLine());
		
			for (int i=1 ; i <= enter ; i++) {
				
				System.out.print("숫자: ");
				int inputNum = Integer.parseInt(reader.readLine());
							
				if (inputNum % 2 == 0) {
					even++;
					evenSum += inputNum;
				} else {
					odd++;
					oddSum += inputNum;
				}
			}
			
		System.out.printf("짝수 %d개의 합: %d\n", even, evenSum);
		System.out.printf("홀수 %d개의 합: %d\n", odd, oddSum);
		
	} //main
}
