package com.test.java.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Ex70_TreeSet {

	public static void main(String[] args) {
		
		//Ex70_TreeSet.java
		
		/*
		 
		 Set
		 - 순서가 없다
		 - 중복값을 가지지 않는다
		 
		 HashSet
		 
		 TreeSet
		 - 이진 트리 구조
		 
		 
		 */
		
		m1();
		
		
	}

	private static void m1() {		//HashSet과 TreeSet 비교하며 알아보기
		
		HashSet<Integer> set1 = new HashSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		
		set1.add(10);
		set1.add(30);
		set1.add(40);
		set1.add(50);
		set1.add(20);
		
		set2.add(10);
		set2.add(30);
		set2.add(40);
		set2.add(50);
		set2.add(20);
		
		
		//탐색
		Iterator<Integer> iter1 = set1.iterator();
		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		System.out.println();
		
		Iterator<Integer> iter2 = set2.iterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		
		System.out.println("HashSet 입력 결과: " + set1);
		System.out.println("TreeSet 입력 결과: " + set2);
		
		
		TreeSet<Integer> set3 = new TreeSet<Integer>();
		Random rnd = new Random();
		
		for (int i=0 ; i<10 ; i++) {
			set3.add(rnd.nextInt(100));	
		} //0~99사이의 값을 set3에 10번 넣기 > 중복값이 생기면 안 들어가므로... 최소 1, 최대 10개
		
		System.out.println(set3);
		System.out.println(set3.size());
		
		while (set3.size() < 20) {
			set3.add(rnd.nextInt(100));	
		} //위와는 다르게 무조건 값이 20개가 될 때까지 루프
		
		System.out.println();
		System.out.println(set3);
		System.out.println(set3.size());
		System.out.println();
		
		
		//TreeSet 고유 메소드
		//*** java의 모든 Index는 범위를 나타낼 때 시작 위치는 포함, 끝 위치는 미포함이다
		System.out.println(set3.first());		//first()
		System.out.println(set3.last());		//last()
		System.out.println(set3.headSet(30));	//headSet() 30 > 값 범위추출
		System.out.println(set3.tailSet(70));	//tailSet() 70 <= 값 범위추출
		System.out.println(set3.subSet(30, 70));//subSet() 30 <= 값 < 70
	}
}
