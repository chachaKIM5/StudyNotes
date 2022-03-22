package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {
		
		//금지어 마스킹
		//금지어: 바보, 멍청이 2개... 금지어 바꾸면 글자수대로 *로
		//마스킹하고 카운트해서 출력
						
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] ban = { "바보", "멍청이" };
		
		System.out.print("입력: ");
		String input = reader.readLine();
		String masking = "";
		int count = 0;
		
		for (int i=0 ; i<ban.length ; i++) {
			
			masking = "";
			
			if (input.indexOf(ban[i]) > -1) {
				
				for (int j=0 ; j<ban[i].length() ; j++) {
					masking += "*";
				}
				
				input = input.replace(ban[i], masking);
				count++;
				
			}
		}
		
		System.out.printf("%s\n금지어를 %d회 마스킹했습니다.", input, count);

	
	
	}
}
