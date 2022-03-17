package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int row = Integer.parseInt(reader.readLine());
		
		
		for (int i=1 ; i<=row ; i++) {
			
			for (int j=row-1 ; j>=i ; j--) {
				System.out.print(" ");
			}
			
			for (int k=1 ; k<=i ; k++) { 
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		//가장 바깥쪽 for문 = 줄바꿈의 역할
		//첫번째 for문 = j=row-1가 i가 되기까지 1씩 감소하며 공백 출력
		//두번째 for문 = 공백 출력 후 k가 i값이 될 때까지 = 첫줄엔 1개, 둘째줄엔 2개... * 출력

	}//main
}


    