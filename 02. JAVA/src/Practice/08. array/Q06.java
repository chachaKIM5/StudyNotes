package com.test.java.question.array;

import java.util.Arrays;

public class Q06 {

	public static void main(String[] args) {
		
	
	/*
	 
	 프로세스 설계
	 1. 길이가 6인 int[] lotto 생성, while 반복문 통해 요소마다 난수를 대입
	 2. 난수 범위는 Math.random()에 45를 곱하고 1을 더한 1 <= lotto < 46
	 3. Arrays.toString으로 출력
	  
	 */
		
		int[] lotto = new int[6];
		
		
		int i = 0;
		while (i < lotto.length) {

			
			//난수 범위 1 <= lotto < 46
			lotto[i] = (int)(Math.random() * 45 + 1);
							
				i++;	
			
		}
		
		System.out.println(Arrays.toString(lotto));
		
		
		
	} //main
}
