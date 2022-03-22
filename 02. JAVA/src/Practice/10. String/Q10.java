package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10 {

	public static void main(String[] args) throws Exception {
		
		//단위는 만+일
		//숫자를 추출하고 몇 번째 자리인지 알아내야 함
		//배열을 사용해 푸는 게 매우 편함
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원): ");
		String won = reader.readLine();
		String[] array = new String[won.length()];
		String[] unit = { "", "십", "백", "천", "만" };
		int n = 0;
		
		String output = "";
		
		
		for (int i=0 ; i<array.length ; i++) {
			array[i] = won.substring(i, i+1);
		}
		
		
		for (int i=array.length-1 ; i>=0 ; i--) {
			
			if (n > 4) {
				n -= 4;
			}
			
			output = kor(array[i]) + unit[n] + output;
			n++;
		}
			
		
		System.out.println("일금 " + output + "원");
		
		
		
	} //main
	
	public static String kor(String num) {
		
		switch (num) {
			case "1": return "일";
			case "2": return "이";
			case "3": return "삼";
			case "4": return "사";
			case "5": return "오";
			case "6": return "육";
			case "7": return "칠";
			case "8": return "팔";
			case "9": return "구";
			case "0": return "";
		}
		return "0";
		
	}
}
