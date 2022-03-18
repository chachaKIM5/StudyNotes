package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q09 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스 설계
	 1. BufferedReader로 배열 길이 입력받은 후 listOld(원본), listNew(결과) String 배열 2개 만들기
	 2. 원본 배열 요소에 난수 1~9 대입
	 3. 결과의 i항이 원본의 (2xi항 + (2xi+1))항 요소의 값을 가져온다는 점을 이용해 for문 만들기
	 4. 이때 결과 배열의 길이가 홀수이고 (&&)
	 	결과 배열의 마지막 항을 구하는 중이라면 원본의 마지막 항을 그대로 가져온다 (if문 추가)
	 5. 결과 출력
	  
	 */
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 길이: ");
		int length = Integer.parseInt(reader.readLine());

		
		//원본(listOld), 결과(listNew) 배열 2개 
		int[] listOld = new int[length];
		int[] listNew = new int[(length % 2 == 0) ?
								(length / 2) : (length / 2 + 1)];
		
		
		
		//원본 배열의 요소에 1~9 난수 넣기
		for (int i=0 ; i<length ; i++) {
			listOld[i] = (int)(Math.random() * 9 + 1);
		}
		
		
		
		//for문: 결과의 i항은 원본의 (2xi항 + (2xi+1))항 값을 가져온다
			for (int i=0 ; i<listNew.length ; i++) {
				
				
				//이때 결과 배열의 길이가 홀수, (&&)
			 	//마지막 항을 구하는 중이라면 원본의 마지막 항을 그대로 가져온다
				if ((length % 2 == 1) && (i == listNew.length-1)) {
					listNew[listNew.length-1] = listOld[listOld.length-1];

				} else {
					listNew[i] = listOld[2*i] + listOld[2*i+1];
				}				
		
			}

		
		//결과 출력
		System.out.printf("원본: %s\n", Arrays.toString(listOld));
		System.out.printf("결과: %s", Arrays.toString(listNew));
		
	}
}
