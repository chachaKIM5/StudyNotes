package com.test.java;

import java.io.File;
import java.io.IOException;

public class Item60 {

	public static void main(String[] args) {
		
		//[SUMMARY] 파일, 폴더(디렉토리) 조작 (2022. 4. 4. 오후 11:41:23)
		
		//1. 파일 생성
		//File file = new File("아직 없지만 만들고 싶은 파일의 가상 경로 및 파일명");
		File file = new File("C:\\class\\java\\file\\hello.txt");
		
		if (!file.exists()) {
			
			try {
				System.out.println(file.createNewFile());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("동일한 파일이 이미 존재합니다.");
		}

		
		
		//2. 파일명, 폴더명 수정
		//바꾸고 싶은 파일명, 폴더명으로 참조 객체 하나 더 생성
		
		File file2 = new File("C:\\class\\java\\file\\hello.txt");
		File file3 = new File("C:\\class\\java\\file\\hi.txt");
		
		if (file2.exists()) {
			
			//file2(hello.txt) -> file3(hi.txt)
			boolean result = file2.renameTo(file3);
			System.out.println(result);
		}
		
		
		
		//3. 파일 이동
		//파일, 폴더 이동하기
		//파일명 수정, 폴더명 수정과 같은 메소드를 사용한다
		// - file\hello.txt > move\hello.txt
		
		File file4 = new File("C:\\class\\java\\file\\hello.txt");
		File file5 = new File("C:\\class\\java\\move\\hi.txt");
				
		if (file4.exists()) {
					
			boolean result = file4.renameTo(file5);
			System.out.println(result);
		}
		
		
		
		//4. 파일, 폴더 삭제
		//영구 삭제, 복원 불가
		//폴더는 내용물이 없어야만 삭제할 수 있다!
		if (file.exists()) {
			
			boolean result = file.delete();
			System.out.println(result);
		}
		
		
		
		//5. 폴더 생성
		//mkdir > 하나만 만든다
		//mkdirs > 경로의 상위, 하위 폴더... 존재하지 않는 모든 폴더를 만들 수 있다
		File dir = new File("C:\\class\\java\\file\\bbb\\ccc");
		
		if (!dir.exists()) {
		
			boolean result = dir.mkdirs();
			System.out.println(result);
	
		} else {
			
			System.out.println("이미 같은 이름의 폴더가 존재합니다.");
		}
		
		
		
		//6. 폴더 내용물 탐색
		File dir6 = new File("C:\\class\\eclipse");
		
		if (dir6.exists()) {
			
		}
		File[] list = dir6.listFiles();
		
		for (File d : list) {
			if (d.isDirectory()) {
				System.out.printf("[%s]\n", d.getName());
			} 
		}
		
		for (File f : list) {
			if (f.isFile()) {
				System.out.printf("%s\n", f.getName()); 
			}
		}
		
	}
	
}
