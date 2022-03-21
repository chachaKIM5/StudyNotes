package com.test.java;

public class Item37 {

	public static void main(String[] args) {
	
		//[SUMMARY] 문자열 조작 기능: 문자열 검색 (2022. 3. 22. 오전 2:55:21)

		//String.indexOf(char c)
		//String.indexOf(String s)
		//String.indexOf(char c, int beginIndex)
		//String.indexOf(String s, int beginIndex)
		// : 문자열 내에서 원하는 문자(열)을 검색한 후 발견한 위치(index)를 int로 반환
		
		
		String test = "안녕하세요, 김승연입니다. 안녕하세요.";
		
		int index = -1; //오류를 대비해 변수는 나올 수 없는 값으로 초기화하자
		
		index = test.indexOf('하');
		System.out.println(index); //2
		
		index = test.indexOf("하세요");
		System.out.println(index); //2
		
		index = test.indexOf("안녕"); 
		System.out.println(index); //0
		
		index = test.indexOf("안녕", index + "안녕".length()); //첫 번째 "안녕" 다음 위치부터 찾은 "안녕"
		System.out.println(index); //15
	}
}
