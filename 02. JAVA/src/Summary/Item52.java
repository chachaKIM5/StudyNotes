package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Item52 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 예외 미루기, 예외 던지기 (2022. 3. 30. 오후 9:51:35)
		//TODO fianlly 수업 후 수정 필요
	
		try {
			m1();
		} catch (Exception e) {
			
		}

		m2();
		
	}//main
 


	private static void m1() throws Exception {
	
		//예외 미루기
		
		//에러를 방치, 해당 영역에서 예외 처리를 하지 않고 다른 곳으로 책임을 떠넘기기
		//메소드명() 옆에 throws Exception 입력
		//메소드에서 throws Exception 한 경우, 메인 메소드에서라도 try-catch 구문을 적용해 줘야 한다
		//메인 메소드를 try-catch로 한꺼번에 감싸 에러를 해결하는 방식에 적합
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		String input = reader.readLine();

 	}//m1

	
	
	private static void m2() {
		
		//예외 던지기
		
		//요구사항] 반드시 짝수만 입력하시오! 홀수는 예외 처리
		 
		int num = 5;
		
		try {
			if (num % 2 == 1) {
				throw new Exception("홀수를 입력했습니다!");
				//예외 객체를 만들어서 던진다 -> 강제로 에러를 발생
			}
			System.out.println("업무 코드 진행");
		} catch (Exception e) {
			System.out.println("예외 처리 진행");
			System.out.println(e.getMessage());
			//e.getMessage()
			//=> throw new Exception에서 생성자 오버로딩으로 작성한 오류 메시지를 불러온다
		}
	}

} //Item52
