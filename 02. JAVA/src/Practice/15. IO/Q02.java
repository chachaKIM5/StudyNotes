package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q02 {

	public static void main(String[] args) {
		
		//숫자를 한글로 바꾼 뒤 파일을 다른 이름으로 저장하시오.
		//0 → 영, 1 → 일 ... 9 → 구
		//저장할 파일명: 숫자_변환.dat
		//C:\class\java\파일_입출력_문제\숫자.dat
		
		try {
	
			File file = new File("C:\\class\\java\\파일_입출력_문제\\숫자.dat");
			File fileEdit = new File("C:\\class\\java\\파일_입출력_문제\\숫자_변환.dat");
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileEdit));
			
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				writer.write(replaceNum(line));					//문장의 숫자를 한글 숫자로 바꾸는 메소드
				writer.newLine();
			}
			
			reader.close();
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
			
			
		} catch (Exception e) {
			System.out.println("Q02.main");
			e.printStackTrace();
		}
		
	}

	private static String replaceNum(String line) {
		
		String[] num	= { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] numKor = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		
		
		//num을 포함하면 같은 방 번호의 numKor로 바꾸기 
		for (int i=0 ; i<num.length ; i++) {
			if (line.contains(num[i])) {
				line = line.replace(num[i], numKor[i]);
			}
		}
		
		return line;
	}
}
