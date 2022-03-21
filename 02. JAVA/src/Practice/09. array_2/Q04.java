package com.test.java.question.array2;

public class Q04 {
	
	public static void main(String[] args) {
		
	/*
	 
	 프로세스
	 1. 바깥쪽 for문 => 행의 개수
	 2. 안쪽 for문 => 행(i)이 1 증가할수록 한 칸씩 줄어듦 => j<배열의 길이-i
	 3. 출력
	 */
		
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		//데이터 입력
			for (int i=0 ; i<nums.length ; i++) {
				for (int j=0 ; j<nums[0].length-i ; j++) {
					nums[i][j] = n;
					n++;
				}
			}
		
			
		
		//출력(고정)
			for (int i=0 ; i<nums.length ; i++) {
				for (int j=0 ; j<nums[0].length ; j++) {
					
					System.out.printf("%5d", nums[i][j]);
				}
				System.out.println();
			}
		


	} //main
}