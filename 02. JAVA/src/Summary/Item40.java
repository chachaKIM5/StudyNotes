package com.test.java;

public class Item40 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 치환 (2022. 3. 22. 오후 5:19:13)
		
		//String.replace(String old, String new)
		//String 문자열 속 모든 old를 new로 대체한다
		
		String name = "홍길동입니다. 홍길동이라고 불러주세요.";
		System.out.println(name.replace("홍길동", "김승연"));
		//김승연입니다. 김승연이라고 불러주세요.

	}
}
