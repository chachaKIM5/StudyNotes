package com.test.java.question.File;

import java.io.File;


public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//음악 파일이 100개 있다. 파일명 앞에 일련 번호를 붙이시오. 001부터 3자리 형식
		
		//C:\class\java\파일_디렉토리_문제\음악 파일\Music에 저장했음!
		
		/*
		 
		 프로세스 설계
		 1. dir 객체, listFiles 통해 File[] list 배열 생성
		 2. for문: 0~list.length까지
		 	renamePATH = (PATH +"[%03d] + list[i]getName())
		 3. temp(renamePATH) 생성, list[i].renameTo(temp)
		 		-> 이름 수정은 File 객체 2개가 있어야 하므로
		 4. for문 2: 바뀐 파일명 출력
		 
		 
		 // for문 안에서 계속 새로운 new File 객체를 만드니까 메모리 낭비가 있을 것 같다 
		 // 객체의 주소만 수정할 수 있는 방법..??	
		 // 선생님이 써 주신 순서랑도 다름

		 */
		
		
		String PATH = "C:\\class\\java\\파일_디렉토리_문제\\음악 파일\\Music";
		
		//(1)
		File dir = new File(PATH);
		File[] list = dir.listFiles();
		
		for (int i=0 ; i<list.length ; i++) {									//(2)
			String renamePATH = String.format("%s\\[%03d]%s"
													, PATH
													, i+1
													, list[i].getName());

			File temp = new File(renamePATH);									//(3)
			list[i].renameTo(temp);

		}
		

		//새 File 배열로 다시 만들지 않으면 출력에 [001]~[100]이 반영되지 않는다..!
		//동기화 되는 건 아닌가 봄
		
		File[] listNew = dir.listFiles();
		
		for (File f : listNew) {
			System.out.println(f.getName());
		}
		
		
	}
}
