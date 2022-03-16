package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스 설계
	 1. (1) 시작 숫자>종료 숫자인 경우,
	 	(2) 시작 숫자<종료 숫자인 경우,
	 	(3) 시작 숫자=종료 숫자인 경우로 나눠서 생각
	 2. BufferedReader로 시작 숫자, 종료 숫자, 증감치 입력받기 
	 3. (1)의 경우 start <= end이면 증감치(양수)를 더하는 연산을 반복
	 	이때 증감치가 0이거나 음수이면 무한 루프가 된다. "연산이 불가능합니다" 메시지를 출력하고 break
	 4. (2)의 경우 start >= end이면 증감치(음수)를 더하는 연산을 반복
	 	이때 증감치가 0이거나 양수이면 무한 루프가 된다. "연산이 불가능합니다" 메시지를 출력하고 break
	 5. (3)의 경우 시작 숫자=종료 숫자 1개만 출력하고 프로그램 종료
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		System.out.print("증감치: ");
		int differ = Integer.parseInt(reader.readLine());
		
		
		
		//시작 숫자가 종료 숫자보다 작을 경우 증감치만큼 늘어나는 연산
		//이때 증감치는 양수여야 계산할 수 있다
		if (start < end) {
			for ( ; start <= end ; start += differ) {
				if (differ <= 0) {
					System.out.println("연산이 불가능합니다.");
					break;
				} System.out.println(start);				
			} 
		
			
		//시작 숫자가 종료 숫자보다 클 경우 증감치만큼 감소하는 연산
		//이때 증감치는 양수여야 계산할 수 있다
		} else if (start > end) {
			for ( ; start >= end ; start += differ) {
				if (differ >= 0) {
					System.out.println("연산이 불가능합니다.");
					break;
				}
				System.out.println(start);
			} 

			
		} else {
			System.out.println(start);
		
		}
		
		
	}
}
