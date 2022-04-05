package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex63_File {

	public static void main(String[] args) {
		
		//Ex63_File.java
		
		/*
		 
		 1. Ex62: 파일/디렉토리 조작
		 2. Ex63: 파일 입출력
		 - 자바 프로그램 <-> (데이터) <-> 저장 장치
		 - 메모장
		 
		 저장 장치(HDD, SSD)
		 - 데이터 1,0으로 저장
		 - 데이터의 자료형 존재 X
		 
		 인코딩, Encoding
		 - 문자 코드(응용 프로그램의 데이터)를 부호화(1, 0) 시키는 작업
		 - 자바 프로그램("홍길동", String) -> 텍스트 파일("1010100010010")
		 
		 디코딩, Decoding
		 - 부호 데이터를 문자코드를 변환하는 작업
		 - 텍스트 파일("1010100010010") -> 자바 프로그램 ("홍길동", String)
		 
		 인코딩/디코딩 규칙
		 - 저장 장치 혹은 네트워크 상에서 데이터를 표현하는 규칙
		 1. ISO-8859-1
		 2. EUC-KR
		 3. ANSI
		 4. MS949
		 5. UTF-8
		 6. UTF-16
		 
		 ANSI(ISO-8559-1, EUC-KR, MS949)
		 1. 영어(숫자, 특수문자, 서유럽): 1byte
		 2. 한글(한자, 일본어 등): 2byte
		 
		 UTF-8 *** 이 인코딩을 사용한다. (국제 표준!)
		 1. 영어: 1byte
		 2. 한글: 3byte
		 
		 UTF-16
		 1. 영어: 2byte
		 2. 한글: 2byte
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		// ------ ▲ 쓰기 / 읽기 ▼ ------
		//m5();
		//m6();
		//m7();
		m8();
	}

	private static void m8() {
		
		try {
			
			File file = new File("C:\\class\\java\\JavaTest\\src\\com\\test\\java\\Ex28_String.java");
			
			if (file.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				int n = 1; //줄번호 변수
				
				while ((line = reader.readLine()) != null) {
					
					System.out.printf("%3d: %s\n", n, line);
					n++;
				}
				
				reader.close();
				
				
				
			} else {
				System.out.println("읽을 파일이 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m8");
			e.printStackTrace();
		}
		
	}

	private static void m7() {			//BufferedReader (줄 단위)

		//쓰기, 읽기에 가장 나은 도구들
		//파일 쓰기: FileWriter or BufferedWriter (큰 차이 X)
		//파일 읽기: BufferedReader
		
		
		try {
			
			//수업용: BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 			//키 입력
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\java\\file\\할일.txt"));	//파일 입력
			
			//파일의 한 줄을 읽는다
			//버퍼드리더로 무엇을 감싸냐에 따라 reader.readLine() 똑같이 써서 키보드 입력/파일 입력 제어
			//사용자 경험 유지 = 편하게
//			String line = reader.readLine();
//			System.out.println(line);
//			
//			line = reader.readLine();
//			System.out.println(line);
//
//			line = reader.readLine();
//			System.out.println(line);
//			
//			line = reader.readLine();	//null
//			System.out.println(line);

			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				System.out.println(line);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m7");
			e.printStackTrace();
		}
	}

	private static void m6() {			//FileReader (한글 O, 한 글자씩)			

		try {
			
			//FileWriter
			//FileReader
			
			FileReader reader = new FileReader("C:\\class\\java\\file\\할일.txt");
			
//			int code = reader.read();
//			System.out.println(code);

			int code = -1;
			
			while ((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m6");
			e.printStackTrace();
		}
		
	}

	private static void m5() {			//FileInputStream (한글 X, 한 글자씩)
		

		//파일 읽기
		try {
			
			//FileOutStream
			//FileInputStream
			
			FileInputStream stream = new FileInputStream("C:\\class\\java\\file\\data.txt");
			
//			int code = stream.read();	//A
//			System.out.println(code);	
//			
//			code = stream.read();		//B
//			System.out.println(code);
//			
//			code = stream.read();		//C
//			System.out.println(code);
//			
//			code = stream.read();		//D
//			System.out.println(code);
//			
//			code = stream.read();		//E
//			System.out.println(code);
//			
//			code = stream.read();		//-1
//			System.out.println(code);	//없다 = 문자 코드값의 시작은 0, -1을 return = 없다는 뜻

			int code = -1;
			
			while ((code = stream.read()) != -1) {
				
				System.out.println((char)code);
			}
			
			//FileOutputStream과 마찬가지로 한글은 깨진다
			//"파일"로부터 데이터를 1바이트 단위로 입력받는 스트림이기 때문에
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m4() {			//BufferedWriter 클래스
		
		try {
			
			//범용 도구
			// - 내부 설정에 따라 파일, 메모리, 네트워크 등 다양한 소스를 입, 출력할 수 있는 도구
			// - BufferedReader reader;
			// - BufferedWriter writer;
			
			//전용 도구
			// - 오로지 파일을 대상으로 입, 출력할 수 있는 도구
			// - FileReader reader;
			// - FileWriter writer;

			
			//객체를 만들 때 번거로움은 있지만,
			//서로 다른 클래스(전용 도구)를 감싼다 -> 사용법을 통일시켜 주는 역할을 한다는 장점!
			//기능은 전용 도구와 거의 같다
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\java\\file\\list.txt"));
			
			writer.write("안녕하세요.");
			writer.newLine(); //writer.write("\n");
			writer.write("홍길동입니다.");
			
			writer.close();
			
			System.out.println("쓰기 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {			//FileWriter 예제] 콘솔 버전 메모장

		//메모장 쓰기 > 콘솔 버전
		
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("저장할 파일명: ");
			String filename = scan.nextLine(); //reader.readLine()
			
			FileWriter writer = new FileWriter("C:\\class\\java\\file\\" + filename + ".txt");
			
			while (true) {
				System.out.print("입력: ");
				String line = scan.nextLine();
				
				if (line.equals("exit")) {
					break;
				}
				
				writer.write(line); //한 줄 입력 > 한 줄 쓰기
				writer.write("\n");
			}
			
			//객체를 생성했다 -> 닫아서 마무리, 자원 해제 코드, Clean-up Code
			scan.close();
			writer.close();
			
			System.out.println("쓰기 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {			//FileWriter 클래스
		
		//쓰기 스트림
		try {
			
			FileWriter writer = new FileWriter("C:\\class\\java\\file\\member.txt", true);
			
			writer.write("\n");
			writer.write("홍길동");
			writer.write("\n");
			writer.write("아무개");
			writer.write("\n");
			writer.write("하하하");
			
			writer.close();
			//stream은 닫으면 끝, 닫힌 stream에 다시 write("") 시도 시 error... 더 입력하려면 다시 객체 생성부터
			
			FileWriter writer2 = new FileWriter("C:\\class\\java\\file\\member.txt");
			
			writer2.write("다시 열어서 덮어쓰기");
			
			writer2.close();
			
			System.out.println("종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {			//FileOutputStream 클래스
		
		//파일 입출력
		
		//쓰기 > 파일 출력 ("파일"로 데이터를 1바이트 단위로 출력하는 스트림)
		// - 스트림 생성(도구)
					
		//쓰기 스트림 객체
		//데이터를 하드디스크에 저장한다
		//try catch 안 하면 외부 파일을 가져오므로 오류가 생길 수 있다고 경고 뜸

		
		
		//FileOutputStream 클래스
		//한 글자씩 써야 하므로 불편해서 잘 사용되지 않는 클래스
		
		//1. 생성 모드(=덮어쓰기), Create Mode
		// - 기본 방식, 더 많이 사용한다
		//	a. 파일이 존재하지 않으면 자동으로 생성한다.
		//	b. 항상 파일을 덮어쓰기한다.
		
		//2. 추가 모드(=이어쓰기), Append Mode
		//	a. 파일이 존재하지 않으면 자동으로 생성한다.
		//	b. 파일이 존재하면 기존 내용은 그대로 두고, 추가로 데이터를 저장한다.
		
		try {
		
			File file = new File("C:\\class\\java\\file\\data.txt");
			
			//스트림 열기
			// - 단점: 바이트 쓰기 단위(1byte) -> 한글을 쓰면 깨진다
			//생성 모드는 매개변수(file) 혹은 (file, false)
			//추가 모드는 매개변수(file, true)
			FileOutputStream stream = new FileOutputStream(file);
			
			//데이터 기록
			//stream.write(68); //문자 코드값
			//stream.write(69);
			//stream.write(70);
			//stream.write('가'); //깨진다
			
			String txt = "Hello~ Hong~";
			
			for(int i=0 ; i<txt.length() ; i++) {
				stream.write(txt.charAt(i));
			}
			
			//스트림 닫기
			//- 닫지 않으면?
			//		-> 기록한 데이터가 저장이 되지 않는다
			//		-> 잠긴 파일이 된다 (word파일 누군가 수정 중이면 열리지 않는 것처럼)
			stream.close();
			
			System.out.println("종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
