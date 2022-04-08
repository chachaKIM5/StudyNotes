package com.test.java;

import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class Item67 {

	public static void main(String[] args) {
		
		//[SUMMARY] TreeMap, TreeSet (2022. 4. 9. 오전 12:17:31)
		
		/*
		 
		TreeMap
    	- 이진트리 구조의 Map
    	- HashMap처럼 키+값 형태의 배열
    	- HashMap + 자동 정렬 기능+ 범위 검색(추출)
		  
		TreeSet
    	- 이진트리 구조의 Set
    	- HashMap처럼 중복값 비허용, 방 번호 없는 배열
    	- HashMap + 자동 정렬 기능+ 범위 검색(추출)
		
		 */
		
		TreeMap<String,String> map = new TreeMap<String,String>();

		map.put("white", "흰색");
		map.put("black", "검은색");
		map.put("yellow", "노란색");
		map.put("red", "빨간색");
		map.put("blue", "파란색");
		System.out.println(map);
		//{black=검은색, blue=파란색, red=빨간색, white=흰색, yellow=노란색}

		System.out.println(map.firstKey()); //black
		System.out.println(map.lastKey());  //yellow
		System.out.println(map.firstEntry()); //black=검은색
		System.out.println(map.lastEntry()); //yellow=노란색

		//매개변수를 기준으로 정렬된 값을 나눠준다
		System.out.println(map.headMap("m")); //{black=검은색, blue=파란색}
		System.out.println(map.tailMap("m")); //{red=빨간색, white=흰색, yellow=노란색}
		System.out.println(map.subMap("r", "w")); //{red=빨간색}
	
	
		
		
		
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random rnd = new Random();
		
		while (set.size() < 20) {
			set.add(rnd.nextInt(100));	
		}
		//무조건 값이 20개가 될 때까지 루프

		System.out.println(set);
		//[8, 12, 14, 20, 21, 24, 26, 30, 32, 38
		//, 42, 43, 48, 50, 65, 66, 70, 80, 86, 91]

		System.out.println(set.first());		//first() 제일 작은 값 > 8
		System.out.println(set.last());		    //last() 제일 큰 값 > 91
		System.out.println(set.headSet(30));	//headSet() 30 > 값 범위추출 //[8, 12, 14, 20, 21, 24, 26]
		System.out.println(set.tailSet(70));	//tailSet() 70 <= 값 범위추출 //[70, 80, 86, 91]
		System.out.println(set.subSet(30, 70)); //subSet() 30 <= 값 < 70 //[30, 32, 38, 42, 43, 48, 50, 65, 66]
	
	}
	
}
