package com.test.java;

public class Item44 {

	public static void main(String[] args) {
		
		//[SUMMARY] static, static 변수, 정적 변수, 클래스 변수, 공용 변수 (2022. 3. 27. 오후 10:29:41)
		
		/*
		
		static 키워드: 모든 객체의 공통된 특성, 멤버 변수와 멤버 메소드에 붙여 사용 

		static 변수(공용 변수)
		- 하나의 클래스로부터 만들어진 모든 객체가 공통으로 가지는 데이터를 저장하는 변수
		
		*/
		
		
		Student.setSchool("역삼 중학교");
		Student s1 = new Student();	
		Student s2 = new Student();	
		Student s3 = new Student();	
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
	}
}


class Student {
	
	private static String school;

	
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