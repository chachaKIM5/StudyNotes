package com.test.java.question.File;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

public class Q10 {

	private static HashSet<File> set = new HashSet<File>();
	
	public static void main(String[] args) {
		
		//아래의 조건에 따라 파일을 폴더별로 분류/이동하시오.
		//1차 : 직원 이름으로 폴더 생성
		//2차 : 년도별로 폴더 생성
		//3차 : 각 파일을 직원 > 년도 폴더에 이동
		//C:\class\java\파일_디렉토리_문제\직원
		
		/*
		 
		 프로세스 설계
		 
		 1. main class 멤버 메소드 HashSet<File> 생성해 File이면 다 넣는다
		 2. while 루프 > iterator로 하나씩 꺼내면서 앞 3자리 이름과 연도를 검사
		 3. getMEMBERDIR 메소드: 각 파일이 들어가야 할 경로 (= 만들어져야 할 폴더 경로) 반환
		 4. (3)에 따라 적절한 폴더가 없으면(!exists) 생성
		 5. 폴더가 준비되면 (3)의 경로에서 파일명을 더해 renameTo로 이동시킨다
		  
		 */
		
		String PATH = "C:\\class\\java\\파일_디렉토리_문제\\직원";
		File dir = new File(PATH);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			//(1)
			for (File file : list) {
				if (file.isFile()) {
					set.add(file);
				}
			}
			
			
			
			//(2)
			
			Iterator<File> iter = set.iterator();
			
			
			while (iter.hasNext()) {
				
				File next = iter.next();
				File memberDir = new File(getMEMBERDIR(next));						//(3)
				
				
				if (!memberDir.exists()) {											//(4)
					memberDir.mkdirs();
				}
				
				
				File member = new File(memberDir + "\\" + next.getName()); 			//(5)
				next.renameTo(member);
			}
			
			System.out.println("분류가 완료되었습니다.");
			
		} else {
			System.out.println("잘못된 경로입니다.");
		}
		
		
	}
	
	public static String getMEMBERDIR(File next) {
		
		int index = next.getName().indexOf("_");
		
		String name = next.getName().substring(0, index);
		String year = next.getName().substring(index+1, index+5);
		
		return "C:\\class\\java\\파일_디렉토리_문제\\직원\\" + name + "\\" + year; 
		
	}
}
