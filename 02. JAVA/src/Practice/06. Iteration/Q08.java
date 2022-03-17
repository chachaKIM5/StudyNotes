package com.test.java.question.iteration;

public class Q08 {

	public static void main(String[] args) {
		
	/*
	 
	 프로세스 설계
	 1. 며칠?: 메소드 2개로 표현
	  1) 1년+...+2021년, ~오늘 며칠이었는지 구하기 (윤년 +1 해주는 메소드 포함)
	  2) 각 월의 마지막 날을 구하는 메소드 -> 1, 2월 합
	 2. 1번 + 오늘 date = 날짜 완성
	 3. 요일: 1년 1월 1일은 월요일 -> 요일 구하는 메소드 getDayOfWeek();
	 4. 출력
	  	
	 */
		
		int total = 0;
		int year = 2022;
		int month = 3;
		int date = 17;
		
		
		//1년 1월 1일 ~ 2021년 12월 31일
		
		for (int i=1 ; i<=2021 ; i++) {
			total += 365;
			
			if (isLeapYear(i)) {
				total++;
			}
		}
		
		//2022년 1월 1일 ~ 2022년 2월 28일
		
		for (int i=1 ; i<month ; i++) {
			
			total += getLastDay(year, i);
		}

		//~ 2022년 3월 17일
		
		total += date;
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s입니다.\n"
							, year, month, date
							, total
							, getDayOfWeek(total));
		
	} //main
	
	
	private static int getLastDay(int year, int month) {
		
		switch (month) {
			case 1: case 3: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				return isLeapYear(year) ? 29: 28;
		}
		
		return 0;
	}
	
	
	public static boolean isLeapYear(int year) {
		
		if (year % 4 == 0) {
	
			if (year % 100 == 0) {
				
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
				
			} else {
				return true;
			}
				
		} else {
			return false;
		}
	}


	public static String getDayOfWeek(int total) {
		
		if (total % 7 == 1) {
			return "월요일";
		} else if (total % 7 == 2) {
			return "화요일";
		} else if (total % 7 == 3) {
			return "수요일";
		} else if (total % 7 == 4) {
			return "목요일";
		} else if (total % 7 == 5) {
			return "금요일";
		} else if (total % 7 == 6) {
			return "토요일";
		} else if (total % 7 == 0) {
			return "일요일";
		}
			return "";
	}
}