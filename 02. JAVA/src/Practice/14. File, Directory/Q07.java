package com.test.java.question.File;

import java.io.File;
import java.util.HashSet;

public class Q07 {

	public static void main(String[] args) {
		
		//HashSet 쓰거나 List 사용하는 방법 둘 중 하나
		//MusicA 폴더와 MusicB 폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오.
		//C:\class\java\파일_디렉토리_문제\동일 파일\MusicA
		//C:\class\java\파일_디렉토리_문제\동일 파일\MusicB
		
		
		/*
		
		 프로세스 설계
		 1. HashSet<String> set 생성, MusicA 파일 배열과 MusicB 파일 배열 생성
		 2. MusicA의 파일 이름들을 set에 모두 넣는다
		 3. MusicB의 파일 이름들을 set에 넣으려고 시도, false의 경우(중복) getName() 출력
		
		 */
		
		
		
		//(1)
		HashSet<String> set = new HashSet<String>();
		
		File dirA = new File("C:\\class\\java\\파일_디렉토리_문제\\동일 파일\\MusicA");
		File dirB = new File("C:\\class\\java\\파일_디렉토리_문제\\동일 파일\\MusicB");
		
		
		if (dirA.exists() && dirB.exists()) {
		
			File[] listA = dirA.listFiles();
			File[] listB = dirB.listFiles();
			
			
			
			//(2)
			for (File file : listA) {
				if (file.isFile()) {
					set.add(file.getName());
				}
			}
			
			
			
			//(3)
			for (File file : listB) {
				if (file.isFile()) {
					
					if (!set.add(file.getName())) {
						System.out.println(file.getName());
						
					}
				}			
			}
			
		} else { 
			System.out.println("MusicA 혹은 Music B 폴더를 찾을 수 없습니다.");
		}
	}
}
