package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

		public static void main(String[] args) throws Exception {
		
		//com.test.java.question.operator > "Q04.java"
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(˚C): ");
		String input = reader.readLine();
		
		double num = Double.parseDouble(input);
				
		System.out.printf("섭씨 %.1f˚C는 화씨 %.1f˚F입니다.\n", num, (num * 1.8 + 32));
			
		}
		
}
