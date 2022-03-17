package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03_while {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		
		System.out.print("숫자: ");
		int inputNum = Integer.parseInt(reader.readLine());		
		
		int sum = 0;
		int loop = 1;
		
		
		while (loop <= inputNum) {
			sum += loop;
			loop++;
		}
		
		System.out.printf("1 ~ %d = %d", inputNum, sum);
		
		
	}
}
