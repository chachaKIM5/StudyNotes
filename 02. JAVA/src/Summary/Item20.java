package com.test.java;

import java.util.Calendar;

public class Item20 {

	public static void main(String[] args) {
		

	//[SUMMARY] 시각 +- 시간 연산 (2022. 3. 15. 오후 9:56:30)
	
	//add() 메소드 이용해 시각에 쉽게 시간 더하기
	
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%tF, %tT, %tA\n", now, now, now);	
		
		now.add(Calendar.HOUR, 3);
		now.add(Calendar.MINUTE, 30);
		
		System.out.printf("%tF, %tT, %tA", now, now, now);

	}
}