package com.test.java.question.File;

import java.io.File;

public class Q10_answer {
	
	public static void main(String[] args) {

		String PATH = "C:\\class\\java\\파일_디렉토리_문제\\직원";
		File dir = new File(PATH);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			//(1)
			for (File file : list) {
				if (file.isFile()) {
					String filename = file.getName();
					
					//Parsing : 의미 있는 부분들을 쪼개는 작업
					
					filename = filename.replace("__", "_"); //정규화
					String[] temp = filename.split("_");
					//0 - 직원명
					//1 - 년도
					
					File newDirectory = new File (dir.getAbsolutePath() + "\\" + temp[0] + "\\" + temp[1]);
					
					newDirectory.mkdirs();
					
					File moveFile = new File(newDirectory.getAbsolutePath() + "\\" + file.getName());
					file.renameTo(moveFile);
					
					
				}
			}
				
			System.out.println("분류가 완료되었습니다.");
		}
	}
}
