package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
	
	/*
	 
	프로세스: 시각 + 시간 연산 
	
	1. Bufferedreader, readLine()로 남자 이름, 여자 이름, 만난날(년, 월, 일) 입력받기
	2. 이름은 String 변수 생성해 대입, parseInt로 만난 날(년, 월, 일)을 int 변수에 대입
	3. Calendar meet 변수 선언하고 현재 시각 불러오기
	4. add() 메소드로 Calendar.DATE에 100일, 200일, 300일, 500일, 1000일 차례로 더하고 출력
	5. 사이사이 set() 메소드로 meet 초기화 필수
	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름: ");
		String maleName = reader.readLine();
		
		System.out.print("여자 이름: ");
		String femaleName = reader.readLine();
		
		System.out.print("만난날(년): ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("만난날(월): ");
		int month = Integer.parseInt(reader.readLine()) - 1;
		
		System.out.print("만난날(일): ");
		int date = Integer.parseInt(reader.readLine());
		
		
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n", maleName, femaleName);
		Calendar meet = Calendar.getInstance();
		
		meet.set(year, month, date);
		meet.add(Calendar.DATE, 100);
		System.out.printf("100일: %tF\n", meet);

		meet.set(year, month, date);
		meet.add(Calendar.DATE, 200);
		System.out.printf("200일: %tF\n", meet);
		
		meet.set(year, month, date);
		meet.add(Calendar.DATE, 300);
		System.out.printf("300일: %tF\n", meet);
		
		meet.set(year, month, date);
		meet.add(Calendar.DATE, 500);
		System.out.printf("500일: %tF\n", meet);
		
		meet.set(year, month, date);
		meet.add(Calendar.DATE, 1000);
		System.out.printf("1000일: %tF\n", meet);
		

	
	
	
	
	}
}
