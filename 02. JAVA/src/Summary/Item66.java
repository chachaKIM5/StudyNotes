package com.test.java;

import java.util.LinkedList;

public class Item66 {

	public static void main(String[] args) {
		
		//[SUMMARY] LinkedList (2022. 4. 9. 오전 12:09:13)
		
		/*
		 
		LinkedList
		 - ArrayList와 같은 Interface를 상속, 같은 List 컬렉션
		 - 비슷한 사용법 가지지만 내부 구조가 다른 컬렉션
		 - Double Circular LinkedList: 각 요소가 양방향 연결 + 처음~끝 연결
		 - 요소에 접근하는 속도가 느리다 (특히 뒤에 있는 요소일수록, 앞의 요소들을 거쳐가므로)
		 - 요소 삽입/삭제에 대한 비용이 적다(빠르다), Shift 불필요 (********)
		 
		 
		 *** 삽입/삭제가 잦을 것이라고 예상되면 LinkedList, 아니면 ArrayList
			- 인터페이스 활용
    		List<Integer> list = new ArrayList<Integer>();의 형태로 만들어 놓고(업캐스팅!)
    		List<Integer> list = new LinkedList<Integer>();와 같이 수정해 써도 된다
		 
		 
		 */
		
		
		LinkedList<Integer> list = new LinkedList<Integer>();


		//순차적 데이터 추가: ArrayList보다 느리다
		for (int i=0 ; i<1000000 ; i++) {
				list.add(i); //배열 끝에 추가
		} 

		//데이터 삽입: ArrayList보다 빠르다
		for (int i=0 ; i<10000 ; i++) {
				list.add(0, i); //항상 맨 앞에 추가
		}

		//데이터 삭제: ArrayList보다 빠르다
		for (int i=0 ; i<10000 ; i++) {
				list.remove(0); //0번 방 데이터 삭제
		}

		//순차적 데이터 삭제: ArrayList보다 느리다
		for (int i=list.size() - 1 ; i>=0 ; i--) {
				list.remove(i); //마지막 방 데이터 삭제 > 끝까지 다 삭제, shift 발생 X
		}
		
	}
}
