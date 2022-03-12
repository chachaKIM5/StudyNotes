package com.test.java;

public class Item13 {

	public static void main(String[] args) {
		
		////[SUMMARY] 메소드 선언과 호출 (2022. 3. 12. 오후 10:55:15)
		
		/*
		 {
		 
		 	{ 
		 		변수 선언;
		 		메소드명(변수명); > 메소드 호출
		 		반환된 result 이어서 이용
		 	} //메인 메소드
			
			 
			접근지정자public 정적키워드static 반환자료형 메소드명(인자=매개 변수) {
				메소드 바디 구현
				return result;
			}
		 }
			
		 */
		
		int age = 25;
		String result = checkAge(age);
		System.out.println(result);

	} //main
		
	public static String checkAge(int age) {	
		String result = age >= 19 ? "성인" : "미성년자";
		return result;
		
	}
}


//result값 없는 경우 선언부에 void