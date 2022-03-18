package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex25_array {

	public static void main(String[] args) throws Exception {
		
		//Ex25_array.java
		
		/*
		 
		 배열, Array
		 - 자료형
		 - 집합 자료형 > 데이터를 여러 개 저장할 수 있는 자료형
		 - 같은 자료형을 저장하는 집합 > 같은 자료형 변수들의 집합
		 
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		
	}

	private static void m11() { //배열 안의 상태를 확인하는 법 Arrays.toString()

		int[] ns = new int[10];
		
		for (int i=0 ; i<ns.length ; i++) {
			ns[i] = (int)(Math.random() * 10) + 1;
		}
		
		
		//배열 안의 상태를 확인해야 하는 작업
		for (int i=0 ; i<ns.length ; i++) {
			System.out.println(ns[i]);
		}
		
		
		printArray(ns);
		
		System.out.println(dump(ns));
		
		
		//배열의 작업을 도와주는 클래스 > Arrays
		System.out.println(Arrays.toString(ns)); //덤프 메소드
		
	}
	
	public static String dump(int[] ns) { //배열의 상태를 문자열로 바꿔서 반환 > 덤프(dump)
		
		String txt = "[";
		
		for (int i=0 ; i<ns.length ; i++) {
			txt += ns[i] + ",";
		}
		
		txt += "]";
		
		return txt;
		
	}

	private static void m10() { //배열 초기화 리스트

		//배열 초기화 리스트
		
		int[] ns1 = new int[5];
		printArray(ns1); //자동 초기화
		
		//초기화
		ns1[0] = 100;
		ns1[1] = 90;
		ns1[2] = 80;
		ns1[3] = 70;
		ns1[4] = 60;
		printArray(ns1); //사용자 초기화
		
		int[] ns2 = new int[] {100, 90, 80, 70, 60};
		printArray(ns2);
		System.out.println();
		
		int[] ns3 = {100, 90, 80, 70, 60};
		printArray(ns3);
		System.out.println();
		
		
		//FM으로 배열 초기화
		//장점: for문 사용할 수 있다
		String[] name1 = new String[3];
		name1[0] = "홍길동";
		name1[1] = "홍길동";
		name1[2] = "홍길동";
		
		//초기화 리스트
		//길이가 짧으면 편해 보이지만 길면 힘들다. 하드코딩 해야 하기 때문에
		String[] name2 = new String[] {"홍길동", "아무개", "하하하"};
		
	}

	private static void m9() { //배열의 자동 초기화
		
		//배열의 생성 직후 상태
		
		//int a; //null 상태
		//System.out.println(a);
		
		int[] ns = new int[3];
		System.out.println(ns[0]);	//0
		System.out.println(ns[1]);	//0
		System.out.println(ns[2]);	//0
		
		//생성하고 값을 넣은 적이 없는데 출력해 보면 0이?
		//배열의 자동 초기화
		
		//배열(모든 참조형)은 값형과 다르게 생성 직후에 사용자(개발자)가 아무것도 하지 않아도 자동으로 값이 초기화된다
		
		//규칙
		//1. 정수배열 -> 0이 채워진다
		//2. 실수배열 -> 0.0이 채워진다
		//3. 문자배열 -> \0(null)이 채워진다
		//4. 논리배열 -> false
		//5. 모든 참조형 배열 -> null
		
		
		double[] ns2 = new double[3];
		System.out.println(ns2[0]);
		
		boolean[] ns3 = new boolean[3];
		System.out.println(ns3[0]);
		
		String[] ns4 = new String[3];
		System.out.println(ns4[0]);
		
		
	}

	private static void m8() { //얕은 복사와 깊은 복사 / 깊은 복사 방법
		
		
		//배열 복사
		//1. 얕은 복사, Shallow Copy
		//	- 주소값 복사
		//	- Side Effect 발생
		//	- 사용 빈도수 더 높다

		//2. 깊은 복사, Deep Copy
		//	- 요소끼리 복사 > 값복사ㄱ
		//  - Side Effect 발생 X
		
		
		int[] ns = new int[3];
		
		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;
		
		
		
		//깊은 복사 해주려면 길이는 원본과 똑같은 수로 직접 지정해줘야 함
		int[] copy = new int[ns.length]; 
		
		
		for (int i=0 ; i<ns.length ; i++) {
			copy[i] = ns[i];
		}
			//값형 복사 = 깊은 복사
			//int = int
		
			ns[0] = 100;

		//copy = ns;
		//ns[0] = 100;
		
		printArray(ns);
		System.out.println();
		
		printArray(copy);
		System.out.println();
		

		
	}
	
	public static void printArray(int[] ns) { //m8에 사용, 배열을 출력해 주는 메소드
		
		for (int i=0 ; i<ns.length ; i++) {
			System.out.printf("%d번째 방의 값: %d\n", i, ns[i]);
		}
	}

	private static void m7() { //배열의 복사

		//배열 복사 (=참조형 복사)
		
		//복사
		// - 1. 값형 복사
		// - 2. 참조형 복사;
		
		
		//a는 데이터(값) 10이 들어있다.
		int a = 10; //값형(Value Type), 공간 자체에 값을 저장한다
		int b;
		
		
		//값형의 복사 > 공간이 가지는 값 자체를 복사한다.
		b = a;
		
		//원본 수정 > 복사본 영향 없음 > Side Effect가 발생하지 않는다.
		a = 20;
		
		System.out.println("a: " + a); //20
		System.out.println("b: " + b); //10
		
		
		//ns에는 실제 배열의 주소값이 들어있다.
		int[] ns = new int[3]; //참조형, heap이라는 다른 공간의 참조 주소값을 가지고 있는 stack의 변수(Reference Type)
							   //heap에 찾아가서 값을 가져온다 = 참조
		
		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;
		
		
		int[] copy = new int[3];
		
		//int[] = int[], 자료형이 같으면 무조건 복사 ok
		//하지만 참조형 복사 > 데이터(값)이 아니라 주소를 복사한다!
		copy = ns;
		
		//원본 수정 > 복사본 영향 있음 > Side Effect가 발생한다. > 주의! *****
		ns[0] = 100;
		
		System.out.println("ns[0]: " + ns[0]); 		//100
		System.out.println("copy[0]: " + copy[0]); 	//100
		
		
		

		
		
	}

	private static void m6() throws Exception { //불변하는 배열 길이, 정적할당/동적할당

		//프로그램 > 메모리 공간 할당 > 변수 생성
		//******** 메모리 할당 받은 공간의 크기는 불변이다. (************)
		//******** 배열의 길이는 불변이다.
		
		//성적 처리 프로그램
		//- 배열의 길이? > 교장 선생님한테 학생 수를 미리 물어봐야 > 300명 > 320 ~ 330 정도로 여유롭게
		//- 미리 배열 길이의 예측이 필요하다
		
		
		
		//자바 배열의 길이는 불변이지만, 동적할당은 가능하다.
		//정적할당 > 컴파일 때 이미 배열의 길이가 정해짐.
		int[] nums = new int[3];
		
		//동적할당 > 컴파일 때는 배열의 길이를 모름 > 런타임 때 정해짐.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("배열 길이: ");
		
		int length = Integer.parseInt(reader.readLine());
		
		int[] nums2 = new int[length];
		
		System.out.println(nums2.length);
		
	
		
		
	}

	private static void m5() { //자료형별로 배열 만들어 보기

		//정수 배열
		byte[] list1 = new byte[3];
		list1[0] = 10;
		System.out.println(list1[0]);
		
		long[] list2 = new long[3];
		list2[0] = 1000000000000L;
		System.out.println(list2[0]);
		
		
		//실수 배열
		double[] list3 = new double[3];
		list3[0] = 3.141592653;
		System.out.println(list3[0]);
		
		
		//문자 배열(char)
		char[] list4 = new char[3];
		list4[0] = 'A';
		System.out.println(list4[0]);
		
		
		//논리 배열(boolean)
		boolean[] list5 = new boolean[3];
		list5[0] = true;
		System.out.println(list5[0]);
		
		
		//참조형-문자열 배열(String)
		String[] list6 = new String[3];
		list6[0] = "홍길동";
		System.out.println(list6[0]);
		
	}

	private static void m4() { //배열의 error
		
		int[] kors = new int[3];
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		//kors[3] = 70;
		//error message: java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

		for (int i=0 ; i<kors.length ; i++) {
			System.out.printf("kors[%d] = %d\n", i, kors[i]);
		}
		
		

			 	
	}

	private static void m3() { //배열의 구조, 루프+배열

		//- int[] > int 배열
		//- kors > 변수명, 배열명
		//- new > 객체 생성 연산자: 무언가를 만드는 역할, 추후 자세히 알 수 있게 된다
		//- int[3] > 3 > 배열의 길이 > 변수의 개수(개수라는 말은 안 쓴다)

		int[] kors = new int[3];
		
		//배열의 길이 == 방의 개수
		System.out.println(kors.length); //프로퍼티(Property), 필드(field)
		
		
		int index = 0;
		kors[index] = 100; //배열의 0번째 방에 100을 넣어라
		
		index++;
		kors[index] = 90; //배열 1번째 방에 90을 넣어라
		
		
		//배열 방 하나하나 > 요소 (Element)
		//배열 방번호 = 첨자 (index)
		//자바 배열의 방번호는 0부터 시작한다. (=Zero-based Index)
		for (int i=0 ; i<kors.length ; i++) {
			//루프 변수의 변화 = 배열의 첨자 변화
			//이 for문 = 배열의 탐색!
			
			kors[i] = 100;
			
		}
		
		int total = 0;
		
		for (int i=0 ; i<kors.length ; i++)
			
			total += kors[i];
		
		double avg = (double)total / kors.length;
		
		
		
	}

	private static void m2() { //배열이란

		//요구사항] 학생 3명의 국어 점수 관리 > 총점, 평균
		//추가사항] 학생 수 > 300명
		
		//1. 배열 선언하기(생성하기)
		// - 자료형[] 변수명 = new 자료형[길이];
		//2. 배열 사용하기(입/출력)
		
		
		//n의 자료형? int입니다.
		int n = 10;
		
		//kors의 자료형? int[]입니다. 'Integer 배열'입니다.
		//kors[0]의 자료형? 'Integer'입니다.
		int[] kors = new int[300];
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		//..
		kors[299] = 100;
		//변수의 번호 주의할 것, 0부터 시작
	
		
		int total = kors[0] + kors[1] + kors[2]; //+ kors[3] ... + kors[299]
		double avg = total / kors.length; //배열의 길이
	
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
		
		
		
	}

	private static void m1() { //배열이 없다면?

		// ***** 같은 성격의 데이터(데이터의 성격(국어) + int)를 여러개 취급하는 상황
		
		//요구사항] 학생 3명의 국어 점수 관리 > 총점, 평균
		//요구사항 추가] 학생 수 증가 > 300명
		
		int kor1;
		int kor2;
		int kor3;
		//+297
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		//+297
		
		int total = kor1 + kor2 + kor3; //kor4 + kor5 + ... + kor300 > 297
		double avg = total / 3.0; //3.0 -> 300.0
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
		
	}
}
