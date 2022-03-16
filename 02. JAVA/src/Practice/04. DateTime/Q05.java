package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;


public class Q05 {

	public static void main(String[] args) throws Exception {
		
	/*
	
	프로세스: 시각 - 시각
	1. 변수 Calendar birthDad, birthDaughter 선언, 현재 시각 불러오기
	2. Bufferedreader, reader.readLine() 아빠 생일(년, 월, 일)과 딸 생일(년, 월, 일) 입력받고
	3. set(), Integer.parseInt 이용해 변수에 대입
	4. tickDad, tickDaughter 생성해 getTimeInMillis() 연산하고 /1000 /60 /60 /24
	5. printf 결과 출력

	 */
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Calendar birthDad = Calendar.getInstance();
	Calendar birthDaughter = Calendar.getInstance();
	
	System.out.print("아빠 생일(년): ");
	birthDad.set(Calendar.YEAR, Integer.parseInt(reader.readLine()));	
	
	System.out.print("아빠 생일(월): ");
	birthDad.set(Calendar.MONTH, Integer.parseInt(reader.readLine()) - 1);	
	
	System.out.print("아빠 생일(일): ");
	birthDad.set(Calendar.DATE, Integer.parseInt(reader.readLine()));	

	System.out.print("딸 생일(년): ");
	birthDaughter.set(Calendar.YEAR, Integer.parseInt(reader.readLine()));	
	
	System.out.print("딸 생일(월): ");
	birthDaughter.set(Calendar.MONTH, Integer.parseInt(reader.readLine()) - 1);	

	System.out.print("딸 생일(일): ");
	birthDaughter.set(Calendar.DATE, Integer.parseInt(reader.readLine()));
	
	
	System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다."
						, (birthDaughter.getTimeInMillis()
						  - birthDad.getTimeInMillis()) / 1000 / 60 / 60 / 24);

	}
}