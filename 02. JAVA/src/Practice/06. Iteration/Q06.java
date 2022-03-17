package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 프로세스 설계
		 1. BufferedReader, parseInt로 시작 숫자(startNum)와 종료 숫자(endNum) 입력받기
		 2. 더한 값을 누적할 int sum = 0; 선언
		 3. 부호 바꿔줄 도구 int sign = 1; 선언
		 4.	시작 숫자 < 종료 숫자면 1씩 증가하는 for문, 시작 숫자 > 종료 숫자면 1씩 감소하는 for문  
		 5. sign이 양수면 "%d - " 출력, sign이 음수면 "%d + " 출력, 시작 숫자 = 종료 숫자 됐을 때 "%d = " 출력
		  	sign이 양수면 "%d - " 출력, sign이 음수면 "%d + " 출력, 시작 숫자 = 종료 숫자 됐을 때 "%d = " 출력
		 5. 안쪽 if문에서 빠져나오면,
		 	sum에 sign * startNum을 누적해서 더하기	
		 	sign에 (-1) 곱해 다음 for문 반복에 쓰일 부호 바꿔주기
		 6. 바깥 if문에서 빠져나오면 sum값 출력
		 
		 */
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		

		int sum = 0;
		int sign = 1;
		
		
		if (startNum <= endNum) {
			for ( ; startNum <= endNum ; startNum++) {
				
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
					
				} else if (sign > 0) {
					System.out.printf("%d - ", startNum);
					
				} else if (sign < 0) {
					System.out.printf("%d + ", startNum);
					
				} 
				sum += sign * startNum;
				sign *= (-1); 

			}
			
		} else {
			for ( ; startNum >= endNum ; startNum--) {
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
				} else if (sign > 0) {
					System.out.printf("%d - ", startNum);
				} else if (sign < 0) {
					System.out.printf("%d + ", startNum);
				}
				sum += sign * startNum;
				sign *= (-1);
			}
				
		} System.out.print(sum);

	}//main
}
		





//		int sum = 0;
//		int sign = 1;
//		
//		for (;;) {
//			
//			if (startNum == endNum) {
//				System.out.printf("%d", startNum);
//				sum += sign * startNum;
//				break;
//				
//			} else if (startNum < endNum) {
//				if (sign > 0) {
//					System.out.printf("%d - ", startNum);
//					
//				} else if (sign < 0) {
//					System.out.printf("%d + ", startNum);
//					
//				} sum += sign * startNum;
//				sign *= (-1);
//				startNum++;
//
//			} else {
//				if (sign > 0) {
//					System.out.printf("%d - ", startNum);
//
//				} else if (sign < 0) {
//					System.out.printf("%d + ", startNum);
//
//				} sum += sign * startNum;
//				sign *= (-1);
//				startNum--; 
//			}
//			
//		} System.out.printf(" = %d", sum);
//		
//		
//	}//main
//}	
		
		
		
		
		
		
		

