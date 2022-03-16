package com.test.java.question.iteration;

public class Q07 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스 설계
	 1. for문으로 무한 루프, int sum 선언해 누적 더하기
	 2. if sum >= 1000일 때 break로 for문 탈출
	 
	 *** sum += num;의 위치에 따라 결과가 달라진다
	  
	 */
		int sum = 0;
		
		for (int num=1 ; ; num++) {
			
			sum += num;
			
			if (sum >= 1000) {
				System.out.printf("%d = ", num);
				break;

			} else {
				System.out.printf("%d + ", num);
			}	
		}
		
		System.out.println(sum);
	}
}
