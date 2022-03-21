package com.test.java;

public class Item35 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 조작 기능: 문자열 추출 (2022. 3. 22. 오전 2:48:09)
		
		//String.charAt(int index) 메소드: 문자열의 위치를 추출해 char 값으로 반환한다 (0부터 시작하는 Zero-based Index)
		
		String test = "안녕하세요, 김승연입니다.";
		
		System.out.println(test.charAt(0)); //안
		System.out.println(test.charAt(4)); //요
		System.out.println(test.charAt(13)); //.
		//System.out.println(test.charAt(14)); //error
		
		System.out.println(test.charAt(test.length()-1)); //마지막 문자 = .
		
	}
}
