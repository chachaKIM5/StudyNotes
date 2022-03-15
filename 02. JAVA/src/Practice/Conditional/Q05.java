package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
	/*
	
	프로세스
	1. BufferedReader로 숫자 2개, 연산자 1개 입력받기
	2. int input1, input2, String oper 변수 선언 및 Integer.parseInt 이용 입력받은 값 대입
	3. 중첩 if문으로 유효성 검사(산술 연산자 5가지) 및 조건에 따라 출력
			 
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자: ");
		int input1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int input2 = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자: ");
		String oper = reader.readLine();
		
		
		if (oper.equals("+") || oper.equals("-") ||
			oper.equals("*") || oper.equals("/") || oper.equals("%")) {
			
			if (oper.equals("+")) {
				System.out.printf("%d + %d = %d", input1, input2, input1 + input2);

			} else if (oper.equals("-")) {
				System.out.printf("%d - %d = %d", input1, input2, input1 - input2);

			} else if (oper.equals("*")) {
				System.out.printf("%d * %d = %d", input1, input2, input1 * input2);
				
			} else if (oper.equals("/")) {
				System.out.printf("%d / %d = %.1f", input1, input2, (double)input1 / input2);
				
			} else {
				System.out.printf("%d %% %d = %d", input1, input2, input1 % input2);

			}

		} else {
			System.out.println("연산이 불가능합니다.");
		}
				
	} //main
}

