package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_while {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		

		int sum = 0;
		int sign = 1;
		
		if (startNum <= endNum) {
			while (startNum <= endNum) {
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
				} else if (sign > 0) {
					System.out.printf("%d - ", startNum);
				} else if (sign < 0) {
					System.out.printf("%d + ", startNum);
				}
				sum += sign * startNum;
				sign *= (-1);
				startNum++;
			}
			
		} else {
			while (startNum >= endNum) {
				
				if (startNum == endNum) {
					System.out.printf("%d = ", startNum);
				} else if (sign > 0) {
					System.out.printf("%d - ", startNum);
				} else if (sign < 0) {
					System.out.printf("%d + ", startNum);
				}
				sum += sign * startNum;
				sign *= (-1);
				startNum--;
			}
				
		} System.out.print(sum);
	}
}
