package com.test.java.question.iteration2;

public class Q17 {

	public static void main(String[] args) {
		
	
	/*
	 
	 문제: 마지막 숫자가 100이 넘기 전에 출력하시오.
	 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232
	 
	 프로세스
	 1. add1, add2 선언해 서로 더해가면서 식 만들기
	 2. sum값은 번갈아가며 더해준다
	 3. add1, add2 중 하나가 100을 넘으면 break로 제어문 탈출
	 4. 출력
	 
	 */
	
	 int add1 = 1;
	 int add2 = 1;
	 int sum = 0;
	 String output = "";
	 
	 for (;;) {
		 
		 if (add1 > 100) {
			 break;
		 }
		 
		 sum += add1;
		 output += add1 + " + ";
		 add1 += add2;

		 if (add2 > 100) {
			 break;
		 }
		 sum += add2;
		 output += add2 + " + ";
		 add2 += add1;
		 
	 }
	 System.out.printf("%s\b\b= %d", output, sum);

	}
}