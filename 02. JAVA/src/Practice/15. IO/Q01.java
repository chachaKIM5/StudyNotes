package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q01 {

	public static void main(String[] args) {
		
		//특정 이름을 찾아 다른 이름으로 변환 후 파일을 다른 이름으로 저장하시오.
		//'유재석' → '메뚜기'
		//저장할 파일명: 이름수정_변환.dat
		//C:\class\java\파일_입출력_문제\이름수정.dat
		
		try {
			File file = new File("C:\\class\\java\\파일_입출력_문제\\이름수정.dat");
			File fileEdit = new File("C:\\class\\java\\파일_입출력_문제\\이름수정_변환.dat");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileEdit));

			
			
			String line = null;
			
			
			//한 줄씩 읽어오면서 line의 "유재석"을 모두 "메뚜기"로 바꾼다
			while ((line = reader.readLine()) != null) {
				writer.write(line.replace("유재석", "메뚜기"));
				writer.newLine();
			}
			
			reader.close();
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");

			
		} catch (Exception e) {
			
			System.out.println("Q01.main");
			e.printStackTrace();
		}

	}
}
