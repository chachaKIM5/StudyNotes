package com.test.java.question.array2;

public class Q05 {

	public static void main(String[] args) {
		
		
		/*
		
		 프로세스
		 1. 다이아몬드를 상단, 하단 if문으로 나누기
		 2. 배열의 길이/2 = middle로 int 변수 생성
		 3. 변수인 i와 middle로 j의 범위를 적당히 표현한다
		 4. 출력
		 
		 nums.length를 가지고 범위를 표현하려다 보니 식이 복잡해졌다
		 하단 부분에 nums.length+(middle-1)-i을 다르게 표현하는 방법??
		 
		 */
		
		//배열 길이는 홀수x홀수로 해야 오류 없이 다이아몬드를 만들 수 있음
		int[][] nums = new int[5][5];
		
		int n = 1;
		int middle = (nums.length / 2);
		
		
		// 데이터 입력
		for (int i=0 ; i<nums.length ; i++) {
			
			//상단~중간
			if (i<=middle) {
				for (int j=middle-i ; j<=middle+i ; j++) {
					nums[i][j] = n;
					n++;
				}
				
				
			//하단
			} else {
				for (int j=i-middle ; j<=(nums.length+middle-1)-i ; j++) { 
					nums[i][j] = n;
					n++;
				}
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
