package com.test.java;

public class Item39 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 패턴 검색 (2022. 3. 22. 오후 5:12:36)
		
		//String.startsWith(str)
		//String.endsWith(str)
		//문자열이 입력한 str로 시작하거나 끝나는지 boolean값을 반환한다
	
	
		String str = "안녕하세요? 테스트하고 있습니다.";
		
		System.out.println(str.startsWith("안")); 	//true
		System.out.println(str.startsWith("안녕")); 	//true
		System.out.println(str.startsWith("녕")); 	//false
		
		System.out.println(str.endsWith(".")); 		//true
		
		String fileName = "노래.mp3";

		if (fileName.endsWith("mp3")) {
			System.out.println("노래 파일입니다.");
		} else {
			System.out.println("노래 파일이 아닙니다.");
		}
		
	}

}
