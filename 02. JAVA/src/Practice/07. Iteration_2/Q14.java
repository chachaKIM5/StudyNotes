package com.test.java.question.iteration2;

public class Q14 {

	public static void main(String[] args) {
	
	
	/*
	 
	문제: 1 ~  10 :   55
	 	 1 ~  20 :  210
		 		...
	 	 1 ~ 100 : 5050 출력하기
	 
	 프로세스
	 1. 안쪽 for문 만들기 (1+2+3+... 누적 반복해서 1 ~ 10 : 55 한 줄 출력)
	 2. 바깥쪽 for문 만들기 (10, 20, 30, 40... 10 간격으로 100까지 증가하며 반복)
	  
	 */
		
		for (int j=10 ; j<=100 ; j+=10) {
				
			int sum = 0;

			for (int k=1 ; k<=j ; k++) {
				sum += k;
				
			} System.out.printf("1 ~ %3d : %4d\n", j, sum);
				
		}
	}
}
