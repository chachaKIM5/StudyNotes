package com.test.java.obj.stereo;

public class Ex54_Generic {

	public static void main(String[] args) {
		
		//Ex54_Generic.java
		
		Item i1 = new Item();
		//Item is a raw type. References to generic type Item<T> should be parameterized
		
		Item<String> i2 = new Item<String>();
		i2.c = "문자열";
		
		
		//*** 값형을 사용할 수 없다 -> 반드시 참조형(클래스)만 가능
		// byte -> Byte 참조형 표현으로
		// short -> Short
		// int -> Integer
		// double -> Double
		Item<Integer> i3 = new Item<Integer>();
		i3.c = 30;
		
		
		Pen<Boolean> p1 = new Pen<Boolean>();
		
		p1.a = true;
		p1.b = false;
		p1.c = true;
		
		
		Desk<String> d1 = new Desk<String>();

		d1.a = "문자열";
		d1.test("문자열");
		String result = d1.get();

		
		Cup<String, Integer> c1 = new Cup<String, Integer>("문자열", 100);
		
		Cup<Double, Boolean> c2 = new Cup<Double, Boolean>(3.14, true);
		
		System.out.println(c1.getA());
		System.out.println(c1.getB());
		System.out.println(c2.getA());
		System.out.println(c2.getB());
		
	} //main
} //Ex54


//int a = 10; > 데이터 담는 공간
//T = int; > 자료형 담는 공간
//T = String;
//T = Boolean;


//제네릭 클래스
// - T: 타입 변수 > 자료형을 저장하는 변수
// - <>: 인자 리스트(메소드의 소괄호) 같은 역할
class Item<T> {
	
	public int a;
	public int b;
	public T c; //클래스 설계 당시에는 c의 자료형이 결정되지 않음 > 런타임, 객체 생성 시 결정
	
}


class Pen<T> {
	
	public T a;
	public T b;
	public T c;
	
}


class Desk<T> {
	
	public T a; //멤버 변수의 자료형
	public void test (T a) {  //멤버 메소드 매개변수의 자료형	
		T b; 				  //멤버 메소드 안 지역변수의 자료형 > 비권장...
	}
	
	public T get() {          //멤버 메소드 반환 타입의 자료형
		return this.a;
	}
	
}


class Cup<T,U> {
	
	public T a;
	public U b;
	
	public Cup(T a, U b) {   //생성자. 생성자에는 <> 없어도 됨
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return this.a;
	}
	
	public U getB() {
		return this.b;
	}
}