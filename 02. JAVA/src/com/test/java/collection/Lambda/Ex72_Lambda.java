package com.test.java.collection.Lambda;

public class Ex72_Lambda {

	public static void main(String[] args) {
		
		//com.test.java.lambda > Ex72_Lambda.java
		
		/*
		 
		 람다식, Lambda Expression
		 - 함수형 프로그래밍 방식 지원하는 표현식
		 - 람다식을 사용하면 코드가 간결해진다
		 - 자바 > 컬렉션(배열) 조작을 위해서 제공
		 - 자바의 메소드 표현
		 - 람다식은 매개변수를 가지는 코드블럭이다. (=메소드)
		 - 자바의 람다식은 반드시 인터페이스를 사용해 만든다 (************)
		 - 자바의 람다식은 익명 객체를 만드는 방법을 간소화시킨 기술이다. (*****)
		 

		 
		 
		 람다식 형식 
		 - 인터페이스 변수 = 람다식(람다 객체라고도 부름);
		 - ex) MyInterface m1 = () -> {};
		 
		 - (매개변수) -> {실행코드}
		 - a. (매개변수) : 메소드의 매개변수 리스트와 동일
		 - b. -> (화살표, Arrow) : 코드블럭 호출 역할
		 - c. {실행 블럭} : 메소드의 구현부(body)
		 
		 */
		
		//요구사항] MyInterface를 구현한 객체를 1개 만드시오.
		
		//Case 1. 클래스 선언 + 객체 생성
		MyInterface m1 = new MyClass();
		m1.test();
		
		
		//Case 2. 익명 객체 생성
		MyInterface m2 = new MyInterface() {

			@Override
			public void test() {
				System.out.println("익명 클래스 객체에서 구현한 메소드");
			}
			
		};
		m2.test();
		
		
		//Case 3. 람다식
		//람다식 == 메소드(*** 인터페이스로부터 상속받아 재정의한 메소드!!!)
		MyInterface m3 = () -> { System.out.println("람다식으로 만든 객체에서 구현한 메소드"); };
		m3.test();
		
		
		
		
		
		
		//익명 객체의 (추상)메소드 형식에 따라...
		
		
		//매개변수 X, 반환값 X
		NoParameterNoReturn pr1 = new NoParameterNoReturn() {
			@Override
			public void call() {
				System.out.println("pr1");
			}
		};
		
		pr1.call();
		
		
		NoParameterNoReturn pr2 = () -> {
			System.out.println("pr2");
		};
		
		pr2.call();
		
	
		//코드 블럭 안에 구현부 내용이 한 줄밖에 없으면? {} 생략 가능
		NoParameterNoReturn pr3 = () -> System.out.println("pr3");
		pr3.call();
		
		
		
		
		//매개변수 O, 반환값 X
		//매개변수의 자료형과 소괄호까지도 생략 가능
		ParameterNoReturn pr4 = num -> System.out.println(num);
		
		pr4.call(100);
		pr4.call(200);
		pr4.call(300);

		
		
		//매개변수 여러개, 반환값 X
		//매개변수가 여러 개면 자료형 생략 가능, 소괄호 생략 불가
		MultiParameterNoReturn pr5 = (name, num) -> System.out.printf("이름: %s, 나이: %d\n", name, num);
		
		pr5.call("김승연", 27);
	
		
		
		//매개변수 X, 반환값 O
		//실행문에 return문만 적혀 있을 경우, {}, return 생략 가능!
		NoParameterReturn pr6 = () -> { return 100; };
		
		System.out.println(pr6.call());
		
		NoParameterReturn pr7 = () -> 200;
		
		System.out.println(pr7.call());
	
	}
}


interface MyInterface {
	void test();
	
}

class MyClass implements MyInterface {

	@Override
	public void test() {
		
		System.out.println("실명 클래스 객체에서 구현한 메소드");
		
	}
	
}


interface NoParameterNoReturn {
	void call();
}


interface ParameterNoReturn {
	void call(int num);
}


interface MultiParameterNoReturn {
	void call(String name, int age);
}

interface NoParameterReturn {
	int call();
}