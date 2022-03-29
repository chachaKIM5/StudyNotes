package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class Ex53_Object {

	public static void main(String[] args) {
		
		//Ex53_Object.java
		
		//업캐스팅
		SSS s1 = new SSS();
		SSS s2 = new TTT(); //업캐스팅
		
		
		Object o1 = new Object();
		Object o2 = new SSS(); //가능, 업캐스팅
		Object o3 = new TTT(); //가능, 업캐스팅, 손자 -> 할아버지

		Date d4 = new Date();
		Object o4 = new Date();
		Object o5 = Calendar.getInstance();
		o4 = Calendar.getInstance();
		
		Object o6 = new BufferedReader(new InputStreamReader(System.in));
		Object o7 = new G304();
		Object o8 = 10;
		o8 = 20;
		o8 = 30;
		//o8 = "홍길동"; (X)
		
		
		//*** Object 변수는 이 세상 모든 것들을 담을 수 있다! > 만능 주머니!
		//Object의 장점
		//1. 모든 걸 담을 수 있다.
		
		//Object의 단점
		//1. 다운 캐스팅이 필요하다.
		//2. 다운 캐스팅 과정에서 원래 자료의 자료형을 유추하기가 힘들다.
		System.out.println(o4); //마우스 올려보면? Object
								//Object o4 선언을 찾아보고 Date라고 생각?
								// > 중간에 o4=Calendar로 수정함... o4의 자료형은 무엇일까? 못 찾음
		System.out.println(d4); //Date
		//Date temp = (Date)o4; //오류

		
		System.out.println();
		System.out.println();
		
		//Object 변수
		//1. 모든 걸 담을 수 있지만, 처음에 무언가를 담으면 앞으로는 그 자료형만 담는다 (*****)
		//		- 위처럼 Date를 넣었다가 Calendar를 넣었다가...? > 혼란
		
		
		//모든 자료형을 Object에 담을 수 있었던 이유 = 업캐스팅
		//업캐스팅의 전제조건 = 상속 관계에 있는 클래스끼리
		Object o10 = new SSS();
		
		//100은 값형 데이터 = 클래스가 아님..! 어떻게 참조형 변수에 들어갔을까?
		//껍데기는 값형 데이터를 참조형 변수에 넣은 것
		//실제로는 Integer 객체를 참조형 변수에 넣은 것
		
		//박싱(Boxing), 오토 박싱 = 값형 데이터를 자동으로 객체로 만드는 작업
		Object o11 = 100;
		Object o12 = new Integer(10);
		
		System.out.println(o11);
		System.out.println(o11.toString());
		
		//System.out.println(o11 * 2);
		//일종의 다운캐스팅
		//Boxing에 의해 Object 변수가 된 데이터를, 원래 값형 데이터로 자료형 변환해 다시 꺼낸다
		//언박싱(Unboxing)
		System.out.println((int)o11 * 2);
		System.out.println((Integer)o11 * 2);
		
		
		int a = 10;		//비용 보통
		Object b = 20;	//비용 비쌈
		
		
	
		
		
	} //main
} //Ex53



class SSS { //extends Object 생략
	
}

class TTT extends SSS {
	
}