package com.test.java.obj.constructor;

public class Ex38_Constructor {

	public static void main(String[] args) {
		
	//Ex38_Constructor.java
		
		Developer d1 = new Developer();
		d1.info();
		
		Developer d2 = new Developer("홍길동");
		d2.info();
		
		Developer d3 = new Developer("아무개", "JAVA");
		d3.info();
		
		
		//A의 일은 B도 할 수 있다
		Developer d4 = new Developer("익명");
		d4.info();
		
		//C는 A도 B도 할 수 있다
		Developer d5 = new Developer("익명", "없음");
		d5.info();
		Developer d6 = new Developer("홍길동", "없음");
		d6.info();
		
		
		// >> -> 생성자들은 동등한 관계가 아니고, A < B < C이다
		//생성자는 객체 생성 시 한 번만 호출할 수 있지만, 예외적으로 생성자끼리는 호출 가능
		
		//생성자를 여러 개 생성(오버로딩)
		//- 대부분의 생성자가 비슷한 행동을 한다
		//- 중복 코드 발생 > 줄이자
		//- 다른 생성자를 호출하는 형태로 코드를 개선(this(); = 생성자 호출하는 표현)
		
	} //main
} //class


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
	
	//이때, public Developer(String language)는 생성할 수 없다
	//변수 name과 language의 자료형이 같기 떄문에 외부에서 구분할 수 없다 -> 오버로딩의 구현 조건
	
	
	//C
	public Developer(String name, String language) {
		//이름 유효성 검사, 언어 유효성 검사 등...
		this.name = name;
		this.language = language;
	}
	
	
	public void info() {
		
		System.out.println("이름: " + this.name);
		System.out.println("언어: " + this.language);
		System.out.println();
	}
}