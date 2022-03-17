package com.test.java.question.iteration;

public class Q08_while {

	public static void main(String[] args) {
		
	
	int total = 0;
	int year = 2022;
	int month = 3;
	int date = 17;
	
	
	//1년 1월 1일 ~ 2021년 12월 31일
	
	int yearPast = 1;
	
	while (yearPast <= 2021) {
		total += 365;
		
		if (isLeapYear(yearPast))  {
			total++;
		}
		
		yearPast++;
	}
	
	
	//2022년 1월 1일 ~ 2022년 2월 28일
	int monthPast = 1;

	while (monthPast < month) {
		total += getLastDay(year, monthPast);
		monthPast++;
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