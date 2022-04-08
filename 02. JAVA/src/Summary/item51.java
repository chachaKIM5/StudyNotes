package com.test.java;

public class item51 {

	public static void main(String[] args) {
		
		//[SUMMARY] 예외 처리, Exception, try catch문 (2022. 3. 30. 오후 9:32:11)
		
		/*
		
		 예외 처리, Exception Handling
		 1. 전통적인 방식
		 	- 제어문 사용 (조건문)
		 	- 사전에 미리 검사해서 사고가 안 나도록 처리
		 
		 2. 전용 처리 방식(권장)
			- try catch (finally)문 사용
			- 일단 실행하고 감시, 사고가 터지면 그때 처리
		 	- '감시'해야 하므로 try 영역 넓어질수록 프로그램이 무거워진다!
		      ***** try의 영역을 최소화해야 한다
			
			
			*** try문 기본 구조 및 실행 순서
			
			try {
				비즈니스 코드
			} catch (Exception e) {
				예외 처리 코드
			}
			
			
			1. try를 만나면 무조건 try 안에 있는 코드를 실행
				2-1. 아무 문제가 없었음
					3. 빠져나감 (catch 실행 X)
				2-2. 에러 발생?
					3. 남아있는 try 업무코드를 무시하고 실행 중단
					4. 즉시 catch로 이동, catch절을 실행하고 빠져나감
					
			Exception e
			- 예외 객체
			- 예외가 발생한 상황에 대한 정보를 알려 준다
			- e.getMessage(), e.printStackTrace() 등으로 사용
			
		 */
		
		exCatch();
		
		
	} //main
	
	
	//다중 catch문 예시
	
	private static void exCatch() {
		
		try {
			
			int num = 0;
			System.out.println(100 / num);
			
			int[] nums = { 10, 20, 30 };
			System.out.println(nums[5]);
			
			Parent p = new Parent();
			Child c;
			c = (Child)p;
		
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류");
		} catch (ClassCastException e) {
			System.out.println("형변환 오류");
		} catch (Exception e) {
			System.out.println("기타 모든 예외 처리");
			e.printStackTrace();
		}
	}
}
//22/04/08 파일 제목 오타 수정
