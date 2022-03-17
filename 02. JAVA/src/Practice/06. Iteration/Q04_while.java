package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04_while {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("입력 횟수: ");
		int enter = Integer.parseInt(reader.readLine());

		int even = 0,
			evenSum = 0;
		
		int odd = 0,
			oddSum = 0;
		
		int loop = 1;

		
		while (loop <= enter) {
			
			System.out.print("숫자: ");
			int inputNum = Integer.parseInt(reader.readLine());
					
			if (inputNum % 2 == 0) {
				even++;
				evenSum += inputNum;
				
			} else {
				odd++;
				oddSum += inputNum;

			} loop++;
			
		}
			
		System.out.printf("짝수 %d개의 합: %d\n", even, evenSum);
		System.out.printf("홀수 %d개의 합: %d\n", odd, oddSum);
		
	}
}
