package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스 설계
	 1. BufferedReader, parseInt로 시작 숫자(startNum)와 종료 숫자(endNum) 입력받기
	 2. 더한 값을 누적할 int sum = 0; 선언
	 3. for문 안에서 startNum을 1씩 증감 & 누적 변수 sum에 startNum을 더하면서 무한 루프,
	  (1) 시작 숫자 = 종료 숫자: 루프 탈출
	  (2) 시작 숫자 < 종료 숫자: 1씩 증가
	  (3) 시작 숫자 > 종료 숫자: 1씩 감소
	 4. for문을 탈출하면 "= sum" 값을 출력, 마지막 + 없애기 위해 \b\b 추가
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (;;) {
			System.out.printf("%d + ", startNum);
			sum += startNum;
			
				if (startNum == endNum) {
					break;
				} else if (startNum <= endNum) {
					startNum++;
				} else {
					startNum--;				
				}

		} System.out.printf("\b\b= %d", sum);
		
	}
}