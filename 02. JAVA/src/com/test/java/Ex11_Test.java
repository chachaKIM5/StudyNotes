package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Test {

	public static void main(String[] args) throws Exception {
		
		//Ex11_Test.java 220310
		//연산자 수업의 연장 > 일부 테스트
		
		//요구사항] 사용자 키보드 입력 > 문자 1개 > 영어 소문자인지 검사
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영소문자 입력: ");
		String input = reader.readLine();
		
		System.out.println("입력된 문자: " + input);
		
		//String -> char -> int
		char c = input.charAt(0); //"a" -> 'a'
		
		int code = (int)c;
		
		System.out.println(code);
		System.out.println();
		
		//영어 소문자인지 검사 a(97) ~ z(122)
		System.out.println(code >= 97);
		System.out.println(code <= 122);
		System.out.println(code >= 97 && code <= 122);
		
		System.out.println(code >= (int)'a');
		System.out.println(code <= (int)'z');
		
		//char 자료형은 우위 비교가 가능하다 > 내부적으로 숫자로 취급하기 때문에
		//String 자료형은 우위 비교가 불가능함을 주의할 것
		System.out.println(c >= 'a');
		System.out.println(c <= 'z');
		
		
		System.out.println((int)'a');
		System.out.println((int)'z');
	}
}
