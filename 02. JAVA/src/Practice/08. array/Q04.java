package com.test.java.question.array;

import java.util.Arrays;

public class Q04 {

	public static void main(String[] args) {
	
		
	/*
	 
	길이 20개짜리 배열 만들고 난수 20개 넣기
	최대값과 최소값을 찾아라
	
	프로세스 설계
	1. 길이가 20인 배열 int random[] 생성 후 Math.random() 메소드 이용해 1~20의 난수 넣기
		(1) Math.random 사용한 난수는 0 <= random < 1이므로,
		    20을 곱한 후 1을 더해주면 난수 범위가 1 <= random < 21이 된다. 
	2. for문으로 random[0]~random[19]을 형식에 맞게 출력,
	   for문을 탈출하고 마지막 ", "를 지우는 문자열 printf("\b\b\n") 출력
	3. Arrays.sort(random)으로 정렬 후 최솟값 random[0]과 최댓값 random[19] 출력
	
	 
	 */
		

		//난수 입력
		int[] random = new int[20];
		
		for (int i=0 ; i<random.length ; i++) {
			random[i] = ((int)(Math.random() * 20 + 1));
		}
		
		
		//원본 출력
		System.out.print("원본: ");
		for (int i=0 ; i<random.length ; i++) {
				
			System.out.printf("%d, ", random[i]);
				
		} System.out.printf("\b\b\n");
		
		
		
		//정렬 후 최대값과 최소값 출력
		Arrays.sort(random);
		System.out.printf("최대값: %d\n", random[random.length-1]);
		System.out.printf("최소값: %d", random[0]);
			
			
		
	}
}
