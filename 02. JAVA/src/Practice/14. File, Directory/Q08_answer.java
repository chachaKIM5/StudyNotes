package com.test.java.question.File;

import java.io.File;

public class Q08_answer {
	
	private static int countFile = 0;
	private static int countFolder = 0;
	
	public static void main(String[] args) {
	
		File dir = new File("C:\\class\\java\\파일_디렉토리_문제\\폴더 삭제\\delete");
		deleteDirectory(dir);
		
		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다."
											, countFolder
											, countFile);
		
	}


	public static void deleteDirectory(File dir) {
		
		File[] list = dir.listFiles();
		
		
		for (File f : list) {
			if (f.isFile()) {
				f.delete();
				countFile++;
			}
		}
		
		for (File d : list) {
			if (d.isDirectory()) {
				deleteDirectory(d); //재귀
				countFolder++;
			}
		}
		
		dir.delete();
	}
}