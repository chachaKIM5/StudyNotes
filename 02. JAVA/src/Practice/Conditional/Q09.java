package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	//평년: 2월 28일까지 있는 해
	//윤년: 2월 29일까지 있는 해
	
	//윤달 	> 음력은 한 달을 무조건 30일로 보기 때문에 1년 실제 시간(365일)과 어긋나게 됨
	//	   	> 간헐적으로 같은 달을 2번 반복. 반복되는 달을 말함
	//윤초   > 1초를 추가
	//Calendar 클래스 사용 금지

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. Bufferedreader, Integer.parseInt(reader.readLine())으로 int year 생성 및 입력받기
	 2. 중첩 if문과 % 연산자 사용해 평년, 윤년 판단 후 출력
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년도 입력: ");
		int year = Integer.parseInt(reader.readLine());
		String leap = "윤년";
		String common = "평년";
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.printf("%d년은 '%s'입니다.", year, leap);
				} else {
					System.out.printf("%d년은 '%s'입니다.", year, common);
				}
			} else {
				System.out.printf("%d년은 '%s'입니다.", year, leap);
			}
		} else {
			System.out.printf("%d년은 '%s'입니다.", year, common);
		}
		
	}
}
