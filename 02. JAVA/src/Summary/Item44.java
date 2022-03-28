package com.test.java;

public class Item44 {

	public static void main(String[] args) {
		
		//[SUMMARY] static, static 변수, 정적 변수, 클래스 변수, 공용 변수, 정적 생성자 (2022. 3. 27. 오후 10:29:41)
		
		/*
		
		static 키워드: 모든 객체의 공통된 특성, 멤버 변수와 멤버 메소드에 붙여 사용 

		static 변수(공용 변수)
		- 하나의 클래스로부터 만들어진 모든 객체가 공통으로 가지는 데이터를 저장하는 변수
		
		정적 생성자: static 변수만을 초기화하는 역할 
		
		*/
		
		//-- 정적 생성자의 정적 변수 school 초기화 ▼ -- 
		Student s1 = new Student();	
		Student s2 = new Student();	
		Student s3 = new Student();	
		
		System.out.println(s1.info()); //학교: 역삼 중학교
		System.out.println(s2.info()); //학교: 역삼 중학교
		System.out.println(s3.info()); //학교: 역삼 중학교

		//-- Setter로 정적 변수 school 값 바꾸기 ▼ --
		Student.setSchool("원미 중학교");
		
		System.out.println(s1.info()); //학교: 원미 중학교
		System.out.println(s2.info()); //학교: 원미 중학교
		System.out.println(s3.info()); //학교: 원미 중학교
		
	}
}


class Student {
	
	private static String school;

	static {
		Student.school = "역삼 중학교";	
	}

	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;
	}

	
	public String info() {
		
		return String.format("학교: %s"
				//, this.school (X)
				, Student.school);
	}
}