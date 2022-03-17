package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
	
	/*
	  문제: 1~9 사이의 숫자 10개를 입력받아 "오칠사삼오칠육이일삼"과 같이 출력하시오.
	 
	  프로세스
	  1. 10번 반복되는 while문 안에서 BufferedReader로 input 입력받는다
	  2. (생략 가능) input이 1~9 사이가 아닐 경우 continue 이용 다시 while문으로
	  3. switch 메소드로 일(1)~구(9) 연결시켜 return값 가져오고,
	  4. 3을 출력될 output 문자열에 더한다
	  5. 출력
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		String output = "";
		int userTry = 1;
		
		while (userTry <= 10) {

			System.out.print("숫자: ");
			String input = reader.readLine();

				//if문 생략 가능(1~9 유효성 검사)
				if ((Integer.parseInt(input) < 1 ||
					 Integer.parseInt(input) > 9)) {
					
					System.out.printf("%d번째 숫자부터 다시 입력하세요.(1~9)\n", userTry);
					continue;
				}
			
			output += korNum(input);
			userTry++;
		}
		
		System.out.print(output);
		
	
	} //main
	
	public static String korNum(String input) {
		
		switch (input) {
			case "1":
				return "일";
			case "2":
				return "이";
			case "3":
				return "삼";
			case "4":
				return "사";
			case "5":
				return "오";
			case "6":
				return "육";
			case "7":
				return "칠";
			case "8":
				return "팔";
			case "9":
				return "구";
		} return "";
	}

}
