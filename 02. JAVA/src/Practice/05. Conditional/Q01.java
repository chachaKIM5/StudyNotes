package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. Bufferedreader로 숫자 2개 입력받기
	 2. Integer.pasreInt로 입력받은 숫자 2개를 int input1, input2에 넣기
	 3. 조건문의 조건에 아래와 같이 나누어 실행문 작성
	 	3-1. input1 > input2인 경우
	 	3-2. input1 < input2인 경우
	 	3-3. input1 = input2인 경우
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int input1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int input2 = Integer.parseInt(reader.readLine());
		
		if (input1 > input2) {
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다."
								, input1, input2, input1 - input2);
		} else if (input1 < input2) {
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다."
								, input2, input1, input2 - input1);
		} else if (input1 == input2) {
			System.out.println("두 숫자는 동일합니다.");
		}
	}
	
}
