package com.test.java.question.File;

import java.io.File;
import java.util.ArrayList;

public class Q08 {
	
	private static int countFolder = 0;
	private static int countFile = 0;
	private static ArrayList<File> totalList = new ArrayList<File>();
	
	public static void main(String[] args) {
		
		//재귀 메소드로 모든 파일을 알아내서 ArrayList<File>에 추가?
		
		//내용물이 있는 'delete' 폴더를 삭제하시오.
		//재귀 메소드 사용
		//삭제된 파일과 자식 폴더 개수를 출력하시오.
		//C:\class\java\파일_디렉토리_문제\폴더 삭제\delete
		//C:\class\java\파일_디렉토리_문제\폴더 삭제\delete\One
		//C:\class\java\파일_디렉토리_문제\폴더 삭제\delete\Two
		//C:\class\java\파일_디렉토리_문제\폴더 삭제\delete\Three
		
		/*
		 
		 프로세스 설계
		 
		 1.	ArrayList<File> 배열 totalList와 countFolder, countFile를 static 객체 멤버로 만들기
		 
		 2. 재귀 메소드 사용할 메소드 만들기 > getAllFile(File dir), File dir는 delete의 디렉토리
		 	- dir.listFiles로 delete 안의 파일들을 탐색한다
		 		* isFile = true면 바로 countFile++
		 		* isDirectory = true면 재귀 메소드 호출하고 countFolder++ 하는 식으로 반복
		 
		 3. 모든 File이 든 배열 (모든 파일과 폴더가 들어 있다) totalList 완성
		 
		 4. for문 > delete로 file들을 모두 지운다
		 
		 5. 출력
		  
		 */
		
		
		String PATH = "C:\\class\\java\\파일_디렉토리_문제\\폴더 삭제\\delete";						//(1)
		File dir = new File(PATH);
		
		
		if (dir.exists()) {
			
			
			getAllFile(dir);																	//(2)
			
			for (File file : totalList) {														//(4)
				file.delete();
			}
			
			System.out.println("폴더를 삭제했습니다.");												//(5)
			System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.", countFolder, countFile);
			
			
		} else {
			
			System.out.println("잘못된 경로입니다.");
		}
		
		
		
	}
	
	public static void getAllFile(File dir) {													//(3)
		
		File[] list = dir.listFiles();
		
		for (File file : list) {
			
			if (file.isFile()) {
				totalList.add(file);
				countFile++;
			}
			
			if (file.isDirectory()) {
				getAllFile(file);
				totalList.add(file);
				countFolder++;
			}
		}
		
		
		//아래 한 줄이 있으면 delete 폴더까지 삭제, 없으면 delete의 내용물만 삭제
		totalList.add(dir);

		
	}
	
}	