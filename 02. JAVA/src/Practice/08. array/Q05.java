package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. BufferedReader로 최대, 최소 범위 변수 max와 min 값을 입력받는다 
	 2. Q04와 똑같이 길이가 20인 int random[]에 1~20 난수 입력
	 3. 원본:~, 결과:~ 반환 없이 바로 출력하는 메소드 2개 생성
	 	(1) 원본 출력은 Q04와 같다
	 	(2) 결과 메소드에서 반복문, if문 활용해
	 	    random[1] ~ random[20] 중 최대, 최소 범위에 해당하는 요소를 골라 출력 
	 
	 
	 */
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위: ");
		int max = Integer.parseInt(reader.readLine());
		
		System.out.print("최소 범위: ");
		int min = Integer.parseInt(reader.readLine());
		
			
		//Q04와 똑같이 난수 입력
		int[] random = new int[20];
		
		for (int i=0 ; i<random.length ; i++) {
			random[i] = ((int)(Math.random() * 20 + 1));
		}
		
		
		//출력
		numList(random);
		rangeList(random, max, min);

		
		
		
	
	} //main
	
	public static void numList(int[] random) { 						//"원본: ~" 출력 메소드
		
		System.out.print("원본: ");
		
		for (int i=0 ; i<random.length ; i++) {
				
			System.out.printf("%d, ", random[i]);
					
		} System.out.printf("\b\b\n");
		
	}

	public static void rangeList(int[] random, int max, int min) {	//"결과: ~" 출력 메소드
		
		
		System.out.print("결과: ");
		
		for (int i=0 ; i<random.length ; i++) {
			
			if (random[i] <= max && random[i] >= min) {
				System.out.printf("%d, ", random[i]);
			}
		} System.out.printf("\b\b");
		
	}
}
