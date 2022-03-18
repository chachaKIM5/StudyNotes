package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. 길이가 10인 원본 배열 int[] list = 초기화 리스트로 각 요소 값을 설정해 준다
	 2. BufferedReader로 삽입 위치와 값 입력받고 변수에 대입
	 3. 원본 출력
	 4. for문 반복, i는 list[]의 가장 끝 요소에서부터 바로 앞 요소(항)의 값을 복사해 옮겨온다
	 5. i가 입력한 삽입 위치와 같아졌을 때 앞 항을 복사하지 않고 입력된 값을 넣은 후 break;로 반복문 탈출
	 6. 결과 출력
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//원본 설정
		int[] list = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		
		
		//사용자에게 입력받기
		System.out.print("삽입 위치: ");
		int insert = Integer.parseInt(reader.readLine());
		
		System.out.print("값: ");
		int insertNum = Integer.parseInt(reader.readLine());
		
		
		
		//원본 먼저 출력
		System.out.printf("원본: %s\n", Arrays.toString(list));
		
		
		
		//가장 끝에서부터 바로 앞 요소(항)의 값을 복사하며 루프,
		//list[i]가 사용자가 입력한 삽입 위치가 되면 앞의 값을 복사하지 않고 사용자 입력 값을 넣은 후 반복문 탈출 
		for (int i=list.length-1 ; ; i--) {
						
				if (i == insert) {
					list[i] = insertNum;
					break;
				}
				
				list[i] = list[i-1];
			
		}
		
		//결과 출력
		System.out.printf("결과: %s", Arrays.toString(list));
		
	}
}
