package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스: 시간 - 시간처럼 풀어보기
	 1. BufferedReader로 시각 입력받기
	 2. int delivery = 배달에 걸리는 시간
	 3. 입력받은 시각(분) - 배달에 걸리는 시간(분)이 0보다 큰지 작은지에 따라
	 	시간 출력, 1 내림 출력 / 분 출력, 60분 기준 출력

	 
	 */
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("음식을 받기 원하는 시각");

	System.out.print("시: ");
	int hour = Integer.parseInt(reader.readLine());
	
	System.out.print("분: ");
	int minute = Integer.parseInt(reader.readLine());
	
	int delivery = 10;
	System.out.printf("짜장면: %d시 %d분\n"
						, hour >= 23 ? null //어떻게 처리해야 좋을까?
									   	: minute >= delivery ? hour : (hour - 1)
									   	  //입력받은 "분" > 배달 소요 시간이면 시는 그냥 출력, 아니면 1 내림
									   	
						, minute >= delivery ? (minute - delivery)
									   	: (60 + minute - delivery));
	
	delivery = 18;				
	System.out.printf("치킨: %d시 %d분\n"
						, hour >= 23 ? null
										: minute >= delivery ? hour : (hour - 1)
						, minute >= delivery ? (minute - delivery)
										: (60 + minute - delivery));

	delivery = 25;
	System.out.printf("피자: %d시 %d분\n"
						, hour >= 23 ? null
										: minute >= delivery ? hour : (hour - 1)
						, minute >= delivery ? (minute - delivery)
										: (60 + minute - delivery));
		
	}
}
