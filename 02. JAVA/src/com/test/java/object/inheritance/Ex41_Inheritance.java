package com.test.java.obj.inheritance;

public class Ex41_Inheritance {

	public static void main(String[] args) {
		
		//"com.test.java.obj.inheritance" > "Ex41_Inheritance.java";
		
		
		/*
		 
		 상속, Inheritance
		 - 부모가 가지는 재산을 자식에게 물려주는 행동
		 - 부모 클래스가 가지는 멤버를(변수, 메소드) 자식 클래스에게 물려주는 행동
		  
		 
		 상속을 왜 하는지?
		 - 자식 클래스가 구현해야 하는 멤버(코드)를 직접 구현하지 않고,
		   부모 클래스로부터 물려받아 자기가 직접 구현한 것처럼 사용하기 위해
		 - 비용 절감, 코드 재사용 (*****)
		 
		 
		 상속관계에 있는 클래스 호칭
		 - 부모 클래스(Parent class, Super class <- 자식 클래스(Child class, Serve class)
		 - 기본 클래스 <- 확장(파생) 클래스
		 
		 
		 * 수업 외 의문점: 부모 클래스의 private 멤버 변수도 자식 클래스에 상속될까?
		  > test 결과 = X
		 
		 */
		
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 30;
		c1.b = 40;
		c1.ccc();
		c1.d = 50;
		c1.eee();
		
		
		DDD d1 = new DDD();
		System.out.println(d1.a);
		System.out.println(d1.b);
		System.out.println(d1.c);
		System.out.println(d1.d);
		
		
		
		
	}
}


class Parent {
	public int a;
	public int b;
	public void ccc() {
		System.out.println("메소드");
	}
}


class Child extends Parent {
	public int d;
	public void eee() {
	}
	
}


class Son extends Parent {
	public int f;
	public void ggg() {
		
	}
}


class Daughter extends Parent {
	public int h;
	public void iii() {
		
	}
	
}

class GrandChild extends Daughter {
	
}



class AAA {
	public int a = 10;
}

class BBB extends AAA {
	public int b = 20;
}

class CCC extends BBB {
	public int c = 30;
}

class DDD extends CCC {
	public int d = 40;
}