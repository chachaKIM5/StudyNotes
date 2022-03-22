package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
	
	//substring 혹은 charAt으로 추출해 역출력

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력: ");
		String input = reader.readLine();
		
		String[] array = new String[input.length()];
		String output = "";
		
		for (int i=0 ; i<input.length() ; i++) {
			array[i] = input.substring(i, i+1);
		}
		
		for (int i=(array.length)-1 ; i>=0 ; i--) {
			output += array[i];
		}
		
		System.out.printf("역순 결과: \"%s\"", output);
	
	}
}
