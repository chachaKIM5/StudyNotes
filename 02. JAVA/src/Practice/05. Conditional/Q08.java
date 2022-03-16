package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		
	//Calender 써도 되고 int 변수로 해도 됨, int가 더 쉬움
		
	/*
	 
	 프로세스
	 1. BufferedReader 이용해 들어온 시간과 나간 시간 입력받기
	 2. Integer.parseInt로 int 변수에 입력받은 시간 대입
	 3. 단위를 분으로 변환, 나간 시간 - 들어온 시간 = 총 몇 분 주차했는지 계산 (totalTime)
	 4. 조건문을 이용해 총 주차 시간이 30분 이하면 0원, 30분 초과일 때 / (totalTime - 30) / 10 * 2000
	 5. "주차 요금은 %,d원입니다." 출력!
	 
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[들어온 시간]");
		System.out.print("시: ");
		int inHour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int inMinute = Integer.parseInt(reader.readLine());
		
		System.out.println();
		System.out.println("[나간 시간]");
		System.out.print("시: ");
		int outHour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int outMinute = Integer.parseInt(reader.readLine());
		
		int totalTime = (outHour * 60 + outMinute) - (inHour * 60 + inMinute);

		
		if (totalTime <= 30) {
			System.out.println("주차 요금은 0원입니다.");
	
		} else if (totalTime > 30) {
			System.out.printf("주차 요금은 %,d원입니다.", (totalTime - 30) / 10 * 2000);
		}
		
	}
	

}

