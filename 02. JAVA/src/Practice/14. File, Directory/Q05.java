package com.test.java.question.File;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Q05 {

	public static void main(String[] args) {
		
		//HashMap<String, Integer> 사용
		//C:\class\java\파일_디렉토리_문제\확장자별 카운트
		
		//이미지 파일이 있다. 확장자별로 파일이 몇개 있는지 세시오.
		//새로운 확장자 파일이 추가되도 동작이 가능하게 구현하시오.
		//'mouse.bmp' 추가를 하면.. 소스 수정 없이도 *.bmp : 1개 출력이 되게 하시오.
		
		/*
		 
		 프로세스 설계
		 1. HashMap<String, Integer> 만들어서 key는 확장자, value는 개수로 사용
		 2. File dir 생성하고 유효성 검사, listFiles File 배열 만들기
		 3. for문 -> isFile() 통해 폴더 제외하고 파일만 걸러 lastIndexOf, substring으로 확장자 구하기
		 	      -> 확장자를 HashMap의 Key 값으로 추가, value 값은 1씩 누적해 개수 카운트(추가와 수정이 put으로 같다)
		 		  -> 처음 put으로 추가할 때 value 값에서 nullPointerException 발생 -> 3항 연산자로 해결
		 4. HashMap 배열을 iterator로 loop 돌려 출력
		 
		 */
		
		
		
		//(1)
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		File dir = new File("C:\\class\\java\\파일_디렉토리_문제\\확장자별 카운트");			//(2)
		
		if (dir.exists()) {
			
			
			File[] list = dir.listFiles();
			String name = "";
			String extension = "";
			
			for (int i=0 ; i<list.length ; i++) {										//(3)
				
				if (list[i].isFile()) {
	
					name = list[i].getName().toLowerCase();								//대소문자 구분 없이 실행하기 위해 toLowerCase 적용
					extension = name.substring(name.lastIndexOf("."));
					
					result.put(extension, (result.get(extension) == null ? 0 : result.get(extension)) + 1);
				}
			}
			
			
			
			Set<String> set = result.keySet();											//(4)
			
			Iterator<String> iter = set.iterator();
			
			while (iter.hasNext()) {
				
				String key = iter.next();			
				System.out.println("*" + key + " : " + result.get(key) + "개");
			
			}
			
		} else {
			System.out.println("잘못된 경로입니다.");
		}
		
	}
}
