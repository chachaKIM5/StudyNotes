package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_while {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		boolean loop = true;
		
		
		while (loop) {
			System.out.printf("%d + ", startNum);
			sum += startNum;
					
				if (startNum == endNum) {
					loop = false;
				} else if (startNum <= endNum) {
					startNum++;
				} else {
					startNum--;
				}
		} System.out.printf("\b\b= %d", sum);
		
		
	}//main
}
