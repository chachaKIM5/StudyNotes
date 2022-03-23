package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12 {

	public static void main(String[] args) throws Exception {
		
		//계산기!
		//산술 연산자, 피연산자 2개 존재 여부 확인 어떻게 해야할지 모르겠다..! 어떻게 해도 오류가 남 ㅠㅠ

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		String input = reader.readLine();
		input = input.replace(" ", "");
		
		String operator = "";
		String[] operList = { "+", "-", "*", "/", "%" };
				
		String[] operand = new String[2];
				
		
		
		
		//split 메소드로 operand[피연산자, 피연산자] 배열을 만든다
		//사라진 split의 구분 문자 = 연산자는 String operator에 따로 추가
		for (int i=0 ; i<operList.length ; i++) {
		
				if (input.contains(operList[i])) {
				
					operand = input.split("\\" + operList[i]);
					operator = operList[i];
					
				} 
		}
			
		
		//출력: String 연산자와 String 피연산자를 입력하면 결과를 반환해주는 메소드 만들기 
		System.out.printf("%s %s %s = %d"
							, operand[0]
							, operator
							, operand[1]
							, getResult(operator, operand[0], operand[1]));	
		
		
			
			
	}//main		
	
	public static int getResult(String operator, String operand1, String operand2) {
		
		int operInt1 = Integer.parseInt(operand1);
		int operInt2 = Integer.parseInt(operand2);
		
		switch (operator) {
			case "+" :
				return (operInt1 + operInt2);
			case "-" :
				return (operInt1 - operInt2);
			case "*" :
				return (operInt1 * operInt2);
			case "/" :
				return (operInt1 / operInt2);
			case "%" :
				return (operInt1 % operInt2);
		}
		
		return 0;
		
	}
}
