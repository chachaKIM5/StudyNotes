package com.test.java.question.File;

import java.io.File;

public class Q06 {

	public static void main(String[] args) {
		
		//파일의 크기가 0byte인 파일만 삭제하시오.
		//C:\class\java\파일_디렉토리_문제\파일 제거
		
		/*
		 
		  프로세스 설계
		  1. File dir로 디렉토리 객체 만들고, dir.listFiles로 파일 배열 만들기
		  2. file인지 검사, for문 돌려 크기 0이면 delete 실행, 삭제 개수 누적 변수 count++
		  3. 결과 출력
		  
		 */
		
		//(1)
		File dir = new File("C:\\class\\java\\파일_디렉토리_문제\\파일 제거");
		File[] list = dir.listFiles();
		int count = 0;
		
		for (int i=0 ; i<list.length ; i++) {
			
			//(2)
			if (list[i].isFile()) {
				
				if (list[i].length() == 0) { 
					list[i].delete();
					count++;
				}
						
			}
		}
		
		//(3)
		System.out.printf("총 %d개의 파일을 삭제했습니다.", count);
		
	}
}
