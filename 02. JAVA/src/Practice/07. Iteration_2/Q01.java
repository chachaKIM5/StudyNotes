package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 문제: 숫자를 N개 입력받고 아래와 같이 출력하시오.
		 (루프는 누적값이 100을 넘기는 순간 종료)
		 
		 출력(짝수는 더하고 홀수는 뺀다)
		 12 + 28 - 39 - 15 + 38 + 24 + 78 = 126
		 
		 
		 프로세스 설계
		 1. BufferedReader로 숫자 입력받기
		 2. while문으로 누적값이 100이 넘을 때까지 반복
		 3. if문으로 첫 번째 숫자는 + 부호 없이 출력, 나머지는 + 짝수, - 홀수를 문자열에 누적해서 대입
		 4. 문자열과 누적값 출력
		 
		 */
		
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	int sum = 0;
	int input;
	String output = "";
	
	
	
	while (sum < 100) {
		
		System.out.print("숫자: ");
		input = Integer.parseInt(reader.readLine());
		
			if (input % 2 == 0) {
				sum += input;
				
				if (input == sum) {
					output += input;
				} else {
					output += " + " + input;
				}
					
			} else {
				sum -= input;
				
				if (-input == sum) {
					output += "-" + input;
				} else {
					output += " - " + input;
				}
			}
			
	} System.out.printf("%s = %d", output, sum);
	
	
	}
}
