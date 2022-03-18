package com.test.java.question.iteration2;

public class Q12 {

	public static void main(String[] args) {
		
	
		/*
		 
		 문제: 1~100 사이의 완전수를 구하시오.
		 
		 프로세스 설계
		 1. Q11과 비슷함!
		 2. i % j == 0일 때 카운트하지 않고 divSum에 약수(j)를 누적해 더하고,
		 		  					    문자열 list에 j + ", " 추가한다
		 3. 안쪽 for문 계산이 끝나면 divSum == 1일 때의 i, list를 출력한다.

		 */
		
		
		for (int i=1 ; i<=100 ; i++) {
			
			int divSum = 0;
			String list = "";
			
			for (int j=1 ; j<i ; j++) {
				if (i % j == 0) {
					divSum += j;
					list += j + ", ";
				}	
				
			} if (divSum == i) {
				System.out.printf("%d = [%s\b\b]\n", i, list);
			}
		}
		
	}
	
}
