package com.test.java.question.method;

public class Q02 {

	public static void main(String[] args) {
	
		
	/*
	 
	 프로세스
	 1. String 값이 반환되는 메소드 선언
	 	(메소드명 getName, 매개변수 String name)
	 2. result 문자열에 실인자(이름 값) + "님" 대입되도록 메소드 호출
	 3. printf로 "고객: " + result 출력되도록 코딩 > 실행
	 	
	 */
		
		
		String result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);

	} //main
	

	public static String getName(String name) {
		
		String result = name + "님";
		
		return result;

		
	}
}
