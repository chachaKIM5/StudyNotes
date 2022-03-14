package com.test.java;

import java.util.Calendar;

public class Item19 {

	public static void main(String[] args) {
		
		//[SUMMARY] 형식 문자 이용한 날짜 시간 요일 쉽게 구하기 (2022. 3. 14. 오후 10:59:49)
		
		//Calendar 선언 후 printf(), format()에서 사용 가능
		//%tF, %tT, %tA

		
		Calendar now = Calendar.getInstance();
	
		System.out.printf("%tF\n", now); //2022-03-14	
		
		/*
		길고 복잡한 식을 위처럼 한 줄로 줄일 수 있다! //2022-03-14
		System.out.printf("%d-%02d-%02d\n"
								, now.get(Calendar.YEAR)
								, now.get(Calendar.MONTH) + 1
								, now.get(Calendar.DATE));
		*/
		
		System.out.printf("%tT\n", now); //23:00:40
		System.out.printf("%tA\n", now); //월요일
		
	}
}
