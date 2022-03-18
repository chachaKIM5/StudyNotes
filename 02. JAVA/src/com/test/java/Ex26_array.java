package com.test.java;

import java.util.Arrays;

public class Ex26_array {

	public static void main(String[] args) {
		
		//Ex26_array.java
		
		//정렬, Sort
		//1. 오름차순 정렬
		//2. 내림차순 정렬
		
		//숫자 > 우위 비교
		//문자 > 문자 코드값 비교
		
		//배열 = 순서가 있는 집합
		
		//정렬하는 방법
		//1. 직접 구현
		// - 수많은 정렬 알고리즘 > 10여가지
		// - 버블 정렬 (가장 쉬운 알고리즘 중 하나!)
		//2. 구현된 기능 활용(JDK) > Quick Sort
		
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}//main

	
	private static void m4() { //JDK의 Quick sort 메소드로 (간단하다!)
	
		int[] nums = { 5, 3, 1, 4, 2 };

		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		
		System.out.println(Arrays.toString(name));
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		//내림차순은 추후에 배우는 기능으로 할 수 있다
		
	}
	
	private static void m3() { //이름 배열을 가나다순 정렬하기 (compareTo 메소드와 버블정렬)

		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		System.out.println(Arrays.toString(name)); //정렬 전
		
		for (int i=0 ; i<name.length-1 ; i++) {
			for (int j=0 ; j<name.length-1-i ; j++) {
				
				//** 비교?
				if (name[j].compareTo(name[j+1]) > 0) {
					
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(name));
		
	}

	private static void m2() { //이름 두 개 비교하기 (if문과 compareTo 메소드)
		
		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		//모든 참조형은 산출(비교)연산자의 피연산자가 될 수 없다.
		//if (name[0] < name[1]) {}
		
		String name1 = "유재석";
		String name2 = "김형돈";
		
		String result = "";
		
		
		//***** 문자열의 우위 비교는 문자열 내 문자들의 문자 코드값을 비교한다
		
		
		for (int i=0 ; i<3 ; i++) {
			char c1 = name1.charAt(i);
			char c2 = name2.charAt(i);
			
			if (c1 > c2) {
				result = name1;
				break; //다음 글자는 비교할 필요 없기 때문에 break;로 for문 탈출
			} else if (c1 < c2) {
				result = name2;
				break;
			}
		} System.out.println(result);
		
		
		//Method를 이용해서 간단하게 하기, name1 > name2 ?
		
		String name3 = "나나나";
		String name4 = "가가가";
		
		//name 원본 > name 비교 대상: 양수 반환
		//name 원본 < name 비교 대상: 음수 반환
		//name 원본 = name 비교 대상: 0 반환
		System.out.println(name3.compareTo(name4));
		System.out.println(name4.compareTo(name3));
	}

	private static void m1() { //버블 정렬의 원리

		int[] nums = { 5, 3, 1, 4, 2 };
		
		//오름차순 정렬 > { 1, 2, 3, 4, 5 } 재배치
		
		//버블 정렬
		//i=(0) > j (0  1  2  3)
		//i=(1) > j (0  1  2)
		//i=(2) > j (0  1)
		//i=(3) > j (0)
		
		System.out.println(Arrays.toString(nums));

		for (int i=0 ; i<nums.length-1 ; i++) {				//Cycle
			
			for (int j=0 ; j<nums.length-i-1 ; j++) {		//Step
				
				if (nums[j] > nums[j+1]) { //오름차순 정렬
			  //if (nums[j] < nums[j+1]) { //내림차순 정렬
					
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			
		}
		System.out.println(Arrays.toString(nums));
		
	}
}
