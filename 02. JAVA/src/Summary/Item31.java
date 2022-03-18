package com.test.java;

public class Item31 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열, array (2022. 3. 18. 오후 8:08:39)
		
		//배열 선언(생성하기)
		
		int[] kors = new int[300];
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		//...
		kors[299] = 100;

		//길이가 300이면 첨자(인덱스)는 0부터 299까지 
		
	
		//초기화 리스트를 이용해 선언과 동시에 값 대입하기
		int[] nums = { 1, 2, 3, 4, 5 };
		
		
		
		
		
		//자료형별 배열 예시
		
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
}
