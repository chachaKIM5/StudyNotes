package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {

	public static void main(String[] args) throws Exception {
		
		//문장에 존재하는 모든 숫자의 합 구하기
		//모든 숫자는 한자리씩 추출해 처리
		//Q03과 거의 비슷
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int sum = 0;
		
		System.out.print("입력: ");
		String input = reader.readLine();
		
		
		for (int i=0 ; i<input.length() ; i++) {
			
			for (int j=0 ; j<num.length ; j++) {
			
				
				//문자열에서 한 글자씩 추출, num[j](0~9)가 있으면 누적변수 sum에 더한다
				if (input.substring(i, i+1).equals(num[j])) {
					sum += Integer.parseInt(num[j]);
				}

			}
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.", sum);
		
	}
	
}
