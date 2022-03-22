package com.test.java;

import java.util.Arrays;

public class Item41 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 분리 (2022. 3. 22. 오후 5:23:05)
		
		
		//1
		//String[] split(delimiter)
		//문자열을 delimiter를 기준으로 분리해 String 배열로 반환
		//(***** 구분자는 없어진다 *****)
		
		String email = "sy1038263@gmail.com";
		System.out.println(Arrays.toString(email.split("@")));
		//[sy1038263, gmail.com]

				
		
		//2
		//char[] toCharArray()
		//문자열을 한 글자씩 분리해 char 배열로 반환
		
		String kor = "가나다라마바사아자차카타파하";
		System.out.println(Arrays.toString(kor.toCharArray()));
		//[가, 나, 다, 라, 마, 바, 사, 아, 자, 차, 카, 타, 파, 하]
		
	}
}
