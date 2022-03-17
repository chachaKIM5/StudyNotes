package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_while {

	public static void main(String[] args) throws Exception {
		
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
			while (start <= end) {					
				if (differ <= 0) {
					System.out.println("연산이 불가능합니다.");
					break;
				}			

				System.out.println(start);
				start += differ;
			} 
		
			
		//시작 숫자가 종료 숫자보다 클 경우 증감치만큼 감소하는 연산
		//이때 증감치는 양수여야 계산할 수 있다
			
		} else if (start > end) {
			while (start >= end) {
				if (differ >= 0) {
					System.out.println("연산이 불가능합니다.");
					break;
				}
				
				System.out.println(start);
				start += differ;
			} 

		} else {
			System.out.println(start);
		}
	}
}

	
