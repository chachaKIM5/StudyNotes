package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. int 값을 반환하는 메소드 선언 (메소드명 getTime,
	 							 매개변수 int station, int change, int time)
	 2. 역의 개수x2, 환승역의 횟수x시간대에 따른 환승 시간(평상시 3, 출근시 4, 퇴근시 5 - 조건 연산자)
	 	더해 result에 대입되도록 메소드 바디 구현
	 3. 메인 메소드에서 Bufferedreader, reader.readLine() 이용해 변수 3개 입력받기
	 4. 메소드 호출 > printf 결과 출력! "총 소요 시간은 %d분입니다."
	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("역의 개수: ");
		int station = Integer.parseInt(reader.readLine());

		System.out.print("환승역의 횟수: ");
		int change = Integer.parseInt(reader.readLine());
		
		System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시): ");
		int time = Integer.parseInt(reader.readLine());
		
		int result = getTime(station, change, time);
		System.out.printf("총 소요 시간은 %d분입니다.\n", result);
		
	}
	
	public static int getTime(int station, int change, int time) {
		
		int transferTime = (time == 1) ? 3 :
						   (time == 2) ? 4 : 5;
		int result = (station * 2) + (change * transferTime);
		
		return result;
		
	}
}

