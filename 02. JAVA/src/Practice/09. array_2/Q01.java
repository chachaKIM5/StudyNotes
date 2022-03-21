package com.test.java.question.array2;

public class Q01 {

	public static void main(String[] args) {
	
		/*
		 
		 프로세스
		 1. for문(1) int[][]에 데이터 입력
		    홀수 행은 [n][0~4] 순서대로 n을 입력, n++
		    짝수 행은 [n][4~0] 순서대로 n을 입력, n++
		 2. for문(2) 출력
		 
		 if문으로 홀짝을 나누지 않고 풀 수 있는 방법이 없을까..??
		 */
		
		
		int[][] nums = new int[5][5];
	
		//데이터 입력 (문제)
		int n = 1;
		
		for (int i=0 ; i<5 ; i++) {	

			if (i % 2 == 0) {
				for (int j=0 ; j<5 ; j++) {
					nums[i][j] = n;
					n++;
				}
				
			} else {
				for (int j=4 ; j>=0 ; j--) {
					nums[i][j] = n;
					n++;
				}
			} 
		}	
			
		
		
		//데이터 출력 (고정)
		for (int i=0 ; i<nums.length ; i++) {
			for (int j=0 ; j<nums[0].length ; j++) {
		
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
	} //main
}
