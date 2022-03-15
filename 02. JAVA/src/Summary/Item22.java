package com.test.java;

public class Item22 {

	public static void main(String[] args) {
		
		//[SUMMARY] 시간 + 시간 연산 (2022. 3. 15. 오후 10:07:57)
		
		//3시간 30분에 4시간 50분 더하기
		
		int hour = 3 + 4 + (30 + 50) / 60;
		int minute = (30 + 50) % 60;
		
		System.out.printf("3시간 30분 + 4시간 50분 = %d시간 %d분!", hour, minute);
	}
}
