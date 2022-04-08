package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex69_LinkedList {
	
	public static void main(String[] args) {
	
		//Ex69_LinkedList.java
	
		//m1();
		//m2();
		m3();
	
	
	} //main

	private static void m3() {		//왜 인터페이스를 써야 할까?
		
		//인터페이스의 사용 예
		//인터페이스를 구현하는 객체는 참조 변수를 인터페이스로 만들어라
		
		//1. 참조변수의 자료형 수정 (ArrayList > LinkedList)
		//2. 생성자 수정
		
		//***** 리모콘	> AAA 건전지 (X) > 백셀 건전지 		> 다이소 건전지
		//***** 프로그램  > List 인터페이스 > ArrayList 객체	> LinkedList 객체
		
		
		//List<Integer> list = new ArrayList<Integer>(); //업캐스팅
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i=0 ; i<1000000 ; i++) {
			list.add(i);
		}
		
		System.out.println(list.size());
		
		//1년 뒤...
		//유지보수 or 기능 추가
		for (int i=0 ; i<5000 ; i++) {
			list.remove(0); //Shift 발생
		}
		
		System.out.println(list.size());
		
		
	}
	

	private static void m2() {		//ArrayList와 LinkedList의 실제 속도 비교
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		long begin = 0, end = 0;
		
		
		
		
		//1. 순차적으로 데이터 추가하기, Append
		System.out.println("[순차적으로 데이터 추가하기]");
		
		//ArrayList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<1000000 ; i++) {
			list1.add(i); //배열 끝에 추가
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업에 걸린 시간: %,dms\n", end - begin);
		
		//LinkedList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<1000000 ; i++) {
			list2.add(i); //배열 끝에 추가
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업에 걸린 시간: %,dms\n", end - begin);
		System.out.println();
		
		
		
		//2. 데이터 삽입하기, Insert
		System.out.println("[데이터 삽입하기]");
		
		//ArrayList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<10000 ; i++) {
			list1.add(0, i); //항상 맨 앞에 추가, 모든 배열 요소가 shift 발생
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업에 걸린 시간: %,dms\n", end - begin);
		
		
		//LinkedList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<10000 ; i++) {
			list2.add(0, i); //항상 맨 앞에 추가
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업에 걸린 시간: %,dms\n", end - begin);
		System.out.println();
		
		
		
		//3. 데이터 삭제하기, Delete
		System.out.println("[데이터 삭제하기]");
		
		//ArrayList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<10000 ; i++) {
			list1.remove(0); //0번 방 데이터 삭제, 나머지 데이터 모두 shift 발생
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업에 걸린 시간: %,dms\n", end - begin);

		
		//LinkedList
		begin = System.currentTimeMillis();
		
		for (int i=0 ; i<10000 ; i++) {
			list2.remove(0); //0번 방 데이터 삭제
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업에 걸린 시간: %,dms\n", end - begin);
		System.out.println();
		
		
		
		
		//4. 순차적으로 데이터 삭제하기
		System.out.println("[순차적으로 데이터 삭제하기]");
		
		//ArrayList
		begin = System.currentTimeMillis();
		
		for (int i=list1.size() - 1 ; i>=0 ; i--) {
			list1.remove(i); //마지막 방 데이터 삭제 > 끝까지 다 삭제, shift 발생 X
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업에 걸린 시간: %,dms\n", end - begin);
		
		//LinkedList
		begin = System.currentTimeMillis();
		
		for (int i=list2.size() - 1 ; i>=0 ; i--) {
			list2.remove(i); //마지막 방 데이터 삭제 > 끝까지 다 삭제, shift 발생 X
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업에 걸린 시간: %,dms\n", end - begin);
		
	}

	private static void m1() {		//List > LinkedList
		
		//Collection(I) > List(I) > ArrayList(C), LinkedList(C)
		
		//ArrayList vs LinkedList
		// - 같은 Interface를 상속하고 같은 List 컬렉션, 사용법이 아주 유사하다
		// - But 내부 구조가 다르다
		
		//물리적 구조 + 사용법(인터페이스)
		//Array + List
		//Linked + List
		
		//Hash + Map
		//Tree + Set
		
		//Hash + Set
		//Tree + Set
		
		
		
		//LinkedList의 종류
		//1. LinkedList: 일방 통행
		//2. Double LinkedList: 양방향
		//3. Double Circular LinkedList: 양방향 + 처음~끝 연결 > 현재 자바의 LinkedList
		
		
		//ArrayList
		// - 모든 컬렉션 중에서 요소에 접근하는 속도가 가장 빠르다
		// - 요소의 삽입/삭제에 대한 비용이 많이 든다(느리다), Shift 발생 (*****)
		
		//LinkedList
		// - 요소에 접근하는 속도가 느리다(특히 뒤에 있는 요소일수록...!)
		// - 요소 삽입/삭제에 대한 비용이 적다(빠르다), Shift 불필요 (*****)
		
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		//Arrays
		list1.add(100);
		list1.add(200);
		list1.add(300);
		System.out.println(list1.size());
		System.out.println(list1);
		
		//Linked
		list2.add(100);
		list2.add(200);
		list2.add(300);
		System.out.println(list2.size());
		System.out.println(list2);
	}
}
