package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q08 {

	public static void main(String[] args) throws Exception {
	
	/*
	 
	 프로세스 설계
	 => list[i]의 값을 사용자가 지정한 곳부터 list[i+1]에서 복사해 온다는 것만 빼면 Q07과 거의 같다
	 
	 Q07은 앞에서 뒤로 복사, Q08은 뒤에서 앞으로 복사
	  
	 */
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//원본 설정
		int[] list = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		
		
		//사용자에게 입력받기
		System.out.print("삭제 위치: ");
		int delete = Integer.parseInt(reader.readLine());
		
		
		
		//원본 먼저 출력
		System.out.printf("원본: %s\n", Arrays.toString(list));
		
		
		
		//i = 사용자가 입력한 삽입 위치에서부터 시작
		//뒤의 값을 복사해 앞으로 가져온다
		//i가 list의 마지막 요소(항)이 되면 0을 대입한다 
		for (int i=delete ; i<list.length ; i++) {
						
				if (i == list.length-1) {
					list[i] = 0;
				} else {
					list[i] = list[i+1];
				}
		}
		
		//결과 출력
		System.out.printf("결과: %s", Arrays.toString(list));
		
		
	}
		
}
