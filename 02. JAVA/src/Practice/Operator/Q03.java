package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
		//com.test.java.question.operator > "Q03.java"
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm): ");
		String input1 = reader.readLine();
		
		System.out.print("높이(cm): ");
		String input2 = reader.readLine();
		
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		System.out.printf((num1 > 0) && (num2 > 0) ?
								"사각형의 넓이는 %dcm²입니다.\n사각형의 둘레는 %dcm입니다.\n"
								    : "정확한 길이를 입력해 주세요.\n"
									, num1 * num2
									, 2 * (num1 + num2));
		
		
	}
	
}
