package com.test.java.question.array2;

public class Q06 {

	public static void main(String[] args) {
		// 숫자를 채우는 과정에서 5행, 5열을 어떻게 합으로 채울 수 있을지 고민해보기
		// 잘 모르겠다 ㅠㅠ 일단 그냥 nums[4][n]의 값만 따로 for문을 만들어 채워놓음
		
		int[][] nums = new int[5][5];
		int n = 1;
		int sumCol = 0;
		int sumRow = 0;
		
		for (int i=0 ; i<nums.length-1 ; i++) {
			
			sumRow = 0;
			sumCol = 0;
			
			for (int j=0 ; j<nums[0].length ; j++) {
				
				if (j == nums[0].length-1) {
					nums[i][j] = sumRow;
				} else {
					nums[i][j] = n;
					sumRow += n;
					n++;
				}				
			} 
		}
		
		for (int i=0 ; i<nums.length ; i++) {
			
			sumCol = 0; 
			
			for (int j=0 ; j<nums[0].length-1 ; j++) {
				sumCol += nums[j][i];
			} nums[nums.length-1][i] = sumCol;
			
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
