package com.test.java.question.datetime;

import java.util.Calendar;

public class Q02 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스: 시각 + 시간 연산
	 
	 1. Calendar now 선언한 변수에 현재 시각 불러오기
	 2. add() 메소드 사용해 Calendar.DATE에 100일 더하고 printf %tF로 백일 출력
	 3. now 변수를 현재 시각으로 다시 초기화
	 4. add() 메소드 사용해 Calendar.YEAR에 1년 더하고 printf %tF로 첫돌 출력
	 
	 */
		Calendar birthday = Calendar.getInstance();
		
		birthday.add(Calendar.DATE, 100);
		System.out.printf("백일: %tF\n", birthday);
		
		birthday = Calendar.getInstance();
		birthday.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF\n", birthday);
		
	}
}
