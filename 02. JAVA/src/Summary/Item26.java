package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Item26 {

	public static void main(String[] args) throws Exception {
	
		//[SUMMARY] for문, 반복문 (2022. 3. 16. 오후 11:13:58)
		
		/*
		 
		 for 반복문의 기본 형태
		 
		 for (초기식 ; 조건식 ; 증감식) {
			실행문;
		 }
		 
		 
		 무한 루프
		 (1) 초기식, 조건식, 증감식에 아무것도 안 넣었을 경우	
		 	 : System.out.println("무한 루프");처럼 단순한 것을 무한히 실행한다
		 (2) 조건식에 아무것도 안 넣었을 경우 or true를 입력했을 경우
		 	 : System.out.println(i);처럼 루프 변수를 사용하면서도 무한히 실행한다
		 
		 */
		

		//예시] 사용자에게 입력받은 숫자 10개의 합을 구한다
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		int sum = 0;
		for (int i=0; i<=10; i++) {
			System.out.print("숫자를 입력하세요: ");
			int num = Integer.parseInt(reader.readLine());
			sum += num;
		}
				
		System.out.println(sum);
		
	}
}
