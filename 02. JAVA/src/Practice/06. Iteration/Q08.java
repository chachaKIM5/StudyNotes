package com.test.java.question.iteration;

public class Q08 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스 설계
	 1. 메소드 2개로 표현
	  1) 1년+...+2021년, ~오늘 며칠이었는지 구하기 getDay();
	  	 1년~2021년 윤년, 평년 계산해 더하는 데 for문 사용
	  2) 3월 1일은 화요일, if문 이용해서 3월의 요일 구하는 메소드 getDayOfWeek();
	 2. 출력
	  	
	 */
		
		
		int sumYear = getDay(16);
		//오늘이 3월의 며칠째인지 입력하면 1년 1월 1일~오늘의 합을 구해주는 메소드
		String dayOfWeek = getDayOfWeek(16);
		//오늘이 3월의 며칠째인지 입력하면 요일을 구해주는 메소드

		
		System.out.printf("2022년 3월 16일은 %,d일째 되는 날이고 수요일입니다.\n"
							, sumYear
							, dayOfWeek);
		
	} //main
	
	public static int getDay(int sum) {
		
		for (int year=1 ; year<=2021 ; year++) {
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 400 == 0) {
						sum += 366;
					} else {
						sum += 365;
					}
				} else {
					sum += 366;
				}
			} else {
				sum += 365;
			}
		}
			
		final int dayJan = 31;
		final int dayFeb = 28;
		
		return sum + dayJan + dayFeb; 
		
	}

	public static String getDayOfWeek(int date) {
		
		if (date % 7 == 1) {
			return "화";
		} else if (date % 7 == 2) {
			return "수";
		} else if (date % 7 == 3) {
			return "목";
		} else if (date % 7 == 4) {
			return "금";
		} else if (date % 7 == 5) {
			return "토";
		} else if (date % 7 == 6) {
			return "일";
		} else if (date % 7 == 0) {
			return "월";
		}
			
			return "";
	
	}
}