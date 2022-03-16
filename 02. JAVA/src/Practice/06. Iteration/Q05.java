package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스 설계
	 1. BufferedReader, parseInt로 시작 숫자(startNum)와 종료 숫자(endNum) 입력받기
	 2. 더한 값을 누적할 int sum = 0; 선언
	 3.	(1) 시작 숫자 < 종료 숫자인 경우
	  	 	시작 숫자 1씩 증가하면서 "%d + " 출력, 시작 숫자 = 종료 숫자 됐을 때 "%d = " 출력
	 4. (2) 시작 숫자 > 종료 숫자인 경우,
	 		시작 숫자 1씩 감소하면서 "%d + " 출력, 시작 숫자 = 종료 숫자 됐을 때 "%d = " 출력
	 5. 안쪽 if문에서 빠져나오면 sum에 startNum을 누적해서 더하면서 for문 반복
	 6. 바깥 if문에서 빠져나오면 sum값 출력
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		if (startNum <= endNum) {
			for ( ; startNum <= endNum ; startNum++) {
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
				} else {
					System.out.printf("%d + ", startNum);
				} sum += startNum;
			}
			
		} else {
			for ( ; startNum >= endNum ; startNum--) {
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
				} else {
					System.out.printf("%d + ", startNum);
				} sum += startNum;
			}
				
		} 
		
		System.out.print(sum);

	}
}