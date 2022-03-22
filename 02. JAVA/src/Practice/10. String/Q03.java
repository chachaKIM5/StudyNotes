package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
		// 각 자릿수의 합.
		// charAt, substring 등 추출 혹은 문자열함수 안 쓰고도 가능(math.Pow)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		String num = reader.readLine();
		
		
		String[] output = new String[num.length()];
		int sum = 0;
		
		
		System.out.print("결과: ");
		
		for (int i=0 ; i<output.length ; i++) {
			
			output[i] = num.substring(i, i+1);
			sum += Integer.parseInt(output[i]);
			System.out.print(output[i] + " + ");
			
		} System.out.printf("\b\b= %d", sum);

		
	}
}
