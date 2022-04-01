package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ex61_HashSet {

	public static void main(String[] args) {
	
		//Ex61_HashSet.java
		
		
		/*
		 
		 1. List
		 	- 순서가 있는 데이터의 집합 (*************) List만의 특징
		 	- 첨자(방 번호)
		 	- 데이터 중복을 허용한다
		 
		 2. Set
		 	- 순서가 없는 데이터의 집합
		 	- 식별자가 없다. > 방과 방을 구분할 수 없다
		 	- 데이터 중복을 허용하지 않는다 (****************) Set만의 특징
		 
		 3. Map
		 	- 순서가 없는 데이터의 집합
		 	- 키 + 값으로 관리하는 자료구조 (******************) Map만의 특징
		 	- 데이터 중복을 허용한다
		 		 
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
	}

	private static void m5() {

		//HashSet의 탐색 (읽기)
		// - 방을 구분할 수 없기 때문에(식별자 X) 불편함
		// - Iterator 사용 > 컬렉션 탐색 도구
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("마우스");
		set.add("키보드");
		set.add("모니터");
		set.add("노트북");
		set.add("패드");
		
		Iterator<String> iter = set.iterator();
		
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());

//		System.out.println(iter.hasNext()); //set 안에 가져올 데이터가 있는지?
//		System.out.println(iter.next());	//가져온다 (소비)
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		
	}

	private static void m4() {
		
		//p1, p3의 상태가 동일함
		// > 하지만 다른 사람
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("아무개", 25);
		Person p3 = new Person("홍길동", 20);
		
		//값형의 비교는 ==로 한다
		//모든 참조형의 비교는 equals()로 한다 > 문자열 포함
		System.out.println(p1.equals(p3)); //false가 나오는 이유?
		System.out.println(p1.hashCode()); //1556956098
		System.out.println(p3.hashCode()); //1252585652
		
		//p1과 p3를 같은 사람으로 취급할 수 있는 방법?
		
		
		
		//*** HashSet이 중복값을 체크할 때 equals()와 hashCode() 메소드를 사용한다!
		HashSet<Person> set = new HashSet<Person>();

		set.add(new Person("홍길동", 20)); //1
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));
		
		set.add(new Person("홍길동", 25)); //2
		set.add(new Person("홍길동", 20)); //3 내부 데이터는 동일하지만 1번과 다른 사람 취급
		
		System.out.println(set);
	}

	private static void m3() {

		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동", 20)); //1
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));
	
		set.add(new Person("홍길동", 25)); //2
		set.add(new Person("홍길동", 20)); //3 내부 데이터는 동일하지만 1번과 다른 사람 취급
		
		Person p = new Person("하하하", 20);
		set.add(p);
		
		Person p2 = new Person("하하하", 20);
		set.add(p2);
		
		Person p3 = new Person("호호호", 25);
		set.add(p3);
		set.add(p3);

		//홍길동, 하하하는 2번씩 들어가는데 왜 호호호는 1번만?
		//- new의 호출 횟수 (= 객체 생성 횟수 차이)
		
		
		//Set은 객체를 취급할 때 > 메모리에 생성된 인스턴스를 구분한다(주소값을 구분한다)
		//주소값을 확실하게 알아볼 수 있는 방법 > HashCode
		
		System.out.println(p.hashCode()); //1252585652
		System.out.println(p2.hashCode());//2036368507
		System.out.println(set);
		
		//ex) 같은 String 모양은 같은 HashCode를 가진다
		String s1 = "홍길동";
		String s2 = "홍길동";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
	}

	
	
	private static void m2() {
		
		//로또 번호 > 중복되지 않는 난수 생성
		
		//Case 1.
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for (int i=0 ; i<6 ; i++) {
			
			boolean flag = false;
			int n = (int)(Math.random() * 45) + 1;
			
			for (int j=0 ; j<i ; j++) {
				if (lotto.get(j) == n) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				i--;
			} else {
				lotto.add(n);
			}
		}
		
		System.out.println(lotto);
		
	
	
	
		
		
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while (lotto2.size() < 6) {
			int n = (int)(Math.random() * 45) + 1;
			lotto2.add(n);
			
		}
		
		System.out.println(lotto2);
		
	
	}
	
	private static void m1() {
		
		//Collection > List, Set 비교해 보며 알아보기
		
		ArrayList<String> list = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		
		
		//요소 추가하기
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		
		set.add("사과");
		set.add("바나나");
		set.add("딸기");
		
		
		//요소 개수
		System.out.println(list.size());
		System.out.println(set.size());
		
		//덤프
		System.out.println(list);
		System.out.println(set);
		
		//요소 추가하기
		System.out.println(list.add("바나나")); // true
		System.out.println(list);
		
		System.out.println(set.add("바나나"));  // false -> 중복값을 허용하지 않는다
		System.out.println(set);
		
		//요소 삭제
		list.remove(1);
		list.remove("바나나");
		
		set.remove("바나나");
		
		System.out.println(set);
		
		
	}
}


class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("", 0);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		
		//원래 return 하던 것: 자신의 메모리 주소값
		//p1 > "홍길동", 20 > "홍길동20" > 주소값 A
		//p2 > "아무개", 25 > "아무개25" > 주소값 B
		//p3 > "홍길동", 20 > "홍길동20" > 주소값 A
		return (this.name + this.age).hashCode(); 
		
	}
	
	@Override
	public boolean equals(Object obj) {
		//System.out.println(p1.equals(p3));에 true를 반환하도록?
		//this == obj ? 
		
		return this.hashCode() == obj.hashCode();
	}
	
	
	
}
