package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어: ");
		String inputWord = reader.readLine();
		String[] array = new String[inputWord.length()];
		
		
		
		for (int i=0 ; i<inputWord.length() ; i++) {
			array[i] = inputWord.substring(i, i+1);
		}


		
		for (int i=0 ; i<array.length ; i++) {
			if (array[i].charAt(0) >= 65 && array[i].charAt(0) <= 90) {
				array[i] = " " + array[i];
			}
		}

	
		//결과 출력
		System.out.print("결과:");
		
		for (int i=0 ; i<array.length ; i++) {
			System.out.print(array[i]);
			
		}
		
	}
}
