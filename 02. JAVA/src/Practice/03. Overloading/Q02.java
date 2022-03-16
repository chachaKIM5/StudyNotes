package com.test.java.question.overloading;

public class Q02 {

	public static void main(String[] args) {
		
	/*
	
	프로세스
	 1. 결과를 출력하는 메소드 4개 선언
	 	(메소드명 position, 매개변수 name1 ~ name1, name2, name3, name4)
	 2. 메소드 바디는 println(사원: name) println(대리: name) ~
	 3. 메인 메소드에서 position 호출	

	 */
	
	position("홍길동");
	position("홍길동", "유재석");
	position("홍길동", "유재석", "박명수");
	position("홍길동", "유재석", "박명수", "정형돈");
		
	} //main

	public static void position(String name1) {	
	System.out.println("사원: " + name1);
	System.out.println();
	
	}

	public static void position(String name1, String name2) {	
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
		System.out.println();
		
	}

	public static void position(String name1, String name2, String name3) {	
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
		System.out.println("과장: " + name3);
		System.out.println();
		
	}

	public static void position(String name1, String name2, String name3, String name4) {	
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
		System.out.println("과장: " + name3);
		System.out.println("부장: " + name4);
		System.out.println();
		
	}
}