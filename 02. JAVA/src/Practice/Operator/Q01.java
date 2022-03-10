package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		//com.test.java.question.operator > "Q01.java"
		//1번 문제
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("태어난 년도: ");
		String input = reader.readLine();

		int age = (2022 - Integer.parseInt(input) + 1);
		  
		System.out.printf(age > 0 && age <= 2022 ? "나이: %d세\n" : "정확한 년도를 입력해 주세요.\n", age);
		

	}
}
