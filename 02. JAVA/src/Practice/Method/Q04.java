package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
	/*
	
	프로세스
	 1. String 값이 반환되는 메소드 5개 선언
		(메소드명 add, subtract, multiply, divide, mod)
		(매개변수 int n1, int n2)
	 2. result에 n1, n2 이용해 각 계산(+, -, *, /, %) 결과 대입되도록 코딩
	 3. 메인 메소드에 라벨 작성하기
	 4. Bufferedreader, reader.readLine()이용 사용자에게 숫자 2개(int n1, int n2) 입력받고
	 	String -> int로 바꾸기
	 5. 메소드 호출 및 println으로 결과 출력
	 6. 나누기 메소드 결과값을 어떻게 1.7로 표시할 수 있을지 모르겠다...!
	  	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫 번째 숫자: ");
		String s1 = reader.readLine();
		int n1 = Integer.parseInt(s1);

		System.out.print("두 번째 숫자: ");
		String s2 = reader.readLine();
		int n2 = Integer.parseInt(s2);
		
		String result = add(n1, n2);
		System.out.println(result);

		result = subtract(n1, n2);
		System.out.println(result);
		
		result = multiply(n1, n2);
		System.out.println(result);

		result = divide(n1, n2);
		System.out.println(result);
		
		result = mod(n1, n2);
		System.out.println(result);
		
	} //main
	
	public static String add(int n1, int n2) {
		
		String result = String.valueOf(n1) + " + " +
						String.valueOf(n2) + " = " + (n1 + n2);
		
		return result;
		
	}
	
	public static String subtract(int n1, int n2) {
		
		String result = String.valueOf(n1) + " - " +
						String.valueOf(n2) + " = " + (n1 - n2);
		
		return result;
		
	}
	
	public static String multiply(int n1, int n2) {
		
		String result = String.valueOf(n1) + " * " +
						String.valueOf(n2) + " = " + (n1 * n2);
		
		return result;
		
	}
	
	public static String divide(int n1, int n2) {
		
		String result = String.valueOf(n1) + " / " +
						String.valueOf(n2) + " = " + ((double)n1 / (double)n2);
		
		return result;
		
	}
	
	public static String mod(int n1, int n2) {
		
		String result = String.valueOf(n1) + " % " +
						String.valueOf(n2) + " = " + (n1 % n2);
		
		return result;
		
	}
		
}
