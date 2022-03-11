package com.test.java.question.method;

public class Q03 {

	public static void main(String[] args) {

		
	/*
	 
	 프로세스
	 1. 결과를 출력하는 메소드 선언
	 2. 조건 연산자 이용
	 	4자리(1000) 이상이면 그대로 출력,
	  	4자리보다 작은 3자리 수일 때 "0" + 문자열로 바꾼 숫자 출력
	  	3자리보다 작은 2자리 수일 때 "00" + 문자열로 바꾼 숫자 출력
	  	2자리보다 작은 1자리 수일 때 "000" + 문자열로 바꾼 숫자 출력
	  	나머지 음수인 경우 "음수" 메시지 출력
	 3. snum = num을 문자열로 바꾸기
	 4. printf로 "입력받은 숫자 -> 결과값" 출력되도록 코딩 > 호출부 입력하고 실행
	  	
	  
	  
	 */
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
		
	}//main
	
	public static void digit(int num) {
		
		String snum = String.valueOf(num);
		String result = (num >= 1000 ? snum
						: num >= 100 ? "0" + snum
						: num >= 10 ? "00" + snum
						: num >= 0 ? "000" + snum : "음수");
				
		System.out.printf("%d -> %s\n", num, result);
		
	}
	
	
	
}
