package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		/*
		  
		 프로세스 설계
		 1. int[] nums 선언 후 BufferedReader로 숫자 5개를 입력받는다.
		 2. 반복문으로 int[4]~int[0]까지 -1 하면서 역순으로 출력
		  
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[5];
		
		
		
		//숫자 5개 입력받기
		for (int i=0 ; i<nums.length ; i++) {
			
			System.out.printf("숫자: ");
			nums[i] = Integer.parseInt(reader.readLine());
		}
		
		
		
		//역순 출력
		int order = nums.length-1;
		while (order >= 0) {
			
			System.out.printf("nums[%d] = %d\n", order, nums[order]);
			order--;
		}
				
		
	}
}
