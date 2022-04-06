package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Q03 {
	
	private static ArrayList<Student> list = new ArrayList<Student>();
	public static void main(String[] args) {
		
		//성적을 확인 후 합격자/불합격자 명단을 출력하시오.
		//합격 조건: 3과목 평균 60점 이상
		//과락 조건: 1과목 40점 미만
		//C:\class\java\파일_입출력_문제\성적.dat
		//(이름(Str), 국어성적(Int), 영어성적(Int), 수학성적(Int)이라.. HashMap을 어떻게 써야할지 모르겠다
		
		
		//Student 클래스 만들어서 ArrayList 배열에 넣기
		
		
		try {
			
			File file = new File("C:\\class\\java\\파일_입출력_문제\\성적.dat");	
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//성적을 각 Student 객체를 만들어 넣고, 그 객체를 ArrayList에 추가하는 메소드
				addStudent(line);
		
			}
			
			reader.close();
			
			
			
			
			System.out.println("[합격자]");
			
			for (Student s: list) {
				if (isPass(s)) {						//합격/불합격을 true, false로 반환하는 메소드
					System.out.println(s.getName());
				}
			}
			
		
			System.out.println("\n[불합격자]");
			
			for (Student s: list) {
				if (!isPass(s)) {
					System.out.println(s.getName());
				}
			}			
			

			
			
		} catch (Exception e) {
			System.out.println("Q03.main");
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	private static void addStudent(String line) {
		
		String[] data = line.split(",");
		
		list.add(new Student(data[0]
							, Integer.parseInt(data[1])
							, Integer.parseInt(data[2])
							, Integer.parseInt(data[3])));
		
	}





	public static boolean isPass(Student s) {
		
		s.setAvg((int)(s.getKor()+s.getEng()+s.getMath()) / 3);
		
		if (s.getAvg() < 60 || s.getKor() < 40
							|| s.getEng() < 40
							|| s.getMath() < 40) {
			
			return false;
		
		} else {
			
			return true;
		}
	}

}

class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int avg;
	
	
	public Student (String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public String getName() {
		return name;
	}


	public int getKor() {
		return kor;
	}


	public int getEng() {
		return eng;
	}


	public int getMath() {
		return math;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	public int getAvg() {
		return avg;
	}
	


}
