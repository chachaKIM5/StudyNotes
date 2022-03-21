package com.test.java.question.array2;

public class Q02 {

	public static void main(String[] args) {
		
		/*
		 
		 프로세스
		 1. 2중 for문 이용해 데이터 입력 및 출력 (Q01과 비슷하다)
		 2. 배열의 길이가 달라져도 올바른 결과가 나올 수 있도록 작성해 보기
		 
		 */
		
		//배열 생성
		int[][] nums = new int[5][5];
		
		
		
		//데이터 입력
		int n = nums.length * nums[0].length;
		
		for (int i=0 ; i<nums.length ; i++) {
			for (int j=0 ; j<nums[0].length ; j++) {
				
				nums[i][j] = n;
				n--;
			}
		}
		
		
		
		//출력(고정)
		for (int i=0 ; i<nums.length ; i++) {
			for (int j=0 ; j<nums[0].length ; j++) {
		
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}
}
