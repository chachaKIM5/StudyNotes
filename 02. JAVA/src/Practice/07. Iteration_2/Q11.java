package com.test.java.question.iteration2;

public class Q11 {

	public static void main(String[] args) {
		
		String output = "";
		
	/*
	 
	 문제: 2~100 사이의 소수를 구하시오.
	 
	 프로세스 설계
	 1. 2 ~ 100 사이에서 (변수 i) 하나씩 증가하는 for 반복문
	 2. 1의 i보다 작은 수가 하나씩 증가하며 나머지를 구하는 for 반복문
	 3. 나머지가 없이 딱 떨어질 때마다 divisor 변수에 ++,
	 4. 2의 연산이 끝난 후 divisor == 1이면 소수, 출력문에 추가
	 5. 다시 1로 돌아가서 다음 계산!
	 6. 모두 끝나면 출력\b\b
	  
	 */

		for (int i=2 ; i<=100 ; i++) {
			
			int divisor = 0;
			
			for (int j=1 ; j<i ; j++) {
				if (i % j == 0) {
					divisor++;
				}	
				
			} if (divisor == 1) {
				output += i + ", ";
			}
		}
		
		System.out.printf("%s\b\b", output);
		
	}
}
