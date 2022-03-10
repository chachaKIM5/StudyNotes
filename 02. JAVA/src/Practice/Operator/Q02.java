package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		//com.test.java.question.operator > "Q02.java"
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		String input1 = reader.readLine();
		
		System.out.print("두번째 숫자: ");
		String input2 = reader.readLine();
		
		double num1 = Double.parseDouble(input1);
		double num2 = Double.parseDouble(input2);
		
		System.out.printf("%,.0f + %,.0f = %,.1f\n", num1, num2, num1 + num2);
		System.out.printf("%,.0f - %,.0f = %,.1f\n", num1, num2, num1 - num2);
		System.out.printf("%,.0f * %,.0f = %,.1f\n", num1, num2, num1 * num2);
		System.out.printf("%,.0f / %,.0f = %,.1f\n", num1, num2, num1 / num2);
		System.out.printf("%,.0f %% %,.0f = %,.1f\n", num1, num2, num1 % num2);
		
	}
}
