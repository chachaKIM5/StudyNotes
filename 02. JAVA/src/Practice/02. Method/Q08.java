package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
	
	/*
	 
	 프로세스
	 1. int값 반환하는 메소드 1개 선언 (메소드명 getApple, 매개 변수 int sunny, int foggy)
	 2. 5cm x 맑은 날 수 + 2cm x 흐린 날 수 >= 100cm가 참인지 판별하는 조건 연산자
	 3. 참일 경우 (사과 나무 길이 - 100)을 10으로 나눈 결과값, 거짓이면 0을 result로 대입
	 4. 메인 메소드에 Bufferedreader, readLine()으로 맑은 날, 흐린 날 며칠인지 입력받기
	 5. 메소드 호출 > result 값 넣어 "사과가 총 %d개 열렸습니다" 출력!
	  
	 */
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("맑은 날: ");
	int sunny = Integer.parseInt(reader.readLine());

	System.out.print("흐린 날: ");
	int foggy = Integer.parseInt(reader.readLine());
	
	int result = getApple(sunny, foggy);
	System.out.printf("사과가 총 %d개 열렸습니다.\n", result);
		
	
	} //main
	
	
	public static int getApple(int sunny, int foggy) {
		
		int height = (sunny * 5) + (foggy * 2);
		int result = height >= 100 ?
					 (height - 100) / 10 : 0;
		
		return result;
		
	}
}
