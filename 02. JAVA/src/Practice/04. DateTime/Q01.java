package com.test.java.question.datetime;

import java.util.Calendar;

public class Q01 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스
	 1. 반환 데이터와 매개 변수 없는 메소드 1개 선언 (메소드명: nowTime)
	 2. Calendar now 선언한 변수에 현재 시각 불러오기 
	 3. printf(), get() 사용
	 	24시간제(Calendar.HOUR_OF_DAY), 12시간제(Calendar.HOUR) 1번씩 출력
	 4. 메소드 호출
	 
	 */
		
		
	nowTime();
	
	} //main

	
	private static void nowTime() {
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("현재 시간: %d시 %d분 %d초\n"
								, now.get(Calendar.HOUR_OF_DAY)
								, now.get(Calendar.MINUTE)
								, now.get(Calendar.SECOND));
		
		System.out.printf("현재 시간: %s %d시 %d분 %d초\n"
								, now.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
								, now.get(Calendar.HOUR)
								, now.get(Calendar.MINUTE)
								, now.get(Calendar.SECOND));
	
	}
	
}
