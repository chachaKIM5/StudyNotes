package com.test.java.question.constructor;

public class Q01 {

	public static void main(String[] args) {
		
		//학생1
		Student s1 = new Student();
		System.out.println(s1.info());
		
		//학생2
		Student s2 = new Student("홍길동", 13);
		System.out.println(s2.info());
		
		//학생3
		Student s3 = new Student(3, 10, 30);
		System.out.println(s3.info());

		//학생4
		Student s4 = new Student("아무개", 12, 1, 5, 11);
		System.out.println(s4.info());

	} //main
} //class


class Student {
	
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;

	
	public Student() {
		this("미정", 0, 0, 0, 0);
		
	}
	
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number);
	}
	
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;

	}
	
	
	public String info() {

		String output = String.format("%s(나이: %s, 학년: %s, 반: %s, 번호: %s)"
								, this.name
								, (this.age == 0 ? "미정" : String.valueOf(this.age))
								, (this.grade == 0 ? "미정" : String.valueOf(this.grade))
								, (this.classNumber == 0 ? "미정" : String.valueOf(this.classNumber))
								, (this.number == 0 ? "미정" : String.valueOf(this.number)));
		
		return output;
	}
}


