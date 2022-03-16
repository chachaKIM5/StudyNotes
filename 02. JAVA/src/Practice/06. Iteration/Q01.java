package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
	/*
	
	프로세스 설계
	1. 사용자에게 BufferedReader로 이름, 횟수 입력받기
	2. 이름은 String 변수, 횟수는 int 변수에 대입
	3. for문으로 초기식 <= 입력받은 횟수가 될 때까지 1씩 증가하며 반복해 출력
	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름: ");
		String name = reader.readLine();
		System.out.print("횟수: ");
		int loop = Integer.parseInt(reader.readLine());
		
		for (int i=1 ; i<=loop ; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}
		
	}
}