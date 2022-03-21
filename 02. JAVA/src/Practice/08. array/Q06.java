package com.test.java.question.array;

import java.util.Arrays;

public class Q06 {

	public static void main(String[] args) {
		
	
	/*
	 
	 프로세스 설계
	 1. 길이가 6인 int[] lotto 생성, while 반복문 통해 요소마다 난수를 대입
	 2. 난수 범위는 Math.random()에 45를 곱하고 1을 더한 1 <= lotto < 46
	 3. Arrays.toString으로 출력
	 
	 //중복이 나올 경우를 놓쳐서 수정!
	  
	 */
		long begin = System.currentTimeMillis();

		
		int[] lotto = new int[6];
		boolean isDuplicate = false;
		
		int i = 0;
		while (i < lotto.length) {

			//난수 범위 1 <= lotto < 46
			//배열에 바로 넣지 않고 변수로 만들어서, 기존 배열의 숫자와 겹치는지 검사
			//중복되지 않아야만 배열에 넣기
			int n = (int)(Math.random() * 45 + 1);	
			
			//기존 배열의 숫자들
				for (int j=0 ; j<i ; j++) {
				
					isDuplicate = false;
					
					if (lotto[j] == n) {
						isDuplicate = true;
						i--;
						break;
					}
				}
				
			if (!isDuplicate) {
					lotto[i] = n;
			}
			
			i++;
		}
		
		System.out.println(Arrays.toString(lotto));
		
		
		
		long end = System.currentTimeMillis();
		//System.out.println(end - begin);
		
	} //main
}
