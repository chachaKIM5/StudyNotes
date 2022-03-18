package com.test.java.question.array;

public class Q03 {

	public static void main(String[] args) {
		
		/*
	
	 프로세스 설계
	 1. 문제대로 int[] list 선언, 각 요소에 값 대입
	 2. 문자열을 반환하는 메소드 dump(int[] list) 생성, 누적 문자열 String result에 "[ " 초기화
	    for 반복문 통해 루프 변수 i=0이 list.length가 되기 전까지 list[i] + ", "를 더하고
	    for문 탈출 후 " ]"로 대괄호를 닫아준다.
	 3. 메소드 호출
	
		 */
		

		int[] list = new int[4];
		
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;

		
		//메소드 호출, 결과 호출
		String result = dump(list);
		System.out.printf("nums = %s\n", result);
		
	}
	
	
	public static String dump(int[] list) {
		
		String result = "[ ";
		
		for (int i=0 ; i<list.length ; i++) {
			
			
			//마지막 출력되는 숫자는 쉼표 없이
			if (i == list.length-1) {
				result += list[i];
				
			} else {
				result += list[i] + ", ";
			}
			
		}
		result += " ]";
		
		
		return result;
	}
}
