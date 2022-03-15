package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10 {

	//월~토를 입력하면 평일입니다.
	//일요일은 공휴일입니다.
	
	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. Calender input 변수 생성 
	 2. BufferedReader, Integer.parseInt(reader.readLine()), set() 이용해 input에 년, 월, 일 값 넣어주기
	 3. 입력된 날짜의 요일(숫자)을 구하고, 평일을 입력했을 경우 토요일(7)과 차이 구하기
	 								휴일을 입력했을 경우 "결과가 없습니다"로 종료
	 4. 3에서 구한 차이만큼 input의 날짜를 더해주고 결과 출력.
	  	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년: ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("월: ");
		int month = Integer.parseInt(reader.readLine()) - 1;

		System.out.print("일: ");
		int date = Integer.parseInt(reader.readLine());
		
		Calendar input = Calendar.getInstance();
		input.set(year, month, date);
		
		String weekday = "평일";
		String weekend = "휴일";
		int dayNum = input.get(Calendar.DAY_OF_WEEK);
		int toSat = 7 - dayNum; //입력한 날짜의 요일은 토요일까지 며칠이 남았나를 나타내는 변수
		
		if (dayNum > 1) {
			input.add(Calendar.DATE, toSat);
			System.out.printf("입력하신 날짜는 '%s'입니다.\n", weekday);
			System.out.printf("해당 주의 토요일로 이동합니다.\n");
			System.out.printf("이동한 날짜는 '%tF' 입니다.", input);
		} else {
			System.out.printf("입력하신 날짜는 '%s'입니다.\n", weekend);
			System.out.printf("결과가 없습니다.");
		}
		
		
	} // main
	
}
