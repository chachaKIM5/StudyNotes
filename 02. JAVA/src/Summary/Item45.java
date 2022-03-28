package com.test.java;

public class Item45 {

	public static void main(String[] args) {
		
		//[SUMMARY] 상속 (2022. 3. 28. 오후 10:53:12)
		
		
		/*
		 
		 상속의 기본 형태
		 class 자식 클래스명 extends 부모 클래스명 {
		 }
		  
		 */
		
		DDD d1 = new DDD();
		System.out.println(d1.a); //10
		System.out.println(d1.b); //20
		System.out.println(d1.c); //30
		System.out.println(d1.d); //40
	}
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