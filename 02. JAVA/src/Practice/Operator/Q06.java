package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

		public static void main(String[] args) throws Exception {
		
		//com.test.java.question.operator > "Q06.java"
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원): ");
		String input = reader.readLine();
		
		double money = Double.parseDouble(input);
		double tax = (money * 0.033);
		
		System.out.printf(money >= 0 ? "세후 금액(원): %,.0f원\n세금(원): %,.0f원\n"
										: "정확한 금액을 입력해 주세요."
										, money - tax
										, tax);
		
		}
}
