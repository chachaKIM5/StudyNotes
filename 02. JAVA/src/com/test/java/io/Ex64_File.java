package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex64_File {

	public static void main(String[] args) {
		
		//Ex64_File.java
		
		//m1();
		//m2();
		//m3();
		m4();
	}

	private static void m4() {				//m3을 ArrayList를 이용해 더 편하게
		
		ArrayList<User> list = new ArrayList<User>();
		
		//매개변수 전달 방식
		//1. Call by value
		//2. Call by reference: 참조형을 매개변수로 넘기면, 메소드에서 수정해도 반영된다
		//	 (load()에서 수정된 ArrayList를 반환할 필요 없는 이유)
		load(list);
		
		for (User u : list) {
			System.out.printf("%s. %s(%d세)\n"
										, u.getNo()
										, u.getName()
										, u.getAge());
		}
		
		System.out.println();
		
		for (User u : list) {
			if (u.getAge() >= 22) {
				System.out.printf("%s.%s(%d세)\n"
						, u.getNo()
						, u.getName()
						, u.getAge());
			}
		}
		
		
		//추가 요구사항] 데이터 수정
		//- 나이가 많은 사람을 표시
		//- 홍길동 > 홍길동(*)
		
		System.out.println();
		
		for (User u : list) {
			if (u.getAge() >= 22) {
				u.setName(u.getName() + "(*)");
				System.out.printf("%s.%s(%d세)\n"
						, u.getNo()
						, u.getName()
						, u.getAge());
			}
		}
		
		list.remove(2);
		
		//위 수정 사항을 메모리(배열) > 텍스트 파일에 반영하기
		save(list);
		
		
		
	}

	private static void save(ArrayList<User> list) {

		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MEMBER));
			
			//User 객체 1개 -> 1,홍길동,20 -> writer.write 처리
			
			for (User u : list) {
				writer.write(String.format("%s,%s,%d\n", u.getNo(), u.getName(), u.getAge()));
			}
			
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.save");
			e.printStackTrace();
		}
		
		
	}

	private static void load(ArrayList<User> list) {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				//1,홍길동,20
				String[] temp = line.split(",");
				
				//텍스트 파일의 1줄을 User 객체 1개로 만듦
				User user = new User(temp[0], temp[1], Integer.parseInt(temp[2]));
				
				list.add(user);
			}
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.load");
			e.printStackTrace();
		}
		
	}

	private static void m3() {				//한 번 읽은 reader를 다시 읽으려면 새 스트림 객체를 다시 생성
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			//데이터 파일 구조 > Scheme(스키마)
			//CSV
			//번호,이름,나이
			//1,홍길동,20
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
			}
			
			reader.close();
			
			System.out.println();
			//22세 이상 목록 다시 출력?
			//reader는 이미 끝까지 파일을 읽어서 다시 loop 돌리면 null만...
			//다시 출력하려면, 스트림 객체를 다시 생성하는 수밖에 > 생성 직후 커서는 BOF(Begin Of File)에 위치
			
			reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (Integer.parseInt(temp[2]) >= 22) {
					System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m3");
			e.printStackTrace();
		}
		
	}

	private static void m2() {							//파일 수정

		//파일 수정하기 (*****)
		// - 파일 입출력에는 수정이라는 행동이 없다.
		// - 덮어쓰기로 구현한다
		
		//1. 기존 내용을 출력한다
		//2. 내용의 일부를 수정한다
		//3. 저장한다
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.EDIT));
			
			System.out.println("[현재 내용]");
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				System.out.println(line);
			}
			
			reader.close();
			
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("[수정 내용]");
			
			String input = scan.nextLine();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.EDIT));
			
			writer.write(input);
			
			writer.close();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m2");
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {							//절대 경로와 상대 경로
		
		
		//읽고 쓰는 파일의 위치
		//1. 프로젝트 폴더 외부
		//2. 프로젝트 폴더 내부
		// - 관리 용이
		// - 프로젝트 위치 이동 > 파일 이동도 같이
		
		try {
			
			/*
			 
			 콘솔 명령어
			 c:\Users\in> _
			 현재 위치> 프롬프트
			 
			 1. dir
			 	- 현재 디렉토리의 목록(내용물) 보여준다
			 2. cd
			 	- change directory
			 	- cd 자식 폴더명
			 	- cd ..
			 		> 부모 폴더로 이동. 부모는 유일하므로 ".."으로 표현 가능
			 
				 자원 경로 표현법
				 1) 절대 경로
				  - 기준점: 절대 위치
				  - ex) 홍길동, A5열에 앉아 있는 사람
				  - C:\class\java\data.txt
				  
				 2) 상대 경로
				  - 기준점: 상대 위치
				  - ex) 나, 앞에 앉아 있는 사람
				  - .\data.txt: "."의 의미는 현재 이 폴더
				  - .\file\member.txt
			 
			 
			  
			 */
			
			
			
			File file = new File(".\\data\\data.txt"); //현재 폴더를 상대 경로로 적음
			//File file = new File("data\\data.txt"); //".\\" 생략 가능
			
			System.out.println(file.getAbsolutePath()); //절대 경로
			System.out.println(file.getPath());
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("테스트");
			
			writer.close();
			
			System.out.println("종료");
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m1");
			e.printStackTrace();
		}
		
	}
}



//번호, 이름, 나이
//1,홍길동,20

class User {
	
	private String no;
	private String name;
	private int age;
	
	public User(String no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	
	
}