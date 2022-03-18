package com.test.java.question.iteration2;

public class Q15 {

	public static void main(String[] args) {

	/*
	 
	문제: 1 ~  10 :  55
	 	11 ~  20 : 155
	 		...
	 	91 ~ 100 : 955 출력하기

		 
	 프로세스
	 1. Q14와 비슷함!
	 2. 안쪽 for문 만들기 -> 루프 변수를 i=k+1로, 범위를 i<=k+10로
	 3. 바깥 for문 만들기 -> k를 0~90까지 10씩 증가하며 반복하도록
	  
	 */
		
		for (int k=0 ; k<100 ; k+=10) {
			
			int sum = 0;
			
			for (int i=k+1 ; i<=k+10 ; i++) {
				sum += i;
				
			} System.out.printf("%2d ~ %3d : %3d\n", k+1, k+10, sum);	

		}
	
	}
}
