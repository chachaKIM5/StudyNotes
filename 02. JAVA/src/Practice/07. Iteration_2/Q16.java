package com.test.java.question.iteration2;

public class Q16 {

	public static void main(String[] args) {
		
	/*
	 
	 문제: 마지막 숫자가 100이 넘기 전까지 출력
	 	  1 + 2 + 4 + 7 + 11 ... + 92 = 469
	 	 
	 프로세스
	 1. 피연산자에 더해줄 변수(add), 실제로 더할 누적 변수(sum) 선언
	 2. add<=100 조건의 for문으로 listNum 문자열, sum값 구하기
	 3. "%s\b\b = %d", listNum, sum 결과 출력
	 
	 */
		
	String listNum = "";
	int sum = 0;
	int add = 1;
		
	for (int i=1 ; add<=100; i++) {
		
		listNum += add + " + ";

				sum += add;
				add += i;
			}


		
	
	System.out.printf("%s\b\b = %d", listNum, sum);
		
	}
}
