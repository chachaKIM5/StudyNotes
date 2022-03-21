package com.test.java;

public class Item36 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 조작 기능: 공백 제거 메소드 (2022. 3. 22. 오전 2:53:23)
		
		//String.trim(): 문자열의 시작과 끝에 존재하는 공백 문자를 제거해 String으로 반환한다
		//		- 공백 문자(Whitespace = 스페이스, 탭, 개행)
		//		- 불필요하거나 or 사용자 실수로 생긴 공백 제거에 사용
		
		
		String test = "         안녕하세요?         ";
		System.out.println(test.trim()); //안녕하세요?
	}
}
