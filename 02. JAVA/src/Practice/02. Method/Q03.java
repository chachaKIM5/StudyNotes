package com.test.java.question.method;

public class Q03 {

	public static void main(String[] args) {

		
	/*
	 
	 프로세스
	 1. return값 없이 바로 결과를 출력하는 메소드 선언
	 2. 형식 문자 확장 기능 이용해 4자리 숫자까지 0을 붙여 표시하기
	 4. printf로 "입력받은 숫자 -> 결과값" 출력되도록 코딩 > 호출부 입력하고 실행 확인
	  	
	  
	 */
		
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
		
	}//main
	
	public static void digit(int num) {
		
		//수정 후
				
		System.out.printf("%d -> %04d\n", num, num);
		
	}	
}

/*
 - 수정 전
String snum = String.valueOf(num);
String result = (num >= 1000 ? snum
				: num >= 100 ? "0" + snum
				: num >= 10 ? "00" + snum
				: num >= 0 ? "000" + snum : "음수");
		
System.out.printf("%d -> %s\n", num, result);
*/
