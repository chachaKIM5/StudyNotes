package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
		//substring 사용해 끝에서부터 3개씩 자르기, 사이에 "," 더하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		String num = reader.readLine();
		String output = "";
		
		
		for (int i=3 ; i<num.length() ; i+=3) {
		output = "," + num.substring(num.length()-i, num.length()-i+3) + output;
		}
		
		
		//여기까지 하니까
		//1234567을 입력하면 ,234,567
		//12345678을 입력하면 ,345,678
		//123456789를 입력하면 ,456,789로 나옴
		
		if (num.length() % 3 == 1) {
			output = num.substring(0, 1) + output;
		} else if (num.length() % 3 == 2) {
			output = num.substring(0, 2) + output;
		} else {
			output = num.substring(0, 3) + output;
		}
		
		System.out.printf("결과: %s", output);
	}
}
