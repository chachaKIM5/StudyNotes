package com.test.java;

public class Ex29_String {

	public static void main(String[] args) {
		
		//Ex29_String.java
		
		//1. 메모리의 공간은 한 번 할당되면 더 이상 늘리거나 줄일 수 없다
		//2. "문자열은 불변(Immutable)이다." > 한번 만들어진 문자열을 절대 수정할 수 없다
		//3. 문자열은 참조형이다
		
		
		//자바 자료형
		//1. 값형
		// - 값이 변경되어도 공간의 크기는 변화가 없다.
		//2. 참조형
		// - 값이 변경되면 공간의 크기가 변한다.
		
		
		//m1();
		m2();
		
		
		
		
		
		
		
		
	} //main

	private static void m2() {
		
		//String vs StringBuilder
		// - 문자열
		
		String s1 = "홍길동"; 				//문자열 리터럴 사용("") > 특혜
		String s3 = new String("홍길동"); 	//문자열의 원래 모습
		//s1과 s3는 완전히 같다
		StringBuilder s2 = new StringBuilder("홍길동"); //참조형의 기본 코드
		//s1,s3과 s2는 거의 비슷하다
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		
		System.out.println(s1.length());
		System.out.println(s2.length());
		System.out.println(s3.length());
		
		
		//StringBuilder와 기존 String과의 차이
		//장점: 수정 작업에 강하다!
		//- 속도가 빠르다
		//- 메모리 점유율이 낮아진다(쓰레기 ↓)
		
		//일반적인 문자열 작업: String 사용
		//하드한 수정 작업 > StringBuilder 사용
		
		
		//같은 수정 작업을 String과 StringBuilder로 해보기
		//String
		long begin = System.nanoTime();
				
		String txt1 = "홍길동";
		
		for (int i=0 ; i<100000 ; i++) {
			txt1 = txt1 + "."; //쓰레기가 많이 나오는 수정 작업
		}
		
		long end = System.nanoTime();
	
		System.out.println(txt1.length());
		System.out.println(end - begin + "ns"); //대략 3초
 		
		
		
		//StringBuilder
		begin = System.nanoTime();
		
		StringBuilder txt2 = new StringBuilder("홍길동");
		
		for (int i=0 ; i<100000 ; i++) {
			txt2.append(".");	//txt1 = txt1 + "."; 과 같은 코드
		}
		
		end = System.nanoTime();
		
		System.out.println(txt2.length());
		System.out.println(end - begin + "ns"); //대략 0.0032초, 훨씬 빠르다
	}

	private static void m1() {
		// *** 모든 값형은 어떤 데이터를 넣더라도 공간의 크기가 불변이다. ***
		
		int n1 = 10; //4byte
		int n2 = 20; //4byte
		
		n1 = 1000000000; //4byte
		
		String s1 = "홍길동"; //6byte
		String s2 = "아무개"; //6byte
		
		System.out.println(s1); //100번지
		
		s1 = "홍길동안녕하세요";
		
		System.out.println(s1); //300번지
		
		
		//코드상의 모든 문자열 리터럴은 메모리(힙)에 새로 생성된다.
		s1 = "참";
		
		System.out.println(s1);
		
		
		//자료형: int (값형)
		// - 값이 변경되어도 공간의 크기는 변화가 없다.
		int a = 10; 		//4byte
		int b = 20; 		//4byte
		int c = 10000000; 	//4byte
		
		
		//자료형: int[] (참조형)
		// - 값이 변경되면 공간의 크기가 변한다.
		int[] alist = new int[3];	//12byte
		int[] blist = new int[5];	//20byte
		int[] clist = new int[10];	//40byte
		
		
		//자료형 > String
		String t1 = "홍길동";			//6byte
		String t2 = "홍";			//2byte
		String t3 = "홍길동입니다.";	//14byte
		
		
		String txt = "홍길동";
		txt = "아무개";
		
		
		
		//같은 지역에 한해서 (같은 메소드 내에서만)
		//같은 상수가 나오면 메모리를 더 사용하지 않고 주소만 참조
		
		String m1 = "홍길동";
		String m2 = "홍길동";
		String m3 = "홍길동";
		
		
		String w1 = "홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. ";
	
		String w2 = "홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. ";
		
		String w3 = "홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. 홍길동입니다. 안녕하세요. 저는 자바를 배우는 학생입니다. ";
		
		
		
		
		//2. 문자열은 불변이다.
		String z1 = "홍길동";
		String z2 = "홍길동";
	
		z1 = "홍길남";
		//z2 = "홍길남"으로 바뀌면 안 되니까 수정X, 다시 "홍길남"을 만들어 z1에 참조
		
		
		
		
		
		//문자열을 대상으로 피해야 하는 행동 > 상황 파악
		//1. 문자열의 잦은 수정
		//	- 수정할 때마다 쓰레기(garbage)가 하나씩 만들어지기 때문에
		//2. 큰 문자열의 수정
		//	- 큰 문자열+점 하나만 추가하려고 해도 이미 만든 후 수정하려고 하면 크기가 큰 쓰레기가 생긴다
		String txt1 = "홍길동";
		
		
		//1. 문자열의 잦은 수정
		for (int i=0 ; i<100 ; i++) {
			txt1 = txt1 + "님"; //누적 > 수정 100번
		}
		
		System.out.println(txt1);
		System.out.println(txt1.length());

		
		
	}
}
