package com.test.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Item63 {

	public static void main(String[] args) {
		
		//[SUMMARY] 파일 입출력(File Input, Output) IO (2022. 4. 8. 오후 10:19:02)

		
		/*
		 
		 입력 클래스
		 - FileInputStream
		 - FileReader
		 - BufferedReader
		 
		 출력 클래스
		 - FileOutputStream
		 - FileWriter
		 - BufferedWriter
		  
		 */
		
		FileInputStreamNFileOutputStream();
		FileReaderNFileWriter();
		BufferedReaderNBufferedWriter();
		
	}

	private static void BufferedReaderNBufferedWriter() {

		//줄 단위로 파일 입, 출력
		//서로 다른 전용 도구들을 감싸 사용법을 통일시켜 주는 범용 도구
		
		//파일 읽기
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\java\\file\\할일.txt"));
	
			String line = null;
						
			while ((line = reader.readLine()) != null) {				
				System.out.println(line);
			}
						
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Item63.BufferedReaderNBufferedWriter");
			e.printStackTrace();
		}
		
		
		
		//파일 쓰기
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\java\\file\\list.txt"));
			
			writer.write("안녕하세요.");
			writer.newLine(); //writer.write("\n");
			writer.write("홍길동입니다.");
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Item63.BufferedReaderNBufferedWriter");
			e.printStackTrace();
		}
	}

	private static void FileReaderNFileWriter() {
		
		//오로지 파일을 대상으로 입, 출력할 수 있는 전용 도구
		//파일 읽기
		
		try {
			
			FileReader reader = new FileReader("C:\\class\\java\\file\\할일.txt");
	
			int code = -1;
						
				while ((code = reader.read()) != -1) {
					System.out.print((char)code);
				}
						
			reader.close();
		
		} catch (Exception e) {
			System.out.println("Item63.FileReaderNFileWriter");
			e.printStackTrace();
		}
		
		
		
		//파일 쓰기
		try {

			FileWriter writer = new FileWriter("C:\\class\\java\\file\\member.txt", true);

			writer.write("\n");
			writer.write("홍길동");
			writer.write("\n");
			writer.write("아무개");
			writer.write("\n");
			writer.write("하하하");
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Item63.FileReaderNFileWriter");
			e.printStackTrace();
		}
		
		
	}

	private static void FileInputStreamNFileOutputStream() {
		
		//FileInputStream & FileOutputStream
		// - 파일로부터 데이터를 1바이트 단위로 입력받고 출력하는 스트림
		// - 한글 사용 불가능
				
		File file = new File("C:\\class\\java\\file\\data.txt");
			
		//파일 읽기
		try {

			FileInputStream stream1 = new FileInputStream(file);
		
			int code = -1;
			
			while ((code = stream1.read()) != -1) {				
				System.out.println((char)code);
			}

		stream1.close();
		
		} catch (Exception e) {
			System.out.println("Item63.FileInputStreamNFileOutputStream");
			e.printStackTrace();
		}
				
		
		
		//파일 쓰기
				
		try {
					
			FileOutputStream stream2 = new FileOutputStream(file);
					
			String txt = "Hello~ Hong~";
		
			for(int i=0 ; i<txt.length() ; i++) {
				stream2.write(txt.charAt(i));
			}
			
		stream2.close();
				
		} catch (Exception e) {
			System.out.println("Item63.FileInputStreamNFileOutputStream");
			e.printStackTrace();
		}
		
	}
}










