package com.test.java;

public class Item35 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 조작 기능: 문자열 추출 (2022. 3. 22. 오전 2:48:09)
		
		
		
		//1
		//String.charAt(int index)
		//	: 문자열의 위치를 추출해 char 값으로 반환한다 (0부터 시작하는 Zero-based Index)
	
		String test = "안녕하세요, 김승연입니다.";
		
		System.out.println(test.charAt(0)); //안
		System.out.println(test.charAt(4)); //요
		System.out.println(test.charAt(13)); //.
		//System.out.println(test.charAt(14)); //error
		
		System.out.println(test.charAt(test.length()-1)); //마지막 문자 = .
		
		
		
		//2
		//String.substring(int beginIndex, (int endIndex))
		//	: 문자열의 위치(beginIndex)를 입력하면 문자열을 추출한다. (endIndex-1까지)
		System.out.println(test.substring(7)); //김승연입니다. endIndex가 없으면 끝까지 반환한다.
		System.out.println(test.substring(7, 10)); //김승연
		
	}
}
