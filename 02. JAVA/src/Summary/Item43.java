package com.test.java;

public class Item43 {

	public static void main(String[] args) {
		
		//[SUMMARY] 생성자, 생성자 오버로딩, Constructor (2022. 3. 27. 오후 10:19:20)
		
		/*
		 
		 생성자: 객체가 생성될 때 딱 1번만 호출되는 객체 변수(static 변수) 초기화 메소드
		        매개변수를 다르게 해서 오버로딩 가능 (형식: this(매개변수))
		        
		 */
		
	}
}


//생성자, 생성자 오버로딩 예시

class Developer {
	
	private String name;
	private String language;


	//A
	public Developer() {
	
		//this.name = "익명";
		//this.language = "없음";
		//위 2줄 = C를 호출
		this("익명", "없음"); //C
	}

	
	
	//B
	public Developer(String name) {
		//this.name = name;
		//this.language = "없음";
		//위 2줄 = C를 호출
		this(name, "없음");
	}
	

	
	//C
	public Developer(String name, String language) {
		//이름 유효성 검사, 언어 유효성 검사 등...
		this.name = name;
		this.language = language;
	}
}