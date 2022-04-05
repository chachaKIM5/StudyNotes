package com.test.java.question.FileIO;

import java.io.FileReader;
import java.util.Stack;

public class Q06 {

	public static void main(String[] args) {

		//모든 괄호가 서로 짝이 맞는지 검사하시오.
		//C:\class\java\파일_입출력_문제\괄호.java
		//{ = 123, } = 125
		//( = 40, ) = 41
		
		Stack<Integer> stack = new Stack<Integer>();
		
		try {
			
		FileReader reader = new FileReader("C:\\class\\java\\JavaTest\\src\\com\\test\\java\\question\\FileIO\\testQ06.java");
		int countParenthesis = 0;
		int countBrace = 0;
		int code = -1;
		
		while ((code = reader.read()) != -1) {
			stack.push(code);
		}
		
		reader.close();
		
		
		
		
		int loop = stack.size();
		
		for (int i=0 ; i<loop ; i++) {
			
			if (stack.peek() == 41) {
				stack.pop();
				countParenthesis++;
			} else if (stack.peek() == 40) {
				stack.pop();
				countParenthesis--;
			} else if (stack.peek() == 125) {
				stack.pop();
				countBrace++;
			} else if (stack.peek() == 123) {
				stack.pop();
				countBrace--;
			} else {
				stack.pop();
			}
			
		}

		if (countParenthesis != 0 || countBrace != 0) {
			System.out.println("올바르지 않은 소스입니다.");
		
		} else {
			System.out.println("올바른 소스입니다.");
		}
		
		

		} catch (Exception e) {
			System.out.println("Q06.main");
			e.printStackTrace();
		}

		
	}
}
