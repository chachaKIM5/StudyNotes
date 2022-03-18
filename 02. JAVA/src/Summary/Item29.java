package com.test.java;

public class Item29 {

	public static void main(String[] args) {
		
		//[SUMMARY] while문, do while, 반복문 (2022. 3. 18. 오후 8:02:19)

		
		//while과 do while문으로 같은 결과물 내기
		
		
		//while문 예시
		
		int num = 1;					//초기식
		
		while (num <= 10) {				//조건식
			System.out.println(num);
			
			num++;						//증감식
		}
		
		
		
		//do while문
		
		num = 1;
		
		do {
			System.out.println(num);
		
			num++;
			
		} while (num <= 10);		
		
	}
}

