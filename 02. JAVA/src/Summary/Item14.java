package com.test.java;

public class Item14 {

	public static void main(String[] args) {
		
		//[SUMMARY] String.format 메소드 (2022. 3. 14. 오후 10:29:13)
		
		/*
		  
		 String.format 메소드
		 printf 메소드와 기능은 동일하지만, 결과를 출력(X) 반환(O)해 사용하고 싶을 경우
		 
		 */
		
		System.out.println(test());
		
	} //main
	
	public static String test() {
	
		String result = String.format("%.1f", 10.0 / 3);

		return result;
	}
}
