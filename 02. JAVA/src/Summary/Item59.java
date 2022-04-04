package com.test.java;

import java.io.File;
import java.util.Calendar;

public class Item59 {

	public static void main(String[] args) {
		
		//[SUMMARY] 파일(File) 디렉토리(Directory) 객체 정보 가져오기 (2022. 4. 4. 오후 11:34:40)
		
		//경로
		String PATH = "C:\\class\\java\\file\\data.txt";
	
		
		//File 객체 선언
		File file = new File(PATH);
		
		
		//파일 및 폴더 기본 정보 가져오기
		
		
		//1. 해당 경로의 파일 존재 여부 확인 
		if (file.exists()) {
			
			System.out.println("파일 있음");
			
			
			System.out.println(file.getName());			//2. 파일 이름		 //data.txt
			System.out.println(file.isFile());			//3. 파일인지?		//true
			System.out.println(file.isDirectory());		//4. 폴더인지?		//false
			
			System.out.println(file.length());			//5. 파일/폴더 크기	//15(바이트)
			
			System.out.println(file.getAbsolutePath());	//6. 파일 경로 		//C:\class\java\file\data.txt
			System.out.println(file.getParent());		//7. 파일 부모 폴더	//C:\class\java\file
			
			System.out.println(file.lastModified());	//8. 마지막 수정 시간	//1649032762090 (tick값)
				
				//tick -> 년월일시분초
				Calendar c1 = Calendar.getInstance();
				System.out.println(c1.getTimeInMillis());
				c1.setTimeInMillis(file.lastModified());//c1를 수정한 tick값 시간
				System.out.printf("%tF %tT\n", c1, c1);
				
			System.out.println(file.isHidden());		//9. 숨김 파일 여부	//false	
		}

	}
}