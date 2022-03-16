package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
	
	/*
	 
	 프로세스
	 1. String 값이 반환되는 메소드 선언 (메소드명 getNumber, 매개변수 int n)
	 2. 메소드 바디 > result에 입력된 n을 판별해 "짝수", "홀수" 대입되도록 코딩
	 3. 메인 메소드에 라벨 작성하기
	 4. Bufferedreader, reader.readLine() 이용 사용자에게 숫자 하나 입력받기
	 5. 메소드 호출 > 실행
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		int n = Integer.parseInt(reader.readLine());
		
		String result = getNumber(n);
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);

	} //main
	
	public static String getNumber(int n) {
		
		String result = n % 2 == 0 ? "짝수" : "홀수";
		
		return result;
		
	}
	
}
