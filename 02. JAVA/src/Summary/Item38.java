package com.test.java;

public class Item38 {

	public static void main(String[] args) {

		//[SUMMARY] 문자열 조작 기능: 문자열 대소문자 변경 (2022. 3. 22. 오전 3:03:18)
		
		//String.toUpperCase()
		//String.toLowerCase()
		//문자열의 모든 문자를 대/소문자로 바꿔 String 문자열로 반환하는 메소드
		
		String content = "오늘 수업하는 과목은 JAVA입니다.";
		String word = "Java";
		
		System.out.println(content.toLowerCase());
		System.out.println(word.toUpperCase());
		
	}
}
