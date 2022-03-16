package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

		public static void main(String[] args) throws Exception {
			
		//com.test.java.question.operator > "Q05.java"
		//inch : cm : m = 1 : 2.54 : 0.0254
		//자전거 바퀴의 지름: 26인치 > 66.04cm > 0.6604m
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("사용자가 페달을 밟은 횟수: ");
		String input = reader.readLine();
		
		Double num = Double.parseDouble(input);
				
		System.out.printf(num >= 0 ? "사용자가 총 %,.0f회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.\n"
	   							    : "정확한 횟수를 입력해 주세요.\n"
									, num
									, (66.04 * 3.14 * num) / 100);
		
				
			
		}
}
