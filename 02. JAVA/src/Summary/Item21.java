package com.test.java;

import java.util.Calendar;

public class Item21 {

	public static void main(String[] args) {
		
		//[SUMMARY] 시각 - 시각 연산 (2022. 3. 15. 오후 10:02:54)
		
		//tick (=epoch) 값을 이용한 계산
		//내가 살아온 시간(일) 구하기
		
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		
		birthday.set(1996, 4, 6);
		
		System.out.println((now.getTimeInMillis() - birthday.getTimeInMillis()) / 1000 / 60 / 60 / 24);
		
		
		//참고
		//현재 시간의 tick 구하기: 식이 실행되는 동안 흐른 시간도 놓치지 않는 방법
		//PC 사양이 좋을수록 적은 차이를 보인다
		
		System.out.println(now.getTimeInMillis());
		System.out.println(System.currentTimeMillis());

	}
}
