package com.test.java;

import java.util.Calendar;

public class Item18 {

	public static void main(String[] args) {
		
		//[SUMMARY] 날짜 시간 자료형 (Calendar) (2022. 3. 14. 오후 10:54:18)

		//2. Calendar 클래스
		
		Calendar now = Calendar.getInstance();
		
		System.out.println(now.get(Calendar.YEAR));			//년도
		System.out.println(now.get(Calendar.MONTH));		//월 1월(0)~12월(11)
		System.out.println(now.get(Calendar.DATE));			//일
		System.out.println(now.get(Calendar.HOUR));			//시(12H 체계)
		System.out.println(now.get(Calendar.MINUTE));		//분
		System.out.println(now.get(Calendar.SECOND));		//초
		System.out.println(now.get(Calendar.MILLISECOND));	//밀리초 (1/1000)
	
		System.out.println(now.get(Calendar.AM_PM));		//오전(0), 오후(1)
		
		System.out.println(now.get(Calendar.DAY_OF_YEAR));	//일(오늘은 2022년의 73번째 날)
		System.out.println(now.get(Calendar.DAY_OF_MONTH));	//일(=DATE)
		System.out.println(now.get(Calendar.DAY_OF_WEEK));	//요일 일(1)~토(7)
		
		System.out.println(now.get(Calendar.WEEK_OF_YEAR));	//12 주
		System.out.println(now.get(Calendar.WEEK_OF_MONTH));//주 "목요일이 포함되면 첫째주!"
		
		System.out.println(now.get(Calendar.HOUR_OF_DAY));	//시(24H 체계)
	
	
	}
}
