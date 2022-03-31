package com.test.java.collection;

import java.util.ArrayList;

public class Ex56_ArrayList {

	public static void main(String[] args) {
		
		//"com.test.java.collection" > "Ex56_ArrayList.java"
		
		/*
		  
		 컬렉션, Collection
		 - JCF, Java Collection Framework
		 - (향상된) 배열
		 - 기존의 순수 배열의 성능 향상(입출력), 사용법을 개량 > 클래스
		 - 내부에 순수 배열을 가지고 있다 > public 메소드들을 통해 성능 or 사용법을 개량
		 - 길이 가변 > 방의 개수를 마음대로 늘리고 줄이는 게 가능
		 - 자료구조
		 
		 컬렉션 종류
		 
		 
		 
		 
		 1. List 계열
		 	- ArrayList
		 	- LinkedList (Queue의 껍데기로 쓰이거나, 단독으로 쓰이거나)
		 	- Queue
		 	- Stack
		 	- Vector(legacy)
		 	
		 2. Set 계열
		 	- HashSet
		 	- TreeSet
		 	
		 3. Map 계열
		 	- HashMap
		 	- TreeMap
		 	- Properties(legacy)
		 	- HashTable(legacy)
		 								*legacy > 너무 오래돼서 잘 안 쓰는 종류
		 
		 ArrayList
		 - ArrayList(C) -> List(I) -> Collection(I)
		 - 순수 배열과 구조가 가장 유사함
		 = 사용 빈도가 가장 높다 > 가장 많이 복습!
		 - 첨자(index)를 사용해서 요소(element)에 접근
		 
		  
		 */
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
		
	} //main

	private static void m7() {					//컬렉션 사용의 문제점 2가지와 해결 방법

		//문제점 (1)
		//*** 컬렉션에 반복적응로 데이터를 넣는 행동 > 가변 특성 유지하기 위해 프로그램을 무겁게 한다
		//1. 버려지는 배열 = 쓰레기(Garbage) 발생 > 비용 발생
		//2. 배열 복사 발생 > 비용 발생
		
		//위의 문제점을 해결하는 방법
		//- ArrayList의 초기 길이를 지정할 수 있다
		
		
		ArrayList<Integer> list = new ArrayList<Integer>(10);

		for (int i=0 ; i<10 ; i++) {
			list.add(i);
		}
		
		list.add(5); //11번째 방에 데이터를 넣으려고 시도하면, 20칸으로 늘어남
		//어느 정도 예측해서 초기 길이를 설정해 주는 것이 중요함
 		
		
		//문제점 (2)
		//이 이후로 list에 데이터를 추가할 일이 없을 때? > 9칸이 남는다...!
		//ArrayList는 배열의 길이를 무조건 더블링(2배) 하기 때문에,
		//데이터 1024개가 있다고 할 때, 하나만 더 추가해도 2048칸짜리 배열, 1023칸이 빈 공간으로 남게 됨
		
		list.trimToSize();
		//20칸 -> 11칸으로 줄인다
		//작은 배열로 바꿔치기
		//역시 쓰레기가 발생하므로 데이터를 더 추가할 일이 없다고 확신이 들 때만 호출해야 함
		
		//문제점은 다른 컬렉션에도 적용된다
		
	}

	private static void m6() {
		
		//ArrayList(컬렉션) 특징
		//1. 내부에 배열을 가지고 있다. == ArrayList를 배열이라고 생각하자
		//2. ArrayList 클래스의 대부분 기능이 내부 배열을 조작하는 기능들로 구성
		//3. 길이가 가변 > 데이터를 넣으면.. 계속 공간이 늘어난다?
		
		//1 + 3 = ??? 메모리를 차지한 후에도 길이가 가변일 수 있는 이유는 무엇일까?
		//4칸 -> 공간이 부족하다? 2배 크기의 배열을 만들고 이전의 값을 복사한 후 원래 배열 삭제, 다시 더하기 시작
		//list.length가 아니라 list.size()인 이유, 배열의 길이가 아니라 값이 몇 개인지 카운트
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		

	}

	
	private static void m5() {						//컬렉션 + 성적표 만들기 예제

			
		// 배열 vs ArrayList를 선택?
		// - 길이로 선택!
		// - 학생이 몇 명인지 정확? 고정된 상태 > 배열
		// - 학생이 나중에 줄어들거나 늘어날 수도? > ArrayList
		ArrayList<Student> list = new ArrayList<Student>();
		
		
		
		for (int i=0 ; i<5 ; i++) {
			
			int kor = (int)(Math.random() * 41) + 60;
			int eng = (int)(Math.random() * 41) + 60;
			int math = (int)(Math.random() * 41) + 60;
			
			Student s = new Student("학생" + i, kor, eng, math); //i번째 학생 만들기
			
			list.add(s); //배열에 학생 추가
			
		}
		
		//성적표 출력
		System.out.println("=============================================");
		System.out.println("                    성적표");
		System.out.println("=============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for (Student s : list) {
			
			int total = s.getKor() + s.getEng() + s.getMath();
			double avg = total / 3.0;
			
			System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n", s.getName()
															   , s.getKor()
															   , s.getEng()
															   , s.getMath()
															   , total
															   , avg);
		}
		
		
	}

	private static void m4() {

		//배열(컬렉션)의 요소
		// - 값형 데이터, 문자열
		// - 객체
		
		//System.out.println(clist[0].toString()); //NullPointerException

		//Cup[] clist = new Cup[5]; //2번과 같은 행위
		
		//1. Cup을 5개 만들어라 > 인스턴스(객체)를 5개 만들어라
		Cup c1 = new Cup("", 0);
		Cup c2 = new Cup("", 0);
		Cup c3 = new Cup("", 0);
		Cup c4 = new Cup("", 0);
		Cup c5 = new Cup("", 0);
		
		//2. Cup을 담을 수 있는 방을 5개 만들어라
		Cup p1;
		Cup p2;
		Cup p3;
		Cup p4;
		Cup p5;
		
		Cup[] clist = new Cup[5];  // 배열 생성
		
		clist[0] = new Cup("", 0); // 진짜 컵 객체 생성
		clist[1] = new Cup("", 0);
		clist[2] = new Cup("", 0);
		clist[3] = new Cup("", 0);
		clist[4] = new Cup("", 0);
		
		
		ArrayList<Cup> list = new ArrayList<Cup>();
		
		list.add(new Cup("", 0)); //1번째 컵
		list.add(new Cup("", 0)); //2번째 컵
		list.add(new Cup("", 0)); //3번째 컵
		list.add(new Cup("", 0)); //4번째 컵
		list.add(new Cup("", 0)); //5번째 컵
		
		
		for (int i=0 ; i<clist.length ; i++) {
			System.out.println(clist[i]);
		} System.out.println();
		
		for (Cup cup : clist) {
			System.out.println(cup);
		} System.out.println();
		
		for (int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		} System.out.println();
		
		for (Cup cup : list) {
			System.out.println(cup);
		} System.out.println();
		
		
		
		
		
	}

	private static void m3() {			//다차원 배열, 다차원 컬렉션
		
		int[]     ns1 = new int[3];
		int[][]   ns2 = new int[2][3];
		int[][][] ns3 = new int[2][3][3];
		
		// = ns1 : 1차원 정수 배열
		ArrayList<Integer> ms1 = new ArrayList<Integer>();
		
		
		// = ns2 : 2차원 정수 배열
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>();
		
		
		// = ns3 : 3차원 정수 배열
		ArrayList<ArrayList<ArrayList<Integer>>> ms3
			= new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		
		//2차원 배열 초기화
		ns2[0][0] = 10;
		
		//2차원 컬렉션의 초기화
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		ms2.add(list);
	}

	private static void m2() {			//ArrayList 사용법 - 메소드 10개
		
		//ArrayList 사용법
		
		ArrayList<String> list = new ArrayList<String>(); //문자열 배열
		
		//1. 요소 추가하기
		// - boolean add(T value)
		//    > 넣는 것 성공하면 true, 실패하면 false.. 반환 받을 일은 거의 없다
		// - 배열의 맨 마지막에 추가하기(이어 붙이기) > Append Mode
		
		list.add("바나나");
		list.add("딸기");
		list.add("포도");
		list.add("귤");
		list.add("사과");
		list.add("파인애플");
		
		
		
		//2. 요소의 개수
		// - int size()
		System.out.println(list.size());
		
		
		
		//3. 요소의 접근
		// - T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(4));
		//System.out.println(list.get(5)); //IndexOutOfBoundsException
		System.out.println(list.get(list.size() - 1)); //마지막 요소
		
		
		
		//4. 요소의 수정
		// - list[0] = 10; (배열은 대입, 수정을 동일한 표현법으로)
		// - T set(int index, T newValue)
		//2번째 방을 포도 -> 파인애플
		String temp = list.set(2, "파인애플"); 
		System.out.println(temp); //포도
		System.out.println(list.get(2)); //파인애플
		System.out.println();
		
		
		//5. 요소의 삭제
		// - 순수 배열은 요소 삭제 불가능
		// - 컬렉션은 요소 삭제 가능
		// - T remove(int index) > 방번호를 찾아서 삭제
		// - boolean remove(T value) > 값을 찾아서 삭제 > 처음 만나는 요소만 삭제
		// - ********** 시프트가 발생한다! > 삭제된 방 이후의 모든 요소는 모두 방번호 -1
		
		// 둘 중 하나
		//list.remove(2);
		list.remove("파인애플");
		
		for (int i=0 ; i<list.size() ; i++) {
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		
		//-> 파인애플이 2개 들어있다면? 첫 번째 파인애플만 지운다
		
		
		
		//6. 탐색
		// - 루프
		for (int i=0 ; i<list.size() ; i++) {
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println();
		
		//반복문 > for, while, do while, >>for<<
		
		//for (변수 : 배열(or 컬렉션)) {
		//}
		//루프 변수에 의해 통제당했던 기존 for문에 비해, 배열(컬렉션)의 처음부터 끝까지 루프
		//But 첨자에 따라 통제 불가능 (ex 홀수번째 방, 짝수번째 방..등등)
		
		for (String item : list) {
			System.out.println(item);
		}
		
		System.out.println();
		
		
		//7. 요소의 추가
		// - 배열의 원하는 위치에 요소를 추가(삽입) > Insert Mode
		// - void add(int index, T value)
		// - 1. 요소 추가의 오버로딩	
		// - ********** 시프트가 발생한다! > 삽입된 방 이후의 모든 요소는 모두 방번호 +1
		
		list.add(2, "망고");
		
		for (String item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		
		
		//8. 요소의 검색
		// - int indexOf(T value)
		// - int lastIndexOf(T value)
		// - boolean contains(T value)
		
		System.out.println(list.indexOf("사과"));
		System.out.println(list.contains("사과"));
		
		
		
		//9. 초기화
		// - 모든 요소 삭제 > list.remove() for문으로 모든 방 삭제 돌리는 것과 같다
		// - void clear()
		
		list.clear();
		System.out.println(list.size());

		
		
		//10. 빈배열 확인
		System.out.println(list.size() == 0);
		System.out.println(list.isEmpty());
	
	}

	private static void m1() { 			//ArrayList, ArrayList와 배열 비교
		
		//ArrayList list1 = new ArrayList();
		
		//순수 배열
		// - 타입 명시(int)
		// - 길이 명시(3)
		int[] num1 = new int[3];
		
		//요소 접근 > 첨자(index) 사용
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		
		//식별자[첨자] (첨자를 표기해서 배열에 접근하는 표기법) ->  인덱서 (Indexer)
		System.out.println(num1[0]);	
		System.out.println(num1[1]);
		System.out.println(num1[2]);
		
		System.out.println(num1.length);
		System.out.println();
		
		
		//컬렉션
		// - 타입 명시(<Integer>) > 제네릭
		// - 길이 명시 > ??? > 가변이기 때문에
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		//요소 접근 > 첨자? > Append > 차례대로 마지막 방에 넣어라
		//인덱서 지원 X, add/get 메소드 이용
		list1.add(10); //0번째 방 추가 			//add 메소드
		list1.add(20); //1번째 방 추가
		list1.add(30); //2번째 방 추가
		
		System.out.println(list1.get(0)); 		//get 메소드
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		System.out.println(list1.size()); //3	//size 메소드 (길이 확인)
		
		list1.add(40);
		list1.add(50);
		
		System.out.println(list1.size()); //5
		System.out.println();
		
		for (int i=0 ; i<list1.size() ; i++) {
			System.out.println(list1.get(i));
		}
		
		
		
		
	}


} //Ex56


class Cup {
	
	private String color;
	private int price;

	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cup [color=" + color + ", price=" + price + "]";
	}
	
}


class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	
}

//Member m = new Member();

class Member {
	
	private int a;
	private String b;
	private int[] c;
	public Member() {
		a = 10;
		b = "홍길동";
		c = new int[5];
	}
}
