package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
	/*
	
	프로세스:	시각 - 시각 연산
	
	1. Calendar 변수 2개 만들기 (now, birthday)
	2. Bufferedreader, readLine()으로 태어난 년도 입력받기
	3. set()메소드 이용해 birthday의 YEAR값을 Integer.parseInt(reader.readLine())으로 수정 
	4. get() 메소드 이용해 now의 YEAR값 - birthday의 YEAR값 + 1 = 나이
	5. 출력
	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();

		System.out.print("태어난 년도: ");
		birthday.set(Calendar.YEAR, Integer.parseInt(reader.readLine()));
		
		int age = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR) + 1;
		System.out.printf("나이: %d세\n", age);
	
	}
}
