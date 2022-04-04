package com.test.java.question.File;

import java.io.File;
import java.util.ArrayList;

public class Q09 {

	private static ArrayList<File> totalList = new ArrayList<File>();

	public static void main(String[] args) {
		
		
		//폴더 내의 모든 파일들을 찾아 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
		//자식 폴더내의 파일도 모두 검색하시오.
		//부모 자식 폴더에 상관없이 파일을 한번에 비교하시오.
		
		//C:\class\java\파일_디렉토리_문제\크기 정렬
		
		/*
		 
		 프로세스 설계
		 
		 1. static 객체 멤버 ArrayList[] totalList, PATH (경로) 설정, exists로 경로 유효성 검사
		 
		 2. 메소드 4개 생성
		 	- getAllFile: ArrayList[] totaList에 모든 파일 넣기 (Q08과 같다)
		 	- sort: totalList.get(j).length() > File 객체의 사이즈에 따라
		 	 		totalList.get(j) > File 객체의 버블 정렬
		  	- getLength: 파일의 크기 단위 변환해 가져오는 메소드 (Q01과 같다)
		  	- getParnet: 파일의 경로에서 바로 위 부모 폴더 이름만 따오는 메소드
		  	
		 3. 형식 문자 적절히 조절해 예쁘게 출력 
		  
		 */
		
		
		String PATH = "C:\\class\\java\\파일_디렉토리_문제\\크기 정렬";
		File dir = new File(PATH);
		
		
		if (dir.exists()) {
			
			
			getAllFile(dir);
			sort();
			
			
			
			System.out.println("[파일명]\t\t\t\t[크기]\t\t[파일이 들어있는 폴더]");
			
			for (File file : totalList) {
				System.out.printf("%-30s\t%5s\t\t%s\n"
											, file.getName()
											, getLength(file)
											, getParent(file));
			}
		
			
		} else {
			System.out.println("잘못된 경로입니다.");
		}
		
	}
	
	
	public static void getAllFile(File dir) {
	
	
		File[] list = dir.listFiles();
			
		for (File file : list) {
			
			if (file.isFile()) {
				totalList.add(file);
			}
			
			if (file.isDirectory()) {
				getAllFile(file);
			}
		}
		
	}

	
	public static void sort() {
		
		for (int i=0 ; i<totalList.size()-1 ; i++) {
			for (int j=0 ; j<totalList.size()-i-1 ; j++) {
				
				if (totalList.get(j).length() < totalList.get(j+1).length()) {
					
					File temp = totalList.get(j);
					totalList.set(j, totalList.get(j+1));
					totalList.set(j+1, temp);
				}
				
			}
		}
		
	}
	
	
	public static String getLength(File file) {	
		
		long length = file.length();
		String[] unit = { "B", "KB", "MB", "GB", "TB" };
		int unitIndex = 0;
		
		while (length >= 1024) {
	
			length = length / 1024;
			unitIndex++;
		}
		
		return String.format("%d%s", length, unit[unitIndex]);
	}

	
	
	public static String getParent(File file) {
		
		String PATH = file.getParent();
		int index = PATH.lastIndexOf("\\") + 1;
		
		return PATH.substring(index);
		
	}
}
