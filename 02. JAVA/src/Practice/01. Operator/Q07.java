package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
		
		public static void main(String[] args) throws Exception {
			
		//com.test.java.question.operator > "Q07.java"
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력: ");
		String input = reader.readLine();
		char c = input.charAt(0);
		int code = (int)c;
		
		System.out.printf(code >= 97 && code <= 122 ? "소문자 \'%c\'의 대문자는 \'%c\'입니다."
										: "영문 소문자만 입력해 주세요."
										, c
										, (char)code - 32);
		
	}
}
