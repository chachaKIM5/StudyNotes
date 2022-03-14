package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex19_DatetTime {

	public static void main(String[] args) {
		
		//Ex19_DateTime.java
		
		/*
		 
		 자바의 자료형
		 1. 원시형(값형)
		 	- byte, short, int, long
		 	- float, double
		 	- char
		 	- boolean
		 	
		 2. 참조형
		 	- 클래스
		 	- String
		 	- 무제한
		 
		 
		 
		 자바의 날짜시간 자료형
		 1. Date 클래스 > 거의 사용 X
		 2. Calendar 클래스
		 3. 추가 클래스
		 
		 
		 A. 시각
		 B. 시간
		 
		 2022년 3월 14일 오후 4시 22분 27초: 시각
		 8시간 수업: 시간
		 > 둘은 완전히 다른 자료형
		 
		 특정 기준일(1970년 1월 1일 0시 0분 0초, 1년 1월 1일 자정)로부터 해당 시각이 얼마큼 흘렀는지 구한 누적 시간
		 > 틱(tick)값, Epoch Time, Timestamp
		 
		 시각 + 시각 = X, 2022-03-01 + 2025-05-10
		 시각 - 시각 = O(시간), 2025-05-10 - 2022-03-01 > 피연산자와 결과값의 자료형이 다르다
		 
		 시간 + 시간 = O(시간)
		 시간 - 시간 = O(시간)
		 
		 시각 + 시간 = O(시각), 2022-03-01 + 5일 = 2022-03-06
		 시각 - 시간 = O(시각), 2022-03-01 - 3일 = 2022-02-26
		 
		 */
		
		//m1();
		m2();
		
	}//main

	private static void m2() {
		//두번째 예제
		
		//Canlendar 클래스
		//java.util 선택하기
		
		//현재 시각 얻어오기(가장 기본적인 행동) 외우기 > 현재 컴퓨터의 시계의 시각을 얻어온다.
		Calendar c1 = Calendar.getInstance();
		
		//java.util.GregorianCalendar[time=1647245624340,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=2,WEEK_OF_YEAR=12,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=73,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=5,HOUR_OF_DAY=17,MINUTE=13,SECOND=44,MILLISECOND=340,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println(c1);
		
		
		//c1 안에 들어 있는 수많은 데이터 중 원하는 데이터를 추출
		// - int get(int) 메소드 사용
		
		System.out.println(c1.get(1)); //년도 추출 > 2022
		System.out.println(c1.get(2)); //2 
		System.out.println(c1.get(3)); //12
		System.out.println(c1.get(4)); //3 
		System.out.println(c1.get(5)); //14
		
		int year = 1;
		System.out.println(c1.get(1)); 		//가독성 낮음
		System.out.println(c1.get(year)); 	//가독성 높음
		
		//자바가 제공하는 Calendar 상수(변수)
		System.out.println(Calendar.YEAR); 	//1
		System.out.println(c1.get(Calendar.YEAR)); //2022 > 실제로 사용하는 최종 구문
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println(c1.get(Calendar.YEAR)); 			//2022 년도
		System.out.println(c1.get(Calendar.MONTH)); 		//2 월(0~11)
		System.out.println(c1.get(Calendar.DATE));			//14 날짜(일)
		System.out.println(c1.get(Calendar.HOUR));			//5 시(12H 체계)
		System.out.println(c1.get(Calendar.MINUTE));		//23 분
		System.out.println(c1.get(Calendar.SECOND));		//22 초
		System.out.println(c1.get(Calendar.MILLISECOND));	//251 밀리초(1/1000)
		System.out.println(c1.get(Calendar.AM_PM));			//1 오전(0), 오후(1)
		
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));	//73 일(오늘은 2022년의 73번째 날)
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));	//14 일(=DATE)
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));	//2 일(요일) 일(1)~토(7)
		
		System.out.println(c1.get(Calendar.WEEK_OF_YEAR));	//12 주
		System.out.println(c1.get(Calendar.WEEK_OF_MONTH));	//3 주 "목요일이 포함되면 첫째주!"
		
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));	//17 시(24H 체계)
		System.out.println();
		System.out.println();
		System.out.println();
		
		//요구사항] "오늘은 2022년 3월 14일입니다."를 출력하시오.
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("오늘은 %d년 %d월 %d일입니다.\n"
							, now.get(Calendar.YEAR)
							, now.get(Calendar.MONTH) + 1
							, now.get(Calendar.DATE));
		
		
		//요구사항] "지금은 오후 5시 37분입니다."를 출력하시오.
		
		System.out.printf("지금은 %s %d시 %d분입니다.\n"
							, now.get(Calendar.AM_PM) == 0? "오전" : "오후"
							, now.get(Calendar.HOUR)
							, now.get(Calendar.MINUTE));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//printf(), format() > 형식 문자 + 날짜 시간 !!기억할 것!!
		System.out.printf("%tF\n", now); //2022-03-14 **********
		
		System.out.printf("%d-%02d-%02d\n"
								, now.get(Calendar.YEAR)
								, now.get(Calendar.MONTH) + 1
								, now.get(Calendar.DATE));
		
		System.out.printf("%tT\n", now); //17:45:40 **********
		System.out.printf("%tA\n", now); //월요일 > 로컬화된 요일 이름!
	}

	
	private static void m1() {
		//첫번째 예제
	
		//Date
		//java.util 선택하기
		
		//자료형(Date) 변수명(date) = new Date();
		Date date = new Date(); //현재 시각을 생성해서 date라는 변수에 담는다
		
		//Mon Mar 14 17:04:29 KST 2022
		System.out.println(date);
		
	}
	
	
}
