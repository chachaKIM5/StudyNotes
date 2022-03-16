package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
	/*
	 프로세스 설계
	 1. int sum = 0; (누적 변수) 선언 및 초기화, BufferedReader, parseInt로 숫자 1개 입력받기
	 2. for문) 루프 변수 i <= 입력받은 숫자면 1씩 증가시키면서 반복
	 		   누적 변수에 i 값을 누적시키며 더한다
	 3. 반복이 끝나면 형식대로 출력
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		
		System.out.print("숫자: ");
		int inputNum = Integer.parseInt(reader.readLine());
		
		for (int i=1 ; i <= inputNum ; i++) {
			sum += i;
		}
		
		System.out.printf("1 ~ %d = %d", inputNum, sum);
	}
}
