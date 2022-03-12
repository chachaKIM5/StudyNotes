package com.test.java;

public class Item12 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 연산자 (2022. 3. 12. 오후 10:45:55)
		

		/*
		 - + (2항)
		 - 결과로 두 문자열을 합친 문자열을 반환
	     - 문자열 + 문자열 = 문자열
	  	   문자열 + 비문자열 = 문자열
	       비문자열 + 문자열 = 문자열
	       
	       
	     - ==, != (사용 불가)
	     - "홍길동"과 "홍" + "길동"을 다르다고 인식하기 때문에 사용 불가
	     - 문자열의 비교를 위해서는 아래 메소드를 사용
	     
	     */
	     
		 String txt1 = "홍길동";
		 String txt2 = "홍" + "길동";
	     System.out.println(txt1.equals(txt2)); //true
		
	}
}
