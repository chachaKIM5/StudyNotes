package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스 설계
	 1. Math.random 이용해 숫자 1개 정하기
	 2. for문, if문 이용해 입력하는 숫자가 맞았는지, 틀렸는지 출력, 틀리면 루프 변수 +1
	 3. 맞으면 결과 출력 + "프로그램을 종료합니다", 10번 틀리면 그냥 "프로그램을 종료합니다."
	 	  	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int random = (int)(Math.random() * 10 + 1);
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.");
		
		int inputNum;
		
		for (int i=1 ; i<=10 ; i++) {
			System.out.print("숫자: ");
			inputNum = Integer.parseInt(reader.readLine());
			
			if (inputNum != random) {
				System.out.println("틀렸습니다.");
				
			} else {
				System.out.println("맞았습니다.");
				System.out.println();
				System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", random); 
				System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n", i); 
				break;
			}			
		} System.out.printf("\n프로그램을 종료합니다.");
		
	} //main
}
