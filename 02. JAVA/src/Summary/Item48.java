package com.test.java;

public class Item48 {

	public static void main(String[] args) {
		
		//[SUMMARY] final 키워드 (2022. 3. 28. 오후 11:09:39)
		
		/*
		 
		 - final 키워드 적용 가능 범위
    		1. 변수 적용
    			: 상수 만들기, 상수 이름은 반드시 대문자로
    		2. 메소드 적용
    			: 자식 클래스에서 부모 클래스의 메소드를 재정의할 수 없게 한다 (오버라이딩 막기)
    		3. 클래스 적용 
    			: 자식 클래스의 상속조차 불가능하도록 막기 
    			  터미널 클래스 = Leaf Node = 더 이상 상속할 수 없는 마지막 클래스
		  
		 */
		
		
		//1. 변수 적용
		User u1 = new User();
		System.out.println(u1.GENDER); //2
		
		User u2 = new User();
		System.out.println(u2.GENDER); //2
		
		User u3 = new User();
		System.out.println(u3.GENDER); //2
		
		
	}
}


//1. 변수 적용
class User {
	
	public int age;
	final public static int GENDER = 2;
	//final이 붙은 상수는 선언+초기화 동시에 하는 경우가 많다
}




//2. 메소드 적용
class FinalParent {
	final public void test() {
		System.out.println("final 메소드");
	}
}

class FinalChild extends FinalParent {
//	public void test() {                      //오류 메시지
//		System.out.println("메소드 재정의")      //: Cannot override the final method from FinalParent
//	} 
}




//3. 클래스 적용
final class FinalClass {
}

//class FinalChildClass extends FinalClass {
//}

//오류 메시지
//: The type FinalChildClass cannot subclass the final class FinalClass