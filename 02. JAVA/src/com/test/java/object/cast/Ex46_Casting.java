package com.test.java.obj.cast;

public class Ex46_Casting {

	public static void main(String[] args) {
	
		//"com.test.java.obj.cast" > "Ex46_Casting.java"
		
		/*
		 
		 형변환, Type Casting
		 1. 값형 형변환, ValueType Casting
		 	- 값형끼리 형변환 (boolean 제외)
		  
		 
		 2. 참조형 형변환, Reference Type Casting
		 	- 참조형끼리 형변환
		 	
		 
		 참조형 형변환 
		 - 상속 관계를 갖는 클래스 간의 형변환 > 직계끼리 (방계는 불가능)
		 - A클래스 > B클래스
		 	
		 1. 업캐스팅, Up Casting
		 	- 암시적인 형변환
		 	- 자식 클래스 -> 부모 클래스
		 	- 100% 가능
		 	
		 2. 다운 캐스팅, Down Casting
		 	- 명시적인 형변환
		 	- 부모 클래스 -> 자식 클래스
		 	- 100% 불가능
		 	- 내부 조작한 후 가능
		 	
		 */
		
		
		//temp();

		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 10;
		c1.b = 20;
		c1.c = 30;
		c1.d = 40;
		
		
		Parent p2;
		Child c2;
		
		c2 = new Child();
		
		//복사
		//Parent = Child
		//암시적인 형변환
		//부모클래스 = 자식클래스
		//업캐스팅(***)
		//100% 가능 > 아주 안전한 형변환
		p2 = c2;
		//p2 = (Parent)c2; //원형, (Parent)는 써도 되고 안 써도 됨
		
		//복사 + 형변환 > 제대로 완료됐는지 검증? > 복사된 참조변수 > 모든 멤버 접근 테스트
		
		p2.a = 10;
		p2.b = 20;
		
		System.out.println(p2.a);
		System.out.println(p2.b);
		
		//안 보이는 c와 d는 중요하지 않다!
		
		

		Parent p3;
		Child c3;
		
		p3 = new Parent();
		
		
		//Child = Parent
		//명시적인 형변환
		//자식클래스 = 부모클래스
		//다운캐스팅
//		
//		c3 = (Child)p3; //원인 > 이 원인을 아예 불가능한 작업으로 취급하자 > 결론!
//		
//		//검증 > 복사본이 사용에 문제가 없는지?
//		
//		c3.a = 10; //O
//		c3.b = 20; //O
//		c3.c = 30; //X
//		c3.d = 40; //X
//		
//		System.out.println(c3.a);
//		System.out.println(c3.b);
//		System.out.println(c3.c);
//		System.out.println(c3.d);
		
		
		
		Child c4;
		Parent p4;
		
		c4 = new Child();
		
		//업캐스팅
		p4 = c4;
		
		
		
		Child c5;
		
		//다운캐스팅 > 100% 불가능 > 런타임 오류
		//class Parent cannot be cast to class Child
		c5 = (Child)p4;
		
		c5.a = 100;
		c5.c = 300;
		System.out.println(c5.a);
		System.out.println(c5.c);
		
	} //main
	
	private static void temp() {
		//cf)
//		System.out.println(t1); t1.toString()
//		
//		System.out.printf("%s", 10);
//		System.out.printf("%s", false);
//		System.out.printf("%s", 'Z');
//		
//		자동으로 toString() 호출

	}
} //Ex46



//참조형 형변환 > 상속 관계에 있는 직계 클래스끼리 가능


class Parent {
	public int a;
	public int b;
}

class Child extends Parent {
	public int c;
	public int d;
}


