package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_Input {

	public static void main(String[] args) throws Exception {
		
		//Ex10_input.java
		//콘솔 입력, 유틸 클래스, 문자열과 값형의 변환
		
		//요구사항] 숫자 2개를 입력받아 두 숫자의 합을 구하시오.
		
		//import 단축키 Ctrl + Shift + O: 현재 페이지에 모든 클래스를 import (한꺼번에)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("첫 번째 숫자를 입력하세요.: ");
		String input1 = reader.readLine();
		
		System.out.print("두 번째 숫자를 입력하세요.: ");
		String input2 = reader.readLine();
		
		System.out.println(input1 + input2); //"1020"
		//"10" + "20" = "1020" BufferedReader가 돌려주는 데이터는 무조건 문자열이라 문제
		//"10" -> 10, "20" -> 20
		//String(참조형) -> int(값형)
		//형변환 불가능 -> 하지만 해당 작업은 가능 (자바가 따로 구현해 놓음)
		
		
		//유틸 클래스 (byte.MAX_VALUE처럼)
		//- 문자열을 자신의 자료형으로 바꿔주는 일 제공
		
		//문자열 -> 값형으로 바꾸는 법 ***** 형변환은 아님
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		System.out.printf("%d + %d = %d\n"
							, num1
							, num2
							, num1 + num2);
		
		//문자열을 자신의 자료형으로 바꿔주는 일 제공
		
		//Byte.parseByte("10")
		//Short.parseShort("10")
		//Integer.parseInt("10")
		//Long.parseLong("10")
		
		//Float.parseFloat("3.14")
		//Double.parseDouble("3.14")

		//Boolean.parseBoolean("true")
		
		//String을 char로 바꾸기
		//"A" -> 'A'
		//"A".charAt(0)
		
		
		
		//자신의 자료형을 문자열로 바꿔주는 일
		//100 -> "100"
		//String.valueOf(100) -> "100"
		//String.valueOf(3.14) -> "3.14"
		//String.valueOf(true) -> "true"
		
	}
}
