package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_while {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int random = (int)(Math.random() * 10 + 1);
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.");
		
		int inputNum;
		int userTry = 0;
		
		while (userTry <= 9) {
			System.out.print("숫자: ");
			inputNum = Integer.parseInt(reader.readLine());
			userTry++;
			
			if (inputNum != random) {
				System.out.println("틀렸습니다.");

			} else {
				System.out.println("맞았습니다.");
				System.out.println();
				System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", random);
				System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n", userTry);
				break;
			}
	
		} System.out.println("\n프로그램을 종료합니다.");

	}//main
}
