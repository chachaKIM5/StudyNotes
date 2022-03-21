package com.test.java.question.array2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. Bufferedreader로 국어, 영어, 수학 점수 입력(String 변수 kor, eng, math)
	 2. for 반복문 속 i값에 따라 달라지는 scoreNum 변수 설정 (국어, 영어, 수학 점수가 몇 칸이어야 하는지 뜻함)
	 3. for 반복문 2개로 빈칸과 ■를 표시
	 4. 출력
	 
	 */
		
		String[][] score = new String[10][3];
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 점수: ");
		String kor = reader.readLine();
		
		System.out.print("영어 점수: ");
		String eng = reader.readLine();
		
		System.out.print("수학 점수: ");
		String math = reader.readLine();
	
		
		
		int scoreNum = 0;
		
		for (int i=0 ; i<3 ; i++) {

			switch (i) {
				case 0:
					scoreNum = Integer.parseInt(kor) / 10;
					break;
				
				case 1:
					scoreNum = Integer.parseInt(eng) / 10;
					break;
					
				case 2:
					scoreNum = Integer.parseInt(math) /10;
					break;
			}
			
			
			for(int j=0 ; j<10-scoreNum ; j++) {
				score[j][i] = " ";
			}
			for (int j=10-scoreNum ; j<10 ; j++) {
				score[j][i] = " ■ ";
			}
			
		}
		
		
		
		//출력(고정)
		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; j<3 ; j++) {
		
				System.out.printf("%s\t", score[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------");
		System.out.println("국어\t영어\t수학");
		
		
		
	
	}
}
