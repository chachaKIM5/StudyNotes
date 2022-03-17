package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_while {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("이름: ");
		String name = reader.readLine();
		
		System.out.print("횟수: ");
		int loop = Integer.parseInt(reader.readLine());
		
		int n = 1;
		while (n <= loop) {
			System.out.printf("%s님 안녕하세요~\n", name);
			n++;
		}
	}
}
