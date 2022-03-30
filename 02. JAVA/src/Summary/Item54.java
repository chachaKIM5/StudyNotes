package com.test.java;

import java.util.ArrayList;

public class Item54 {

	public static void main(String[] args) {
		
		//[SUMMARY] 다차원 컬렉션 (2022. 3. 30. 오후 11:44:24)
		
		
		//2차원 정수 컬렉션 만들기
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>();
		
		//3차원 정수 컬렉션 만들기
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		
		//2차원 컬렉션의 초기화
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		ms2.add(list);
		
	}
}
