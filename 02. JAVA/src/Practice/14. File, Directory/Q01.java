package com.test.java.question.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		//파일의 경로를 입력받아 파일 정보를 출력하시오.
		//파일 크기 단위 변환 출력(소수이하 1자리까지) : B, KB, MB, GB, TB
		
		/*
		 
		 프로세스 설계
		 1. BufferedReader로 파일 경로 입력받기
		 2. exists()로 파일 경로 유효성 검사
		 3. getname()으로 파일명, substring(getname())으로 확장자 알아내기
		 4. 매개변수 File file을 입력하면 Byte단위의 파일 크기를 구하고,
		    단위를 변환해 반환하는 메소드 생성 (getLength)
		 5. 출력
		 
		 */
		
		//(1)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일 경로: ");
		String PATH = reader.readLine();
		
		File file = new File(PATH);
		
		if (file.exists()) {													//(2)
			
			String name = file.getName();										//(3)
			String extension = name.substring(name.lastIndexOf(".") + 1);
						
			System.out.printf("파일명: %s\n", name);								//(5)
			System.out.printf("종류: %s 파일\n", extension);
			System.out.printf("파일 크기: %s", getLength(file));
			
		} else { 
			
			System.out.println("파일 없음");
		}
		
	} //main
	
	public static String getLength(File file) {									//(4)
		
		double length = file.length();
		String[] unit = { "B", "KB", "MB", "GB", "TB" };
		int unitIndex = 0;
		
		while (length >= 1024) {
	
			length = length / 1024;
			unitIndex++;
		}
		
		return String.format("%.1f%s", length, unit[unitIndex]);
	}
	
	

} //Q01
