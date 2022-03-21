package com.test.java.question.array2;

public class Q03 {

	public static void main(String[] args) {
		
	/*
	//대회전과 소회전을 바꾼다?
	 => 데이터 입력할 때 nums[i][j] = n을 nums[j][i]로 바꾼다!
	*/
	
		//배열 생성
		int[][] nums = new int[5][5];
		int n = 1;
		
		//입력
		for (int i=0 ; i<nums[0].length ; i++) {
			for (int j=0 ; j<nums.length ; j++) {
				nums[j][i] = n;
				n++;
			}
		}
		
		
		
		//출력(고정)
		for (int i=0 ; i<nums.length ; i++) {	
			for (int j=0 ; j<nums[0].length ; j++) {
				
				System.out.printf("%5d ", nums[i][j]);
			} 
			System.out.println();
		}
	
	
	
	} //main
}
