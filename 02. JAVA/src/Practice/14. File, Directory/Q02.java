package com.test.java.question.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		
		//지정한 폴더의 특정 파일(확장자)만을 출력하시오.
		//확장자 대소문자 구분없이 검색 가능
		//디렉토리와 확장자 입력하면 파일명.확장자 출력
		
		/*
		 프로세스 설계
		 1. BufferedReader로 폴더 위치(File dir), 확장자(String extension, 미리 대문자로 바꿔 놓기) 입력받기
		 2. dir.exists()로 폴더 위치가 유효한지 검사
		 3. listFiles로 폴더 안 파일들의 배열 list를 만들고 
		 4. for문 -> if문 -> isFile()로 폴더 제외한 파일들만 추려낸다
		 5. 			 -> if문으로 f.getName.toUpperCase가 endswith(extension)인 경우 출력
		 */
		
		
		//(1)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("폴더: ");
		File dir = new File(reader.readLine());
		
		System.out.print("확장자: ");
		String extension = reader.readLine().toUpperCase();
		System.out.println();
		
		
		if (dir.exists()) {																//(2)
			
			File[] list = dir.listFiles();												//(3)
			
			for (File f : list) {														//(4)
				if (f.isFile()) {
					
					if ((f.getName().toUpperCase()).endsWith(extension)) {				//(5)
						System.out.println(f.getName());
					}
				}
			}
			
		} else {
			
			System.out.println("폴더 입력이 잘못되었습니다.");
		}
		
	}
}
