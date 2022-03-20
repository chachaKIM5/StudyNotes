package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step0005_2438 {

	public static void main(String[] args) throws Exception {
		
		//문제 - 별찍기
		//첫번째 줄에 N(1<=N<=100)을 입력하면 첫 번째 줄에는 별 1개, N번째 줄에는 별 N개가 찍힌다
		//이때 별이 정렬된 모양은 아래와 같다
		//*
		//**
		//***
		//****
		//*****
		
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	while (true) { 					  //프로그램 자동 반복 실행
		System.out.print("숫자 입력(1<=N<=100): ");
		int row = Integer.parseInt(reader.readLine());
		
		if (row >= 1 && row <= 100) { //유효성 검사
									  //별찍기
			
			for (int i=0 ; i<row ; i++) {	
				for (int j=0 ; j<i+1 ; j++) {
					System.out.print("*");
				} System.out.println();
			}
			System.out.printf("다시 실행하려면 엔터를 눌러주세요.\n");
			reader.readLine();
			continue;
			
			
		} else {
			System.out.printf("잘못된 범위의 숫자입니다. 다시 입력하려면 엔터를 눌러주세요.\n");
			reader.readLine();
		}
	}
	
	}
}
