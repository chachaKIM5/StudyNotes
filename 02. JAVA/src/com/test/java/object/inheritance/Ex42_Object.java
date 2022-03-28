package com.test.java.obj.inheritance;

public class Ex42_Object {

	public static void main(String[] args) {
		
		//Ex42_Object.java
		
		//Object 클래스
		//- 사용자가 만드는 모든 클래스는 자동으로 Object 클래스를 상속받는다.
		//- 모든 클래스는 근원 클래스, Root Class
		//- 모든 클래스는 Object 클래스로부터 파생된다. > 단군 할아버지
		//- Object 멤버는 모든 클래스에게 상속된다. > 모든 클래스들에 필요하다고 생각하는 공통 기능을 구현해 놓았다
	
		
		Object o1 = new Object();
		//위처럼 객체로 만들 수는 있지만, 직접 Object 객체 생성할 일은 거의 없다
		//Object는 자식 클래스에 물려줄 기능들을 위해 존재하므로!
		
		//Class Object is the root of the class hierarchy.
		//Every class has Object as a superclass.
		//All objects,including arrays, implement the methods of this class.
		
		int[] list = new int[5];
		
		Test t1 = new Test();
		
		
	}
}


class Test extends Object {
	
	public int a;
	public int b;
	
}


class Other extends Test {
	
	public int c;
	public int d;

}