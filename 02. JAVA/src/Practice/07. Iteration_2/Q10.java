package com.test.java.question.iteration2;

public class Q10 {

	public static void main(String[] args) {
		
		
		/*
		 
		 문제: 구구단을 출력하시오.
		 
		 프로세스 (3중 for문)
 		 1. 안쪽 for문 = "%d x %d = %d \t "로 한 2~5단 x 1 (첫줄)
		 2. 중간 for문 = 첫줄을 9까지 반복해 2, 3, 4, 5단 완성
		 3. 2의 문단을 반복해 6, 7, 8, 9단 완성
		 
		 */
	
		for (int k=2 ; k<=6 ; k+=4) { 
			
			for (int j=1 ; j<=9 ; j++) {
				
				for (int i=k ; i<=k+3 ; i++) {
					System.out.printf("%d x %d = %d \t ", i, j, i * j);
					
				} System.out.println();
				
			} System.out.println();
			
		}
		
		
	}//main
}

