package com.test.java.question.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
		//지정한 파일을 다른 폴더로 이동하고, 이동한 파일과 동일한 파일명의 파일이 존재하는 경우 중복 처리하시오.

		//D:\class\java\file\AAA\test.txt → D:\class\java\file\BBB\test.txt 로 이동하는 것이 목적
		//BBB 폴더에 이미 test.txt가 있을 경우 덮어쓰거나(y) 작업을 취소(n) 하시오.
		
		/*
		 프로세스 설계
		 1. AAA\test.txt와 BBB\test.txt의 경로를 가지는 File 객체 2개 생성
		 2. BBB\test.txt가 있는지 exists()로 확인. AAA\test.txt 검사는 생략.. 있으니까 시도했겠지
		 	3-1. BBB\test 없을 경우: renameTo 이용해 폴더 이동 시도
		 	3-2. BBB\test 있을 경우: 덮어쓸까요? y/n 입력받기, y일 경우 덮어쓰기 시도(삭제, 이동)
		 									  - n일 경우 프로그램 종료
		 									  - y도 n도 아니면 그냥 종료
		 */
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
																									//(1)
		File file = new File("C:\\class\\java\\file\\AAA\\test.txt");
		File fileMove = new File("C:\\class\\java\\file\\BBB\\test.txt");
		String answer = "";
		

		if (!fileMove.exists()) {																	//(2)
			
			file.renameTo(fileMove);																//(3)
			System.out.println("파일을 이동했습니다.");
		
		} else {
			
			System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요? (y/n) ");					//(4)
			answer = reader.readLine().toLowerCase();
			
			if (answer.equals("y")) {
				
				fileMove.delete();
				file.renameTo(fileMove);
				System.out.println("y. 파일을 덮어썼습니다.");
			
			} else if (answer.equals("n"))  {
				
				System.out.println("n. 작업을 취소합니다.");
			
			} else {
				
				System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
			
			}
		}
			
	
		
		
	}
	
}
